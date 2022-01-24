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
        //0：表示没有棋子，1：黑子 2：篮子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
        int row = 0;
        int flg = 0;//源数组不要放进稀疏数组里面的值
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != flg) {
                    row++;
                }
            }
        }
        //创建稀疏数组  稀疏数组的格式固定3列，值+1行 第一行第一列记录行，第一行第二列记录列，第一行第三列记录值
        int[][] sparseArr = new int[row + 1][3];//第一行记录的是原数组总共有多少列多少行，标记值
        sparseArr[0][0] = chessArr1.length;//原数组行数
        sparseArr[0][1] = chessArr1[0].length;//原数组列数
//        sparseArr[0][2] = flg;//源数组不要放进稀疏数组里面的值
        sparseArr[0][2] = row;//
        int count = 1;//从第二行开始填充稀疏数组
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != flg) {
                    sparseArr[count][0] = i;//行
                    sparseArr[count][1] = j;//列
                    sparseArr[count][2] = chessArr1[i][j];//值
                    count++;
                }
            }
        }
        System.out.println("-------------------稀疏数组如下---------------------");
        for (int[] rows : sparseArr) {
            for (int data : rows) {
                System.out.print(data + " ");
            }
            System.out.println();
        }


        /*使用稀疏数组还原源数组*/
        int[] first = sparseArr[0];
        int[][] sourceArr = new int[first[0]][first[1]];
        for (int i = 0; i < sourceArr.length; i++) {
            for (int j = 0; j < sourceArr[i].length; j++) {
                sourceArr[i][j] = first[2];
            }
        }
        for (int i = 1; i < sparseArr.length; i++) {
            int[] var = sparseArr[i];
            sourceArr[var[0]][var[1]]=var[2];
        }
        System.out.println("-------------------稀疏数组还原的源数组如下---------------------");
        for (int i = 0; i < sourceArr.length; i++) {
            for (int j = 0; j < sourceArr[i].length; j++) {
                System.out.print(sourceArr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
