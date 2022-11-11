package org.buptdavid.datastructure.zj.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author root
 * @CalssName: ActionLinesButton
 * @Package org.buptdavid.datastructure.zj.GUI
 * @Description:
 * @date 2022/10/26/18:04
 */
public class ActionLinesButton extends AbstractAction {

    ActionLinesButton() {
        JFrame jFrame = new JFrame("流式布局窗口");
        // 关闭窗口
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 终止程序
                System.exit(0);
            }
        });
        // 设置窗口大小,坐标
        jFrame.setBounds(200, 200, 500, 500);
        jFrame.setVisible(true);
        // 创建面板并指定为流式布局
        JPanel jPanel = new JPanel(new GridLayout(3, 2, 20, 10));
        // 创建两个按钮
        final JTextArea jTextArea1 = new JTextArea(10, 30);
        jTextArea1.setLineWrap(true);
        jPanel.add(jTextArea1);
        JButton jButton1 = new JButton("按钮1");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jTextArea1.getText());

            }
        });
        // 将按钮添加到面板中
        jPanel.add(jButton1);

        final JTextArea jTextArea2 = new JTextArea(10, 30);
        jTextArea2.setLineWrap(true);
        jPanel.add(jTextArea2);
        JButton jButton2 = new JButton("按钮2");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(jTextArea2.getText());
            }
        });
        jPanel.add(jButton2);
        // 将面板添加到窗口中
        jFrame.setContentPane(jPanel);
        jFrame.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(true){
            System.out.println("e = " + e);
        }


    }

    public static void main(String[] args) {

        new ActionLinesButton();
    }
}
