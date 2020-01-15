package com.tgy.jvm;

/**
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-12-30 14:19
 **/

public class TestDemo implements Runnable {
    @Override
    public void run() {
        // 加锁操作
        synchronized (this) {
            System.out.println("hello");
            System.out.println("亲，优惠礼包已经被瓜分完毕了 \n  下次要积极一点哟！");
        }
    }

    public static void main(String[] args) {
        TestDemo test = new TestDemo();
        Thread thread = new Thread(test);
        thread.start();
    }
}
