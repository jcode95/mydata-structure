package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.recursion;

/**
 * @author jiezhou
 * @CalssName: Migong
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.recursion
 * @Description: 迷宫
 * @date 2020/8/13/16:14
 */
public class Migong {
    static int[][] map = new int[7][7];

    public static void main(String[] args) {
        init();
        getWay(map, 1, 1);
        System.out.println("-------------------");
        list();
    }


    /**
     * 初始化迷宫
     */
    public static void init() {
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[6][i] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置障碍物
        map[2][3] = 1;
        map[1][2] = 1;
        map[3][4] = 1;
        list();
    }

    private static void list() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * 2 为可以通过已经走过，1 为不能通过  0 表示可以走还没有走   3 表示走过走不通
     *
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean getWay(int[][] map, int i, int j) {
        if (i < 0 || j < 0) {
            return false;
        }
        if (map[5][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;//假设是2
            //上--右--下--左
            if (getWay(map, i - 1, j)) {//上
                return true;
            } else if (getWay(map, i, j + 1)) {//右
                return true;
            } else if (getWay(map, i + 1, j)) {//下
                return true;
            } else if (getWay(map, i, j - 1)) {//左
                return true;
            } else {
                map[i][j] = 3;//走不通
                return false;
            }
        } else {
            return false;
        }
    }
}
