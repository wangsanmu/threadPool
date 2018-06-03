package com.wangsen.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangsen
 * @data 2018/4/18 11:30
 * @des
 */
public class HelloServiceProxy implements InvocationHandler {

    private Object target;
    /**
     * 绑定委托对象并返回一个【代理占位】
     * @param target 真实对象
     * @return  代理对象【占位】
     */
    public  Object bind(Object target, Class[] interfaces) {
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("############我是JDK动态代理################");
        Object result = null;
        //反射方法前调用
        System.err.println("我准备说hello。");
        //反射执行方法  相当于调用target.sayHelllo;
        result=method.invoke(target, args);
        //反射方法后调用.
        System.err.println("我说过hello了");
        return result;
    }

    public static void main(String[] args) {
        HelloServiceProxy proxy = new HelloServiceProxy();
        HelloService service = new HelloServiceImpl();
        //绑定代理对象。
        service = (HelloService) proxy.bind(service, new Class[] {HelloService.class});
        //这里service经过绑定，就会进入invoke方法里面了。
        service.sayHello("张三");
    }
}
