package org.buptdavid.datastructure.zj.gui;

import javax.swing.*;
import java.awt.*;

class JLabelUse {
    public JLabelUse() {
        JFrame jFrame = new JFrame("标签窗口");
        JPanel jPanel = new JPanel();
        jFrame.setVisible(true);
        // 只显示文本的标签
        JLabel textLabel = new JLabel("只显示文本的标签");
        textLabel.setFont(new Font(null, Font.PLAIN, 25));
        jPanel.add(textLabel);

        // 只显示图片的标签
        JLabel imgLabel = new JLabel(new ImageIcon("my-datastructure/src/resource/img.gif"));
        jPanel.add(imgLabel);

        // 同时显示文本和图片的标签：水平方向文本在图片中心
        JLabel jLabel = new JLabel("显示文本", new ImageIcon("my-datastructure/src/resource/img.gif"), SwingConstants.CENTER);
        jPanel.add(jLabel);
		
        jFrame.setContentPane(jPanel);
        // 省略公共代码
    }

    public static void main(String[] args) {

        new JLabelUse();

        System.out.println("args = " + Long.MAX_VALUE);
    }
}

