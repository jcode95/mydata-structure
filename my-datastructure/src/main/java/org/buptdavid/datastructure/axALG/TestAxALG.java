package org.buptdavid.datastructure.axALG;

import java.awt.*;
import java.util.LinkedList;

/**
 * 测试A*寻路算法
 */
public class TestAxALG {
    public static void main(String[] args) {
        AxALG axALG = new AxALG();
        //起始位置
        Point startPoint = new Point(0, 0);
        Point endPoint = new Point(5, 5);
        //路径
        LinkedList<Point> pathPoints = new LinkedList<>();
        axALG.find(startPoint, endPoint, pathPoints);
        StringBuffer sb = new StringBuffer();
        for (Point pathPoint : pathPoints) {
            sb.append("[x:" + pathPoint.x + ",y:" + pathPoint.y + "]").append("--->");
        }
        String string = sb.toString();
        if (string.equals("")) {
            System.out.println("没有找到路径哦...");
            System.exit(1);
        }
        string = string.substring(0, string.lastIndexOf("--->"));
        System.out.println(string);

    }
    /**
     * * * * * * * * * * * * * * * * * * * * * * * * * *  X
     * * * * * * * * * * * * * * * * * * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * *
     * * * * * * * * * * * * * * * * * * * * * * * * * *
     Y
     */


}
