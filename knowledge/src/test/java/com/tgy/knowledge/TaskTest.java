package com.tgy.knowledge;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors导致oom问题测试
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-11-28 14:38
 **/

public class TaskTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        int i = 0;
        while (true) {
            es.submit(new Task(i++));
        }
    }

    private static class Task implements Runnable {
        public Task(int i) {
            new Thread(() -> {
                List<byte[]> list = new ArrayList<byte[]>();
                while (true) {
                    System.out.println(new Date().toString() + Thread.currentThread() + "==");
                    byte[] b = new byte[1024 * 1024 * 1];
                    for (int k=0;k<5;k++){
                        b[k]= (byte) k;
                    }
                    list.add(b);
                    System.out.println(list.toString());
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        @Override
        public void run() {

        }
    }
}
