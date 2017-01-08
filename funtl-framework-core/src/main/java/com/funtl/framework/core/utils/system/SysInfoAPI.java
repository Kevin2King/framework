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

package com.funtl.framework.core.utils.system;

import java.text.DecimalFormat;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * 系统信息API
 * Created by 李卫民 on 2016/5/14.
 *
 * @see SysInfo
 */
public class SysInfoAPI {
	private static DecimalFormat df = new DecimalFormat("#0.00");

	/**
	 * 物理内存总量
	 */
	public static long getMemoryTotal() throws SigarException {
		Sigar sigar = new Sigar();
		Mem mem = sigar.getMem();
		return mem.getTotal() / 1024 / 1024;
	}

	/**
	 * 已用物理内存
	 */
	public static long getMemoryUsed() throws SigarException {
		Sigar sigar = new Sigar();
		Mem mem = sigar.getMem();
		return mem.getUsed() / 1024 / 1024; // MB
	}

	/**
	 * 物理内存使用率
	 */
	public static double getMemoryPercent() throws SigarException {
		Sigar sigar = new Sigar();
		Mem mem = sigar.getMem();
		return new Double(df.format(mem.getUsedPercent()));
	}

	/**
	 * CPU总使用率
	 */
	public static double getCpuCombined() throws SigarException {
		Sigar sigar = new Sigar();
		CpuPerc cpuPerc = sigar.getCpuPerc();
		return new Double(df.format(cpuPerc.getCombined() * 100));
	}
}
