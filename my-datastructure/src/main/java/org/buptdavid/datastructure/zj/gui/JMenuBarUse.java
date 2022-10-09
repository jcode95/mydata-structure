package org.buptdavid.datastructure.zj.gui;

import javax.swing.*;

class JMenuBarUse {
    public JMenuBarUse() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        JPanel jPanel = new JPanel();

        // 创建一个菜单栏
        JMenuBar jMenuBar = new JMenuBar();

        // 创建一级菜单
        JMenu fileMenu = new JMenu("文件");
        JMenu editMenu = new JMenu("编辑");
        // 将一级菜单添加到菜单栏
        jMenuBar.add(fileMenu);
        jMenuBar.add(editMenu);

        // 创建文件菜单的子菜单
        JMenuItem openMenuItem = new JMenuItem("打开");
        JMenuItem newMenuItem = new JMenuItem("新建");
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);

        jPanel.add(jMenuBar);
        // 省略公共代码
    }

    public static void main(String[] args) {
        new JMenuBarUse();
    }
}

