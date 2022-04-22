package com.atguigu.admin;

import lombok.ToString;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 *@ClassName Junit5Tst
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/8 15:17
 *@Version 1.0
 */

/**
 * @DisplayName： 为测试类或者测试方法设置展示名称
 * @BeforeEach: 表示在每个单元测试之前执行
 * @AfterEach: 表示在每个单元测试之后执行
 * @BeforAll: 表示在所有单元测试之前执行
 * @AfterAll: 表示在所有单元测试之后执行
 * @TimeOut: 表示测试方法运行如果超过指定时间将会返回错误
 * @ExtendWith: 为测试类或测试方法提供扩展功能
 *
 */

/**
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith({SpringExtension.class})
 */
@SpringBootTest
@DisplayName("Junit5功能测试类")
public class Junit5Test {


    /**
     * 测试前置条件
     */
    @DisplayName("测试前置条件")
    @Test
    void testAssumptions(){

        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println("!!!!!");
    }


    @DisplayName("组合断言")
    @Test
    void all(){
        /**
         * 所有断言全部需要成功
         */
        assertAll("test",
                ()-> assertTrue(true && false,"结果不为true"),
                ()-> assertEquals(1,2,"结果不是1"));

        System.out.println("======");
    }

    @DisplayName("异常断言")
    @Test
    void testException(){

        //断定业务逻辑一定出现异常
        assertThrows(ArithmeticException.class,()->{
            int i = 10 / 1;
        },"业务逻辑居然正常运行");
    }

    @DisplayName("快速失败")
    @Test
    void testFail(){
        //XXXX
        if (1 == 2){
            fail("测试失败");
        }
    }

    @Test
    @DisplayName("array assertion")
    void array(){
        assertArrayEquals(new int[]{1,2},new int[]{2,2},"数组内容和不一样");
    }


    /**
     * 断言：前面断言失败，后面代码都不会执行
     */
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){
        int cal = cal(2, 3);
        assertEquals(5,cal,"业务逻辑计算失败");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1,obj2,"两个对象不一致");
    }

    int cal(int i, int j){
        return i+j;
    }

    @DisplayName("测试displayname注解")
    @Test
    public void testDisplayName(){

        System.out.println(1);
    }

    @Disabled
    @DisplayName("测试方法2")
    @Test
    void test2(){
        System.out.println(2);
    }

    @RepeatedTest(5)
    void test3(){
        System.out.println(4);
    }
    /**
     * 规定超时时间，超出时间测试出异常
     * @throws InterruptedException
     */
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {

        Thread.sleep(600);
    }


    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试就要开始了");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束啦");
    }

    @BeforeAll
   static void testBeforeAll(){
        System.out.println("所有测试就要开始了....");
    }

    @AfterAll
  static   void testAfterAll(){
        System.out.println("所有测试就要结束啦");
    }
}