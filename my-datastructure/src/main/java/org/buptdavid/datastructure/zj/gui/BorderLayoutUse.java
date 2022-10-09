package org.buptdavid.datastructure.zj.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BorderLayoutUse {
    public BorderLayoutUse() {
        JFrame jFrame = new JFrame("网格布局窗口");
        jFrame.setSize(500,500);
        jFrame.setVisible(true);
        // 创建一个面板并使用边框布局
        JPanel jPanel = new JPanel(new BorderLayout());
        // 创建五个按钮，测试2行2列超出效果
        JButton jButton1 = new JButton("东");
        jButton1.setSize(10,10);
        JButton jButton2 = new JButton("西");
        jButton2.setSize(10,10);
        JButton jButton3 = new JButton("南");
        jButton3.setSize(10,10);
        JButton jButton4 = new JButton("北");
        jButton4.setSize(10,10);
        JButton jButton5 = new JButton("中");
        jButton5.setSize(10,10);
//        jPanel.add(jButton1);
//        jPanel.add(jButton2);
//        jPanel.add(jButton3);
//        jPanel.add(jButton4);
//        jPanel.add(jButton5);
//        jPanel.add(jButton1, BorderLayout.EAST);
//        jPanel.add(jButton2, BorderLayout.WEST);
//        jPanel.add(jButton3, BorderLayout.SOUTH);
//        jPanel.add(jButton4, BorderLayout.NORTH);
//        jPanel.add(jButton5, BorderLayout.CENTER);
//        jFrame.setContentPane(jPanel);


        //Box布局
        Container cp = jFrame.getContentPane();
        Box box = Box.createVerticalBox();
        cp.setLayout(new BorderLayout());
        cp.add(box);
        box.add(jButton1);
        box.add(Box.createVerticalStrut(10));
//        rootScanner(box,jFrame);
        box.add(jButton2);
        box.add(Box.createVerticalStrut(10));
//        rootScanner(box,jFrame);
        box.add(jButton3);
        box.add(Box.createVerticalStrut(10));
        JPanel jp1 = new JPanel();
        jp1.setSize(100,100);
        box.add(jp1);
        // 省略公共代码
    }

    public static void main(String[] args) {
        new BorderLayoutUse();

    }

    /**
     * 用户输入玩家个数以及一些配置
     *
     * @param jf
     */
    public static void rootScanner(Box box, JFrame jf) {
        JPanel jp1 = new JPanel();
        jp1.setSize(100,100);
        box.add(jp1);
        JLabel l1 = new JLabel("用户输入玩家个数以及一些配置: ");
        jp1.add(l1);

        JLabel jlu = new JLabel("  起始的玩家ID: ");
        jp1.add(jlu);
        JTextField jtfStart = new JTextField(5);
        jp1.add(jtfStart);

        JLabel jlc = new JLabel("  模拟客户端数量: ");
        jp1.add(jlc);
        JTextField jtfC = new JTextField(5);
        jp1.add(jtfC);

        JLabel jlI = new JLabel("  调度间隔（毫秒）: ");
        jp1.add(jlI);
        JTextField jtfI = new JTextField(5);
        jp1.add(jtfI);

        JLabel jlN = new JLabel("  日志区别码: ");
        jp1.add(jlN);
        JTextField jtfN = new JTextField(5);
        jp1.add(jtfN);

        //按钮
        JButton button = new JButton("确定");
        jp1.add(button);//将按钮加入面板
        //把两个面板添加到容器里面
        jf.add(jp1);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.addActionListener(new ActionListener() {//按钮监听
            @Override
            public void actionPerformed(ActionEvent e) {
                //通过面板属性名获取到该面板上的所有组件
                int index = 0;//用数组存储的，所以按照下标可确定是哪个文本框
                try {
                    for (Component c : jp1.getComponents()) {
                        String info = "";
                        if (c instanceof JTextField) {
                            index++;
                            info = ((JTextField) c).getText();
                            if (info == null || "".equals(info)) {
                                continue;
                            }
                            if (index == 1) {
                                //起始的玩家ID
                                int i = Integer.parseInt(info);
                                System.out.println("i = " + i);
                            }
                            if (index == 2) {
                                //模拟客户端数量
                                int i = Integer.parseInt(info);
                                System.out.println("i = " + i);
                            }
                            if (index == 3) {
                                //调度间隔（毫秒）
                                Long.parseLong(info);
                            }
                            if (index == 4) {
                                //日志区别码
                            }
                        }
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "输入 错误！");
                    System.exit(1);
                }
            }
        });
    }
}

