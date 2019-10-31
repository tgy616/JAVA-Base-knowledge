package com.tgy.knowledge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * arraylist中重复元素的快速取出
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-10-31 09:09
 **/

public class DuplicateTest {

    public static <E> List<E> getDuplicateElements(List<E> list) {
        return list.stream()                              // list 对应的 Stream
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .entrySet().stream()                   // 所有 entry 对应的 Stream
                .filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey())          // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList());         // 转化为 List
    }

    public static void main(String[] args) throws Exception {
        List<String> list = Arrays.asList("a", "b", "c", "d", "a", "a", "d", "d");
        List<String> duplicate = getDuplicateElements(list);

        System.out.println("list 中重复的元素：" + duplicate);

        //old mether
        List<String> list2 = new ArrayList<String>();
        list2.add("aaa");
        list2.add("bbb");
        list2.add("ccc");
        list2.add("ddd");
        list2.add("aaa");
        list2.add("aaaa");
        list2.add("eee");
        list2.add("bbb");
        list2.add("ccc");
        StringBuilder builder = new StringBuilder();
        for (String str : list2) {
            // 如果不存在返回 -1。
            if (builder.indexOf("," + str + ",") > -1) {
                System.out.println("重复的有：" + str);
            } else {
                builder.append(",").append(str).append(",");
            }
        }
        //
        List<String> list3 = new ArrayList<String>();
        list3.add("string1");
        list3.add("string1");
        list3.add("string1");
        list3.add("string1");
        list3.add("string3");
        list3.add("string2");
        list3.add("string2");
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (String string : list3) {
            if (hashMap.get(string) != null) {
                Integer value = hashMap.get(string);
                hashMap.put(string, value + 1);
                System.out.println("the element:" + string + " is repeat");
            } else {
                hashMap.put(string, 1);
            }

        }
    }
}