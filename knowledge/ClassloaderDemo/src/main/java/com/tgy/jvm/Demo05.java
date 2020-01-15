package com.tgy.jvm;

import java.util.ArrayList;

/**
 * Dump 内存进行分析！ MAT  JProFiler（idea插件 需要配合JProfiler for windows软件联调）
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2020-01-15 17:25
 **/

//-Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
public class Demo05 {
    byte[] byteArray = new byte[1 * 1024 * 1024];//1M
    public static void main(String[] args) {

        ArrayList<Demo05> list = new ArrayList<>();
        int count=0;
        while (true){
            list.add(new Demo05());//内存会满
            count=count+1;
        }

    }
}
