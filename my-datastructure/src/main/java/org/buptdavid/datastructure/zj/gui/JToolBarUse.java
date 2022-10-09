package org.buptdavid.datastructure.zj.gui;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

class JToolBarUse {
    public JToolBarUse() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        JPanel jPanel = new JPanel();

        // 创建一个工具栏
        JToolBar jToolBar = new JToolBar("测试工具栏");
        JButton jButton = new JButton("按钮");
        jToolBar.add(jButton);

        jPanel.add(jToolBar);
        // 省略公共代码
    }

    public static void main(String[] args) {
//        new JToolBarUse();
//        String command = "cmd /c C:\\Users\\admin\\Desktop\\a.bat";
        String command = "cmd /k start BuildProtocol.bat";
        try {
            Runtime.getRuntime().exec(command,null,new File("D:\\ideaproject\\SLG\\future-game\\config\\server-pb"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

