package com.tgy.oom;

/**
 * oom
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2020-03-10 17:08
 **/

public class Test {
    private void dontStop() {
        while(true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static  void main(String[] args) {
        Test oom = new Test();
        oom.stackLeakByThread();
    }
}
