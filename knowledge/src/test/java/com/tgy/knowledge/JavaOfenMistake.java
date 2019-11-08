package com.tgy.knowledge;

import java.util.*;

/**
 * Java 程序员排行前 10 的错误
 * Array转ArrayList
 *
 * 判断一个数组是否包含某个值
 *
 * 在循环内部删除List中的一个元素
 *
 * HashTable与HashMap
 *
 * 使用集合原始类型（raw type）
 *
 * 访问级别
 *
 * ArrayList和LinkedList
 *
 * 可变与不可变
 *
 * 父类和子类的构造方法
 *
 * “”还是构造方法
 *
 * 未来工作
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-11-08 15:46
 **/

public class JavaOfenMistake {
    public static void main(String[] args) {
        //1。Array转ArrayList
        String[] arr={"a","b","C"};
        List<String> list = Arrays.asList(arr);//error method
        /*Arrays.asList()会返回一个ArrayList，但是要特别注意，这个ArrayList是Arrays类的静态内部类，并不是java.util.ArrayList类。
        java.util.Arrays.ArrayList类实现了set()， get()，contains()方法，但是并没有实现增加元素的方法（事实上是可以调用add方法，
        但是没有具体实现，仅仅抛出UnsupportedOperationException异常），因此它的大小也是固定不变的。*/
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arr));//right method

        //2.判断一个数组是否包含某个值
        //Set<String> set = new HashSet<String>(Arrays.asList(arr));
        //return set.contains(targetValue);
        //以上代码可以正常工作，但是没有必要将其转换成set集合，将一个List转成Set需要额外的时间，其实我们可以简单的使用如下方法即可：
        /*正确做法
        Arrays.asList(arr).contains(targetValue);
        //或者

        for(String s: arr){
            if(s.equals(targetValue))
                return true;
        }
        return false;*/

        //3。在循环内部删除List中的一个元素
        //error method one
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c","d"));
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        System.out.println(list);
        //结果打印：
        //[b, d]


        //error method two   将抛出ConcurrentModificationException异常。
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c","d"));
        for (String s : list) {
            if (s.equals("a"))
                list.remove(s);
        }

        //right method
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c","d"));
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            if (s.equals("a")) {
                iter.remove();
            }
        }

        //4.HashTable与HashMap
        //从算法的角度来讲，HashTable是一种数据结构名称。但是在Java中，这种数据结构叫做HashMap。HashTable与HashMap的一个
        // 主要的区别是HashTable是同步的，所以，通常来说，你会使用HashMap，而不是Hashtable。

        //5.使用集合原始类型（raw type）
        public static void add(List list, Object o){
            list.add(o);
        }
        public static void main(String[] args){
            List<String> list = new ArrayList<String>();
            add(list, 10);
            String s = list.get(0);
        }
        //运行以上代码将会抛出异常：
        //
        //Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        //at …
        //
        //使用原始类型集合非常危险，因为它跳过了泛型类型检查，是不安全的。另外，Set, Set, 和Set这三个有很大的不同，
        // 具体请看：类型擦除和Raw type vs. Unbounded wildcard。

        //6.访问级别
        //开发人员经常使用public修饰类字段，虽然这很容易让别人直接通过引用获取该字段的值，但这是一个不好的设计。根据经验，
        // 应该尽可能的降低成员属性的访问级别。
        //
        //相关阅读：public, default, protected, and private

        //7.ArrayList和LinkedList
//        为什么开发人员经常使用ArrayList和LinkedList，却不知道他们之间的区别，因为它们看起来很像。然而它们之间有着巨大的性能差异。
//        简单的说，如果有大量的增加删除操作并且没有很多的随机访问元素的操作，应该首选LinkedList。

        //8.可变与不可变
        //不可变对象有很多优点，如简单、安全等。但是对于每个不同的值都需要一个单独的对象，太多的对象会引起大量垃圾回收，
        // 因此在选择可变与不可变的时候，需要有一个平衡。
        //
        //通常，可变对象用于避免产生大量的中间对象，一个经典的例子是大量字符串的拼接。如果你使用一个不可变对象，将会马上
        // 产生大量符合垃圾回收标准的对象，这浪费了CPU大量的时间和精力。使用可变对象是正确的解决方案（StringBuilder）；
        //
        //String result="";
        //for(String s: arr){
        //    result = result + s;
        //}
        //另外，在有些其它情况下也是需要使用可变对象。例如往一个方法传入一个可变对象，然后收集多种结果，而不需要写太多的语法。
        // 另一个例子是排序和过滤：当然，你可以写一个方法来接收原始的集合，并且返回一个排好序的集合，但是那样对于大的集合就太浪费了。

        //9.“”还是构造方法
        /*
        有两种创建字符串的方式：
        //1. use double quotes
        String x = "abc";
        //2. use constructor
        String y = new String("abc");
        它们之间有什么区别呢？

        以下代码提供了一个快速回答：

        String a = "abcd";
        String b = "abcd";
        System.out.println(a == b); // True
        System.out.println(a.equals(b)); // True
        String c = new String("abcd");
        String d = new String("abcd");
        System.out.println(c == d); // False
        System.out.println(c.equals(d)); // True
        * */
    }
}
