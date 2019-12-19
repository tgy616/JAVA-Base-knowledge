package com.tgy.knowledge;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 三目运算面试题
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-12-03 14:21
 **/

public class TestThreeEyesMulication {
    public static void main(String[] args) {
        test1(1,2);
    }
    public static void test1(int a,int b){
        // 触发隐藏类型转换,int 类型 9 转为 9.0D
        System.out.println(a == b ? 9.9 : 9);
        // 编译期判断,98 在 char 之内,转为 b
        System.out.println(a == b ? 'a' : 98);
        // 编译期判断,超出char范围，统一转 int
        System.out.println(a == b ? 'a' : Integer.MAX_VALUE);
        // 编译期时无法判断 b 的取值,触发隐藏类型转换,统一转 int
        System.out.println(a == b ? 'a' : b);
        System.out.println(a != b ? 'a' : b);

        Map<String, Long> map = new HashMap<>();
        map.put("b", 1L);
        // 基本数据类型和对象数据类型相遇时,默认转为基本数据类，
        // map.get("a") 返回 null,转为基本数据类型时，报空指针异常
        if(map.containsKey("a"))System.out.println(map == null ? -1L : map.get("a"));
    }
}
