package com.tgy.knowledge;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * 测试===创建一个实例数据源
 * Lambda表达式的测试
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-08-27 11:02
 **/

public class Data {
    private static List<PersonModel> list=null;

    static{
        PersonModel wu=new PersonModel("wu qi",18,"男");
        PersonModel zhang=new PersonModel("zhang san",19,"女");
        PersonModel zhao=new PersonModel("zhao si",21,"男");
        PersonModel li=new PersonModel("li si",28,"男");
        PersonModel sun=new PersonModel("sun qi",22,"男");
        list=Arrays.asList(wu,zhang,zhao,li,sun);
    }
    public  static List<PersonModel> getData(){
        return list;
    }
    /**过滤所有的男性**/
    public static void filterSex(){
        List<PersonModel> data=Data.getData();
        //old method
        List<PersonModel> temp=new ArrayList<>();
        for (PersonModel person:data){
            if ("男".equals(person.getSex())){
                temp.add(person);
            }
        }
        System.out.println(temp);

        //new
        List<PersonModel> collect=data.stream().filter(person->"男".equals(person.getSex())).collect(toList());
        System.out.println(collect);
    }
    /*过滤所有的男性并且小于20岁*/
    public static void  filterSexAndAge(){
        List<PersonModel> data=Data.getData();
        //old method
        List<PersonModel> temp=new ArrayList<>();
        for (PersonModel person:data){
            if ("男".equals(person.getSex())&& person.getAge()<20){
                temp.add(person);
            }
        }
        System.out.println("old :"+temp);

        //new 1
        List<PersonModel> collect=data.stream().filter(person-> {
            if ("男".equals(person.getSex())&& person.getAge()<20){
                return true;
            }
            return false;
        }).collect(toList());
        System.out.println("new 1:"+collect);

        //new 2
        List<PersonModel> collect1=data.stream()
                .filter(person->("男".equals(person.getSex())&&person.getAge()<20)).collect(toList());
        System.out.println("new 2:"+collect1);
    }

    public static void getPersonNameList(){
        List<PersonModel> data=Data.getData();
        //old
        List<String> list=new ArrayList<>();
        for (PersonModel person:data){
            list.add(person.getName());
        }
        System.out.println(list);
        //new 1
        List<String> collect=data.stream().map(person->person.getName()).collect(toList());
        System.out.println("new 1:"+collect);
        //new 2
        List<String> collect1=data.stream().map(PersonModel::getName).collect(toList());
        System.out.println("new 2:"+collect1);
        //new 3
        List<String> collect2=data.stream().map(person->{
                //System.out.println(person.getName());
            return person.getName();
        }).collect(toList());
        System.out.println("new 3:"+collect2);
    }

    public static void flatMapString(){
        List<PersonModel> data=Data.getData();
        //返回类型不一样
        List<String> collect=data.stream().flatMap(person->Arrays.stream(person.getName().split(""))).collect(toList());
        System.out.println("flatMap:"+collect);
        List<Stream<String>> collect1 = data.stream().map(person -> Arrays.stream(person.getName().split(""))).collect(toList());
        System.out.println("map:" + collect1);
        //用map实现
        List<String> collect2=data.stream().map(person->person.getName().split("")).flatMap(Arrays::stream).collect(toList());
        System.out.println("用map实现:"+collect2);
        //另一种方式
        List<String> collect3=data.stream().map(person->person.getName().split("")).flatMap(str->Arrays.asList(str).stream()).collect(toList());
        System.out.println("另一种方式:"+collect3);
    }
    /**
     * Collect
     * 1、collect在流中生成列表，map，等常用的数据结构
     * 2、toList()
     * 3、toSet()
     * 4、toMap()
     * 5、自定义
     */
    public static void toListTest(){
        List<PersonModel> data=Data.getData();
        List<String> collect=data.stream().map(PersonModel::getName).collect(toList());
        System.out.println(collect);
    }

    public static void toSetTest() {
        List<PersonModel> data = Data.getData();
        Set<String> collect = data.stream().map(PersonModel::getName).collect(toSet());
        System.out.println(collect);
    }

    public static void toMapTest() {
        List<PersonModel> data = Data.getData();
        Map<String,Integer> collect=data.stream().collect(
                Collectors.toMap(PersonModel::getName, PersonModel::getAge)
        );
        Map<String, String> collect1 = data.stream()
                .collect(Collectors.toMap(per -> per.getName(), value -> {
                    return value + "1";
                }));
        System.out.println(collect);
        System.out.println(collect1);
    }

    /**
     * 指定类型
     */
    public static void toTreeSetTest(){
        List<PersonModel> data=Data.getData();
        TreeSet<PersonModel> collect = data.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect);
    }

    /**
     * 分组
     */
    public static void toGroupTest(){
        List<PersonModel> data=Data.getData();
        Map<Boolean, List<PersonModel>> collect = data.stream().collect(Collectors.groupingBy(pre -> "男".equals(pre.getSex())));
        System.out.println(collect);
    }

    /**
     * 分隔
     */
    public static void toJoiningTest(){
        List<PersonModel> data=Data.getData();
        String collect =data.stream().map(personModel -> personModel.getName()).collect(Collectors.joining(",","{","}"));
        System.out.println(collect);
    }

    /**
     * 自定义
     */
    public static void reudce(){
        List<String> collect = Stream.of("1", "2", "3", "4").collect(
                Collectors.reducing(new ArrayList<String>(), x -> Arrays.asList(x), (y, z) -> {
                    y.addAll(z);
                    return y;
                })
        );
        System.out.println(collect);

    }
    public static void main(String[] args) {
//        filterSex();
//        System.out.println("---------------------------------------------");
//        filterSexAndAge();
//        System.out.println("---------------------------------------------");
//        getPersonNameList();
//        System.out.println("---------------------------------------------");
//        flatMapString();
//        toListTest();
//        toSetTest();
//        toMapTest();
//        toTreeSetTest();
//        toGroupTest();
//        toJoiningTest();
//        reudce();
    }
}
