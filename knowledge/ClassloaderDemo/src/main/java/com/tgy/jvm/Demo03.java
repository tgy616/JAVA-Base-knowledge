package com.tgy.jvm;

import java.util.Random;

/**
 *  堆内存溢出
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2020-01-15 16:37
 **/

public class Demo03 {
    public static void main(String[] args) {
        String test="hello ...";
        while (true){
            test+=test+new Random().nextInt(88888888)+new Random().nextInt(8888888);
        }
    }
}
