package org.buptdavid.datastructure.zj.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class FlowLayoutUse {
    public FlowLayoutUse() {
        JFrame jFrame = new JFrame("流式布局窗口");
        jFrame.setSize(500,500);
        jFrame.setVisible(true);
        // 创建面板并指定为流式布局
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // 创建两个按钮
        JButton jButton1 = new JButton("按钮1");
        jButton1.setBounds(0,0,10,10);
        JButton jButton2 = new JButton("按钮2");
        jButton2.setBounds(0,0,10,10);
        final JTextArea jTextArea = new JTextArea(10, 30);
        jTextArea.setLineWrap(true);
        jPanel.add(jTextArea);
        // 将按钮添加到面板中
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        // 将面板添加到窗口中
        jFrame.setContentPane(jPanel);
        jFrame.setLayout(null);
        // 省略公共代码
    }

    public static void main(String[] args) {
        new FlowLayoutUse();
    }
}

