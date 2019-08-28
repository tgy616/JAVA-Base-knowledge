package com.tgy.knowledge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * 日常测试
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-08-26 16:09
 **/

public class DayOffenTest {

    public static void main(String[] args) {
        //在循环内部删除List中的一个元素
        //法一：（易犯的错误方法）
        /**这个方法中有一系列的问题，当一个元素被删除的时候，list大小减小，然后原先索引指向了其它元素。
         * 所以如果你想在循环里通过索引来删除多个元素，将不会正确工作。
         * */
       /* ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c","d"));
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        System.out.println(list);*/
       //法二：
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c","d"));
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            if (s.equals("a")) {
                iter.remove();
            }
        }
        System.out.println(list);


        /***
         * Reduce
         * 1、感觉类似递归
         *
         * 2、数字(字符串)累加
         *
         * 3、个人没咋用过
         */
        Integer reduce=Stream.of(1,2,3,4).reduce(10,(count,item)->{
            System.out.println("count:"+count);
            System.out.println("item:"+item);
            return count+item;
        });
        System.out.println(reduce);

        Integer reduce1=Stream.of(1,2,3,4).reduce(0,(x,y)->x+y);
        System.out.println(reduce1);

        String reduce2=Stream.of("1","2","3").reduce("0",(x,y)->(x+","+y));
        System.out.println(reduce2);


    }
}
