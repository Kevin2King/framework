/*
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.funtl.framework.rpc.thrift.spring;

import java.lang.reflect.InvocationTargetException;

import com.funtl.framework.apache.httpclient.HttpClientUtil;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.thrift.TApplicationException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.remoting.RemoteLookupFailureException;
import org.springframework.remoting.RemoteProxyFailureException;
import org.springframework.remoting.support.UrlBasedRemoteAccessor;

/**
 * Author: Lusifer
 * <p>
 * //# 将thrift的代理调用改为局部变量的形式，解决多线程时序列"溢出"的问题
 */
public class ThriftClientInterceptor extends UrlBasedRemoteAccessor implements MethodInterceptor {
	private TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();

	HttpClientUtil httpClientUtil;
	private static final int CONECTION_TIME_OUT = 30 * 1000; //# 链接超时时间阈值
	private static final int SOCKET_TIME_OUT = 30 * 1000; //# socket read 时间超时阈值

	@Override
	public void afterPropertiesSet() {
		super.afterPropertiesSet();

		if (getServiceInterface() == null) {
			throw new IllegalArgumentException("property serviceInterface is required.");
		}

		prepare();
	}

	/**
	 * Initialize the Hessian proxy for this interceptor.
	 *
	 * @throws RemoteLookupFailureException if the service URL is invalid
	 */
	public void prepare() throws RemoteLookupFailureException {
		if (httpClientUtil == null) {
			this.httpClientUtil = new HttpClientUtil(CONECTION_TIME_OUT, SOCKET_TIME_OUT);
		}
	}

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

		Object thriftProxy = ThriftUtil.buildClient(getServiceInterface(), protocolFactory.getProtocol(getTransport()));

		ClassLoader originalClassLoader = overrideThreadContextClassLoader();
		try {
			return methodInvocation.getMethod().invoke(thriftProxy, methodInvocation.getArguments());
		} catch (InvocationTargetException e) {
			Throwable targetEx = e.getTargetException();
			if (targetEx instanceof InvocationTargetException) {
				targetEx = ((InvocationTargetException) targetEx).getTargetException();
			}
			if (targetEx instanceof TApplicationException && ((TApplicationException) targetEx).getType() == TApplicationException.MISSING_RESULT) {
				return null;
			} else {
				throw targetEx;
			}
		} catch (Throwable ex) {
			throw new RemoteProxyFailureException("Failed to invoke Thrift proxy for remote service [" + getServiceUrl() + "]", ex);
		} finally {
			resetThreadContextClassLoader(originalClassLoader);
		}
	}

	protected TTransport getTransport() throws TTransportException {
		return new THttpClient(getServiceUrl(), httpClientUtil.getHttpClient());
	}

	public void setHttpClientUtil(HttpClientUtil httpClientUtil) {
		this.httpClientUtil = httpClientUtil;
	}
}
