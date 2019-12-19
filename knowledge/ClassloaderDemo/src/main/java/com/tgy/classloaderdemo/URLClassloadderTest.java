package com.tgy.classloaderdemo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-12-13 15:17
 **/

public class URLClassloadderTest {

    public static void main(String[] args) {
        try {
            URL url=new URL("https://github.com/spring-projects/spring-webflow-samples/blob/master/primefaces-showcase" +
                    "/src/main/java/org/springframework/samples/webflow/upload/FileUploadController.java");

            //URL url=new File("D://MyGitHub//JAVA-knowledge//knowledge//com//tgy//classloaderdemo//Test").toURL();

            URL[] urls=new URL[]{url};
            URLClassLoader urlClassLoader=new URLClassLoader(urls);
            Class c=urlClassLoader.loadClass("com.tgy.classloaderdemo.Test.Test1");

            System.out.println(c.getClassLoader().toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
