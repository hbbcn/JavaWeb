package com.hbb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@ClassName A
 *@Description  TODO
 *@Author hqb
 *@Date 2022/4/28 12:56
 *@Version 1.0
 */
/*
在对象A创建过程中，需要注入B，因为容器中没有B，则去创建B，B创建过程中又需要注入A，
而A在等待B的创建，B在等待A的创建，导致两者都无法创建成功，无法加入到单例池供用户使用。

Spring则通过三级缓存来解决循环依赖的问题，另外如果对象的作用范围是Prototype，
则无法通过三级缓存解决循环依赖，会抛出BeanCurrentlyInCreationException异常，
构造注入的方式，也无法解决循环依赖，只有set注入可以解决。

Spring Bean对象从创建到初始化大致会经过四个流程
getSingleton()、doCreateBean()、populateBean()、addSingleton()
    getSingleton：从单例池中获取bean对象，如果没有，则进行创建
    doCreateBean()：创建bean对象
    populateBean()：填充依赖，如果被填充的对象不存在于单例池，则进行创建等四个流程
    addSingleton()：将初始化完成的对象加入到单例池

循环依赖的对象在三级缓存中的迁移过程
    A 创建过程中需要 B， 于是 A 将自己放到三级缓存里面，去实例化 B
    B 实例化的时候发现需要 A，于是 B 先查一级缓存，没有，再查二级缓存，
    还是没有，再查三级缓存找到了A，然后把三级缓存中的 A 放到二级缓存，并删除三级缓存中的 A
    B 顺利初始化完毕，将自己放到一级缓存中(此时 B 中的 A 还是创建中状态
    ，并没有完全初始化)，删除三级缓存中的 B然后接着回来创建 A，此时 B 已经完成创建，
    直接从一级缓存中拿到 B，完成 A 的创建，并将 A 添加到单例池，删除二级缓存中的 A


 */
@Component
public class A{
    @Autowired
    B b;
}

