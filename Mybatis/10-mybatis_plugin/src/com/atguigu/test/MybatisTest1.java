package com.atguigu.test;

import org.junit.Test;


/**
 *@ClassName MybatisTst
 *@Description  TODO
 *@Author hqb
 *@Date 2021/9/10 15:30
 *@Version 1.0
 */
public class MybatisTest1 {

    /**
     * 插件原理：
     * 在四大对象创建出来的时候
     * 1、每个创建出来的对象不是直接返回的，而是
     *                                      interceptorChain.pluginAll(parameterHandler);
     * 2、获取所有的Interceptor（拦截器）（插件需要实现接口）
     * 3、插件机制，我们可以使用插件为目标对象创建一个代理对象：通过AOP(面向切面)
     *          我们的插件可以为四大对象创建出代理对象：
     *          代理对象就可以拦截到四大对象的每一个执行：
     *
     *
     *         public Object pluginAll(Object object){
     *         for (Interceptor interceptor : interceptors){
     *           target = interceptor.plugin(target);
     *         }
     *         return target;
     *     }
     *
     */


    /**
     * 插件编写：
     *  1、编写Interceptor的实现类
     *  2、使用@Intercepts主键完成插件的签名
     *  3、将写好的插件主导
     *
     */
    @Test
    public void testPlugin(){

    }

}

