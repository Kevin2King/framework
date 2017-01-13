package com.funtl.framework.rpc.thrift.generator.test;

import com.funtl.framework.rpc.thrift.generator.builder.ThriftFileBuilder;

import org.junit.Test;

/**
 * Thrift脚本生成工具
 * Created by 李卫民 on 2016/9/5.
 */
public class CreateThriftScript {
    private ThriftFileBuilder fileBuilder = new ThriftFileBuilder();

    @Test
    public void createHelloThrift() throws Exception {
        this.fileBuilder.buildToOutputStream(HelloThrift.class, System.out);
    }
}
