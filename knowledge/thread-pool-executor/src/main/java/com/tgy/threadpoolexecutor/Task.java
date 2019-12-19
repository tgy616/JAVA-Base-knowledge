package com.tgy.threadpoolexecutor;

/**
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-12-11 15:25
 **/

public class Task implements Runnable {

    private int nov;

    public Task(int i){
        this.nov=i;
    }

    @Override
    public void run() {
        System.out.println("执行当前任务的线程是："+Thread.currentThread().getName());
        System.out.println("我是任务："+nov+"我在执行。。。");
        //run方法执行完，这里是不是thread   game over
    }
}
