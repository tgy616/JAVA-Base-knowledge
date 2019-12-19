package com.tgy.knowledge;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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

        //java线程是依赖于底层操作系统，是基于KLT
        for (int i=0;i<300;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
            //线程池使用方式
            ThreadPoolExecutor pool=new ThreadPoolExecutor(5,10,60,
                    TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5), Executors.defaultThreadFactory());
        }
    }
}
