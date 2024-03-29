package org.buptdavid.datastructure.zj.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestDemo extends JFrame {

    public TestDemo() {
        JPanel jp1 = new JPanel(new GridLayout(3, 3, 20, 10));//3行2列 水平间距20 垂直间距10
        //第一行
        JLabel jl1 = new JLabel("文字:");
        jl1.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField jtf1 = new JTextField(10);
        jtf1.setText("");
        JButton jButton1 = new JButton("按钮1");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jtf1.getText());

            }
        });
        jp1.add(jl1);
        jp1.add(jtf1);
        // 将按钮添加到面板中
        jp1.add(jButton1);
        //第二行
        JLabel jl2 = new JLabel("文字:");
        jl2.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField jtf2 = new JTextField(10);
        jtf2.setText("");
        JButton jButton2 = new JButton("按钮2");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jtf2.getText());

            }
        });
        jp1.add(jl2);
        jp1.add(jtf2);
        jp1.add(jButton2);
        //第三行
        JLabel jl3 = new JLabel("文字:");
        jl3.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField jtf3 = new JTextField(10);
        jtf3.setText("");
        JTextField jtf4 = new JTextField(10);
        jtf4.setText("");
        JButton jButton3 = new JButton("按钮3");
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jtf3.getText());
                System.out.println(jtf4.getText());

            }
        });
        jp1.add(jl3);
        jp1.add(jtf3);
        jp1.add(jtf4);
        jp1.add(jButton3);


        add(jp1);
        setLayout(new FlowLayout());//流式布局
        setTitle("Demo");
        setSize(500, 500);//大小
        setLocationRelativeTo(null);//居中
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new TestDemo();
    }
}