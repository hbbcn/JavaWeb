package com.atguigu.niuke;
/**
 *@ClassName Test02
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/15 20:27
 *@Version 1.0
 */

/*
    1、私有方法不能被重写,此方法只属于这个类的
*   2、如果父类的方法不是私有的，子类方法名和父类方法名只要相同，子类就需要重写父类方法，则返回类型一定相同
*   子类的方法权限修饰符必须大于或者等于父类方法的权限修饰符
*   3、重载方法名相同，返回类型可以相同也可以不相同(不能通过返回类型判断是否重载)，参数类型不同或参数个数不同
*   参数顺序不同。
*
*
**/

public class Test02{

   String find(){

        return null;
    }

}

class A extends Test02{
    public String find(){

        return null;
    }

    public int find(int i, String name){

        return i;
    }

    public String find(String name, int i){

        return name;
    }



}

