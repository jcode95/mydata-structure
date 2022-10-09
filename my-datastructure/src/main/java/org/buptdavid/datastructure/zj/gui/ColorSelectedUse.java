package org.buptdavid.datastructure.zj.gui;

import javax.swing.*;
import java.awt.*;

class ColorSelectedUse {
    public ColorSelectedUse() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        JPanel jPanel = new JPanel();
        final JLabel jLabel = new JLabel();
        jLabel.setPreferredSize(new Dimension(150, 150));
        jLabel.setOpaque(true);
        jPanel.add(jLabel);

        JButton jButton = new JButton("选择颜色");
        jButton.addActionListener(e -> {
            /**
             * 显示一个颜色选取器对话框（线程将被阻塞, 直到对话框被关闭）
             * 参数说明:
             * component: 对话框的父组件, 对话框将紧靠 component 的中心显示; 如果传 null, 则对话框显示在屏幕中心。
             * title: 对话框标题。
             * initialColor: 初始选中的颜色; 如果传 null, 则默认为非透明白色。
             * 返回值：
             * 返回选择的颜色; 如果点击了取消或关闭, 则返回 null。
             */
            Color color = JColorChooser.showDialog(jFrame, "选取颜色", null);
            // 如果用户取消或关闭窗口, 则返回的 color 为 null
            if (color == null) {
                return;
            }
            // 把选取的颜色设置为标签的背景
            jLabel.setBackground(color);
            // 获取颜色的 ARGB 各个分量值
            int alpha = color.getAlpha();
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            jLabel.setText("A=" + String.format("%02x", alpha) + ", " +
                    String.format("#%02x%02x%02x", red, green, blue));
        });
        jPanel.add(jButton);

        jFrame.setContentPane(jPanel);
        // 省略公共代码
    }

    public static void main(String[] args) {

        new ColorSelectedUse();
    }
}

