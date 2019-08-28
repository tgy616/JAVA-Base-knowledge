package com.tgy.knowledge;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * lambda test
 * lambda 测试 示例
 * @author DragonSwimDiving
 * @program knowledge
 * @Date 2019-08-21 14:54
 **/

public class LambdaTest extends JFrame {

    private JButton jb;

    public LambdaTest(){
        this.setBounds(200,200,400,200);
        this.setTitle("lambda 测试");

        jb=new JButton("click");
       /* jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");
            }
        });*/
        jb.addActionListener(event ->System.out.println("hello"));
        this.add(jb);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new LambdaTest();
    }
}
