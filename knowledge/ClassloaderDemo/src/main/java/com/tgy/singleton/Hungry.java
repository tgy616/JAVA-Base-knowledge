package com.tgy.singleton;

/**
 * 恶汉式
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2020-01-16 13:57
 **/

public class Hungry {

    private byte[] data1=new byte[1024];
    private byte[] data2=new byte[1024];
    private byte[] data3=new byte[1024];
    private byte[] data4=new byte[1024];

    private Hungry(){//防止new对象

    }
    private final static Hungry HUNGRY=new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }
}
