package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray;

/**
 * @author jiezhou
 * @CalssName: SparseArray
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray
 * @Description: 稀疏数组
 * @date 2020/8/10/18:32
 */
public class SparseArray {
    public static void main(String[] args) {
        //先创建一个原始的二维数组
        //0：表示没有旗子，1：黑子 2：篮子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.println(data);
            }
        }
        int row = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    row++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparseArr = new int[row + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = row;
        int count = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }
        System.out.println("----------------------------------------");
        for (int[] rows : sparseArr) {
            for (int data : rows) {
                System.out.println(data);
            }
        }
    }
}
