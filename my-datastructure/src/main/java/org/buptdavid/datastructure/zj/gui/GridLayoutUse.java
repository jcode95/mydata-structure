package org.buptdavid.datastructure.zj.gui;

import javax.swing.*;
import java.awt.*;

class GridLayoutUse {
    public GridLayoutUse() {
        JFrame jFrame = new JFrame("网格布局窗口");
        jFrame.setVisible(true);
        // 创建一个面板并使用网格布局
        JPanel jPanel = new JPanel(new GridLayout(2, 2));
        // 创建五个按钮，测试2行2列超出效果
        JButton jButton1 = new JButton("按钮1");
        JButton jButton2 = new JButton("按钮2");
        JButton jButton3 = new JButton("按钮3");
        JButton jButton4 = new JButton("按钮4");
        JButton jButton5 = new JButton("按钮5");
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jButton4);
        jPanel.add(jButton5);
        jFrame.setContentPane(jPanel);

        // 省略公共代码
    }

    public static void main(String[] args) {
        new GridLayoutUse();
    }
}

