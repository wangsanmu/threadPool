package com.wangsen.proxy;

/**
 * @author wangsen
 * @data 2018/4/18 11:33
 * @des
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
