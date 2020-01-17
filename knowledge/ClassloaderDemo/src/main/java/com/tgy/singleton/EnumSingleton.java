package com.tgy.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2020-01-16 14:38
 **/

public enum  EnumSingleton {

    INSTANCE;

    public EnumSingleton getInstance(){
        return INSTANCE;
    }

}
class Demo2{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        System.out.println(instance==instance2);

        //没有无参构造器 （idea 编译的不对，枚举是没有无参构造器的，Javap也反编译不出，只有用专业反编译工具jad 才编译出）
        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        declaredConstructor.newInstance();
    }
}
