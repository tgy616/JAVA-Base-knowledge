package com.tgy.classloaderdemo.Test;

/**
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-12-12 15:21
 **/

public class Test {

    public Test(){
        System.out.println(this.getClass().getClassLoader().toString());
    }

    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        try {
            Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("com.tgy.classloaderdemo.Test.Test1");
            //Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("java.lang.String");//Bootstrap
            System.out.println(clazz.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
