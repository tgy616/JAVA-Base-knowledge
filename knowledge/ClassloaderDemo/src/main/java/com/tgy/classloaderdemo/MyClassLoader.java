package com.tgy.classloaderdemo;

import java.io.*;

/**
 * 自定义classloader
 *
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-12-12 15:47
 **/

public class MyClassLoader extends ClassLoader {
    private String name;

    public MyClassLoader(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data1= new byte[0];
        try {
            data1 = loadClassData("D:\\MyGitHub\\JAVA-knowledge\\knowledge\\com\\tgy\\classloaderdemo\\Test\\Test1.class");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class<?> clazz = this.defineClass(name, data1, 0, data1.length);
        return clazz;
    }

    private byte[] loadClassData(String name) throws IOException {
        InputStream is = null;
        ByteArrayOutputStream outputStream = null;
        try {
            is = new FileInputStream(new File(name));
            outputStream = new ByteArrayOutputStream();
            int i = 0;
            while ((i = is.read()) != -1) {
                outputStream.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (is != null) {
                is.close();
            }
        }
        return outputStream.toByteArray();
    }
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        ClassLoader system=getSystemClassLoader().getParent();//会导致main方法报空指针
        //ClassLoader system=getSystemClassLoader();
        Class<?> clazz = null;
        try {
            clazz=system.loadClass(name);
        }catch (Exception e){

        }
        if (clazz==null){
            findClass(name);
        }
        return clazz;
    }
    public static void main(String[] args) {
        //parent == AppClassLoader
        MyClassLoader loader1=new MyClassLoader(MyClassLoader.class.getClassLoader(),"MyClassLoader");
        MyClassLoader loader2=new MyClassLoader(MyClassLoader.class.getClassLoader(),"MyClassLoader");
        try {
            Class<?> clazz1 = loader1.loadClass("com.tgy.classloaderdemo.Test.Test1");
            Class<?> clazz2 = loader2.loadClass("com.tgy.classloaderdemo.Test.Test1");
            System.out.println(clazz1.equals(clazz2));
            System.out.println(clazz1.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
