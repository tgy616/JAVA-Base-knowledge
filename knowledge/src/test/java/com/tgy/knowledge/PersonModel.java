package com.tgy.knowledge;

import java.util.Objects;
import java.util.Optional;

/**
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-08-27 11:08
 **/

public class PersonModel {
    private String name;
    private int age;
    private String sex;

    public PersonModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public PersonModel(String name, int age, String sex) {
         this.name=name;
         this.age=age;
         this.sex=sex;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    /**
     * Optional
     * 1、Optional 是为核心类库新设计的一个数据类型，用来替换 null 值。
     *
     * 2、人们对原有的 null 值有很多抱怨，甚至连发明这一概念的Tony Hoare也是如此，他曾说这是自己的一个“价值连城的错误”
     *
     * 3、用处很广，不光在lambda中，哪都能用
     *
     * 4、Optional.of(T)，T为非空，否则初始化报错
     *
     * 5、Optional.ofNullable(T)，T为任意，可以为空
     *
     * 6、isPresent()，相当于 ！=null
     *
     * 7、ifPresent(T)， T可以是一段lambda表达式 ，或者其他代码，非空则执行
     * @param args
     */

    public static void main(String[] args) {
        PersonModel personModel = new PersonModel();
        //对象为空则打出
        Optional<Object> o=Optional.of(personModel);
        System.out.println(o.isPresent()?o.get():"-");
        //名称为空则打出
        Optional<String> name = Optional.ofNullable(personModel.getName());
        System.out.println(name.isPresent()?name.get():"-");
        //如果不为空，则打出XXX
        Optional.ofNullable("Test").ifPresent(na->{
            System.out.println(na+"ifPresent");
        });
        //如果为空，则返回指定字符串
        System.out.println(Optional.ofNullable(null).orElse("-"));
        System.out.println(Optional.ofNullable("1").orElse("-"));

    }
}
