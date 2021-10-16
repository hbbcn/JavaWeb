package com.atguigu.dao;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

/**
 *@ClassName MysecondPlugin
 *@Description  TODO
 *@Author hqb
 *@Date 2021/9/10 17:23
 *@Version 1.0
 */
//完成插件的签名：告诉Mybatis当前插件用来拦截哪个对象的哪个方法
@Intercepts(
        {
                @Signature(type = StatementHandler.class,method = "parameterize",args = Statement.class)
        }
)
public class MySecondPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MySecondPlugin...intercept" + invocation.getMethod());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        System.out.println("MySecondPlugin...plugin" + o);
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}

