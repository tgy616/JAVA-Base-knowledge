package com.tgy.knowledge;

/**
 * jvm test
 * 测试：java.lang.StackOverflowError
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-08-29 15:57
 **/

public class JVMTest {


    private void test(){
        System.out.println("等待：JVM栈方法溢出。。。。");
        test();
    }

    public static void main(String[] args) {
        new JVMTest().test();
    }
}
