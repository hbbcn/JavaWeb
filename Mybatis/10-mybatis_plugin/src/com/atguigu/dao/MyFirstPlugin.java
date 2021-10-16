package com.atguigu.dao;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import javax.sound.midi.Soundbank;
import java.sql.Statement;
import java.util.Properties;

/**
 *@ClassName MyFirstPlugin
 *@Description  TODO
 *@Author hqb
 *@Date 2021/9/10 15:43
 *@Version 1.0
 */

//完成插件的签名：告诉Mybatis当前插件用来拦截哪个对象的哪个方法
@Intercepts(
 {
   @Signature(type = StatementHandler.class,method = "parameterize",args = Statement.class)
 }
)
public class MyFirstPlugin implements Interceptor {

    /**
     * intercept:拦截
     *      拦截目标对象的目标方法的执行
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        System.out.println("MyFirstPlugin...intercept:" +invocation.getMethod());
       //动态的改变一下sql运行参数，以前1号员工，实际从数据库查询3号员工
        Object target = invocation.getTarget();
        System.out.println("当前截到的对象：" + target );
        //拿到：StatementHandler===>ParameterHandler===>parameterObject
        //拿到target的元数据
        MetaObject metaObject = SystemMetaObject.forObject(target);
        Object value = metaObject.getValue("parameterHandler.parameterObject");
        System.out.println("sql语句运行的参数是什么" + value);
        metaObject.setValue("parameterHandler.parameterObject",5);
        //执行目标方法
        Object proceed = invocation.proceed();
        return proceed;
    }

    /*
        plugin:
            包装目标对象：包装就是为目标对象创建一个代理对象
     */
    @Override
    public Object plugin(Object target) {

        System.out.println("MyFirstPlugin....plugin:mybatis将要包装的对象" + target);
        //我们可以借助Plugin的wrap方法来使用当前Interceptor包装我们目标对象
        Object wrap = Plugin.wrap(target, this);
        //返回当前target创建的动态代理
        return wrap;
    }

    /*
        setProperties
                将插件注册时的property属性设置进来
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("配置插件的信息" + properties);
    }
}

