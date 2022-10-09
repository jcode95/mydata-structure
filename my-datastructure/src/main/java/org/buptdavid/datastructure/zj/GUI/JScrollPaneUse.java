package org.buptdavid.datastructure.zj.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JScrollPaneUse {
    public JScrollPaneUse() {
        JFrame jFrame = new JFrame("面板窗口");

        // 创建文本区域组件
        JTextArea textArea = new JTextArea("这是一个文本");
        // 自动换行
        textArea.setLineWrap(true);
        // 设置字体
        textArea.setFont(new Font(null, Font.PLAIN, 18));

        // 初始化滚动面板面板
        /**
         * 全参构造参数说明：
         * view: 需要滚动显示的视图组件
         * vsbPolicy: 垂直滚动条的显示策略
         * ScrollPaneConstants.VERTICAL\_SCROLLBAR\_AS\_NEEDED // 需要时显示（默认）
         * ScrollPaneConstants.VERTICAL\_SCROLLBAR\_NEVER // 从不显示
         * ScrollPaneConstants.VERTICAL\_SCROLLBAR\_ALWAYS // 总是显示
         * hsbPolicy: 水平滚动条的显示策略
         * ScrollPaneConstants.HORIZONTAL\_SCROLLBAR\_AS\_NEEDED // 需要时显示（默认）
         * ScrollPaneConstants.HORIZONTAL\_SCROLLBAR\_NEVER // 从不显示
         * ScrollPaneConstants.HORIZONTAL\_SCROLLBAR\_ALWAYS // 总是显示
         * 常用方法
         * 设置滚动显示视图内容组件：setViewportView(Component view)
         * 设置垂直滚动条的显示策略：setVerticalScrollBarPolicy(int policy)
         * 设置水平滚动条的显示策略：setHorizontalScrollBarPolicy(int policy)
         */
        Container c = jFrame.getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.LEFT));
        rootScanner(c,jFrame);
        //换行
        rootScanner(c,jFrame);

        JScrollPane jScrollPane = new JScrollPane(
                c,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        jFrame.setContentPane(jScrollPane);

        // 窗口设置为公共代码，后面全部省略
        jFrame.setVisible(true);
        jFrame.setSize(400, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollPaneUse();
    }
    /**
     * 用户输入玩家个数以及一些配置
     *
     * @param jf
     */
    public static void rootScanner(Container c, JFrame jf) {
        JPanel jp1 = new JPanel();
        c.add(jp1);
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

