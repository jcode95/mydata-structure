package org.buptdavid.datastructure.zj.gui;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WindowListenerUse {
    public WindowListenerUse() {
        JFrame jFrame = new JFrame("窗口监听");
        jFrame.setVisible(true);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("窗口被关闭了");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("窗口被激活了");
            }
        });
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new WindowListenerUse();

    }
}

