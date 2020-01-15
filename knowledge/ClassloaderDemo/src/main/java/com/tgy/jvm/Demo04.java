package com.tgy.jvm;

/**
 * 获取虚拟机堆的最大内存和运行内存
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2020-01-15 16:56
 **/
// -Xms   : B初始的内存分配大小  totalMemory 物理内存的 1/64（默认值）
// -Xmx   : 最大分配内存  maxMemroy 物理内存的 1/4（默认值）
// -XX:+PrintGCDetails  : 输出详细的GC处理日志
public class Demo04 {
    public static void main(String[] args) {
        long maxMemroy=Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("maxMemroy:"+maxMemroy+"字节 "+maxMemroy/(double)1024/1024 +"MB");
        System.out.println("totalMemory:"+totalMemory+"字节 "+totalMemory/(double)1024/1024+"MB");
    }
}
