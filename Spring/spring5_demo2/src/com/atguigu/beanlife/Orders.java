package com.atguigu.beanlife;
/**
 *@ClassName Orders
 *@Description
 *
 *  bean生命周期
 *      1、通过无参构造器创建bean实例
 *      2、为bean的属性设置值和其他bean引用(调用set方法)
 *      3、调用bean的初始化方法(需要进行配置)
 *      4、通过getBean获取对象
 *      5、当容器关闭的时候，调用bean的销毁的方法(需要进行配置)
 *
 * 加上后置处理器后bean生命周期一共是七步
 *      1、通过无参构造器创建bean实例
 *      2、为bean的属性设置值和其他bean引用(调用set方法)
 *      3、把bean实例传递bean后置处理器的方法
 *      4、调用bean的初始化方法(需要进行配置)
 *      5、把bean实例传递bean后置处理器的方法
 *      6、通过getBean获取对象
 *      7、当容器关闭的时候，调用bean的销毁的方法(需要进行配置)
 *
 *
 *@Author HuangQingbin
 *@Date 2021/8/12 16:50
 *@Version 1.0
 */
public class Orders{

    private String oname;

    public Orders() {
        System.out.println("第一步 执行无参构造器创建bean实例");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步，调用set方法设置属性值");
    }

    //创建执行的初始化的方法
    public void initMethod(){
        System.out.println("第三步 执行初始化方法");
    }

    public void destroyMethod(){
        System.out.println("第五步 执行销毁的方法");
    }
}

