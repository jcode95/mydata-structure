package org.buptdavid.datastructure.zj.gui;

import java.awt.*;

/**
 * @author root
 * @CalssName: Ex4_2_2
 * @Package org.buptdavid.datastructure.zj.gui
 * @Description:
 * @date 2022/9/23/14:49
 */
public class Ex4_2_2 extends Frame implements Runnable {
    int x = 0, y = 160;
    int dx = 5, dy = 5;

    Image image, bufferPage = null;

    public static void main(String[] args) {
        Ex4_2_2 ex4_2_2 = new Ex4_2_2();

    }

    public Ex4_2_2() {
        super("Ex4_2_2");
        setSize(350, 350);

        Toolkit tk = Toolkit.getDefaultToolkit();
        image = tk.getImage("C:\\Users\\admin\\IdeaProjects\\mydata-structure\\my-datastructure\\src\\resource\\img.gif");

        setVisible(true);
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            x += dx;
            y += dy;
            repaint();
            if (x <= 0) {
                dx = 5;
            } else if ((x + 50) >= getWidth()) {
                dx -= 5;
            }
            if (y <= 0) {
                dy = 5;
            } else if ((y + 50) >= getHeight()) {
                dy -= 5;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
//        Graphics bufferg;
//        if (bufferPage == null) {
//            bufferPage = createImage(350, 350);
//        }
//        bufferg = bufferPage.getGraphics();
//        bufferg.drawImage(image, x, y, this);
//        bufferg.dispose();
//        g.drawImage(bufferPage, getInsets().left, getInsets().top, this);
//        g.setColor(Color.BLUE);
//        g.fillOval(x, y, 50, 50);
        g.drawImage(image,x,y,this);
    }
}
