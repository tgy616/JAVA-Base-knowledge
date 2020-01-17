package com.tgy.singleton;

/**
 * 静态内部类的方式 加载的安全的单例模式
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2020-01-16 14:29
 **/

public class Holder {
    private Holder() {
    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    private static class InnerClass{
        private static final Holder HOLDER=new Holder();
    }
}
