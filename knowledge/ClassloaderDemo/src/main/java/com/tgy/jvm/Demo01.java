package com.tgy.jvm;

/**
 * jvm  demo
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-12-23 16:02
 **/

public class Demo01 {
    public static void main(String[] args) {

        Object o=new Object();
        Demo01 demo01=new Demo01();

        //根加载器（启动类加载器）
        //扩展类加载器
        //系统加载器（应用程序类加载器）

        //获取类加载器
        System.out.println(o.getClass().getClassLoader());//java 触碰不到
        System.out.println(demo01.getClass().getClassLoader());//AppClassLoader
        System.out.println(demo01.getClass().getClassLoader().getParent());//ExtClassLoader


        new Thread(()->{

        }).start();
        // private native void start0();（tomcat是反的，是start0不是本地方法）
        //JNI Java本地方法接口
        //凡是带了native关键字，说明Java程序触及不到，就会进入本地方法栈

    }
}
