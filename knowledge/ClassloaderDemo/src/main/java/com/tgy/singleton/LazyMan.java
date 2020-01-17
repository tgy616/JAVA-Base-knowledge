package com.tgy.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2020-01-16 14:01
 **/
//DCL ： 双重检测锁
public class LazyMan {

    //指令重排，如果不是原子性的操作
        //1、分配内存        1
        //2、执行构造方法    //对象不完整
        //3、指向地址        2

    //JMM  Java 内存模型。数据从主内存拿

    //私有
    private static boolean flag=false;

    private LazyMan(){
          synchronized (LazyMan.class){
              if (flag==false){
                  flag=true;
              }else {
                  throw new RuntimeException("不要试图用反射来破坏单例模式");
              }
//              if (lazyMan!=null){
//                  throw new RuntimeException("不要试图用反射来破坏单例模式");
//              }
          }
    }
    private volatile static LazyMan lazyMan;

    public static LazyMan getInstance(){
        if (lazyMan==null){
            synchronized (LazyMan.class){
                if (lazyMan==null){
                    lazyMan=new LazyMan();
                }
            }
        }
        return lazyMan;
    }
}

class Demo01{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //LazyMan instance = LazyMan.getInstance();
        //反射
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan instance = declaredConstructor.newInstance();
        Field flag = LazyMan.class.getDeclaredField("flag");
        flag.setAccessible(true);
        flag.set(instance,false);

        LazyMan instance2 = declaredConstructor.newInstance();

        //LazyMan instance2 = LazyMan.getInstance();
        System.out.println(instance==instance2);

    }
}
