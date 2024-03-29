package org.buptdavid.datastructure.zj.GUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

class FileSelectedUse {
    public FileSelectedUse() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        JPanel jPanel = new JPanel();

        /**
         * 显示 打开文件 或 保存文件 的对话框（线程将被阻塞, 直到选择框被关闭）：showOpenDialog(Component parent), showSaveDialog(Component parent)
         * 参数：
         * parent: 文件选取器对话框的父组件, 对话框将会尽量显示在靠近 parent 的中心; 如果传 null, 则显示在屏幕中心。
         * 返回值：
         * JFileChooser.CANCEL\_OPTION: 点击了取消或关闭
         * JFileChooser.APPROVE\_OPTION: 点击了确认或保存
         * JFileChooser.ERROR\_OPTION: 出现错误
         */
        final JTextArea jTextArea = new JTextArea(10, 30);
        jTextArea.setLineWrap(true);
        jPanel.add(jTextArea);

        JButton openBtn = new JButton("打开");
        openBtn.addActionListener(e -> showFileOpenDialog(jFrame, jTextArea));
        jPanel.add(openBtn);

        JButton saveBtn = new JButton("保存");
        saveBtn.addActionListener(e -> showFileSaveDialog(jFrame, jTextArea));
        jPanel.add(saveBtn);

        jFrame.setContentPane(jPanel);
        // 省略公共代码
    }

    /**
     * 打开文件
     *
     * @param parent      组件
     * @param msgTextArea 文本域
     */
    private static void showFileOpenDialog(Component parent, JTextArea msgTextArea) {
        // 创建一个默认的文件选取器
        JFileChooser fileChooser = new JFileChooser();
        // 设置默认显示的文件夹为当前文件夹
        fileChooser.setCurrentDirectory(new File("."));
        // 设置文件选择的模式（只选文件、只选文件夹、文件和文件均可选）
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // 设置是否允许多选
        fileChooser.setMultiSelectionEnabled(true);
        // 添加可用的文件过滤器（FileNameExtensionFilter 的第一个参数是描述, 后面是需要过滤的文件扩展名 可变参数）
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("zip(*.zip, *.rar)", "zip", "rar"));
        // 设置默认使用的文件过滤器
        fileChooser.setFileFilter(new FileNameExtensionFilter("image(*.jpg, *.png, *.gif)", "jpg", "png", "gif"));
        // 打开文件选择框（线程将被阻塞, 直到选择框被关闭）
        int result = fileChooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            // 如果点击了"确定", 则获取选择的文件路径
            File file = fileChooser.getSelectedFile();
            // 如果允许选择多个文件, 则通过下面方法获取选择的所有文件
            msgTextArea.append("打开文件: " + file.getAbsolutePath() + "\n\n");
        }
    }

    /**
     * 选择文件保存路径
     *
     * @param parent      组件
     * @param msgTextArea 文本域
     */
    private static void showFileSaveDialog(Component parent, JTextArea msgTextArea) {
        // 创建一个默认的文件选取器
        JFileChooser fileChooser = new JFileChooser();
        // 设置打开文件选择框后默认输入的文件名
        fileChooser.setSelectedFile(new File("测试文件.zip"));
        // 打开文件选择框（线程将被阻塞, 直到选择框被关闭）
        int result = fileChooser.showSaveDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            // 如果点击了"保存", 则获取选择的保存路径
            File file = fileChooser.getSelectedFile();
            msgTextArea.append("保存到文件: " + file.getAbsolutePath() + "\n\n");
        }
    }

    public static void main(String[] args) {
        new FileSelectedUse();
    }
}

