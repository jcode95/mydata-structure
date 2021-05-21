package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.MST.prim;

import java.util.Arrays;

/**
 * @author jiezhou
 * @CalssName: PrimAlgorithm
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.prim
 * @Description: 普利姆算法求最小生成树---合适稠密的网
 * @date 2020/9/4/17:47
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示,99999这个大数，表示两个点不联通
        int[][] weight = new int[][]{
                {99999, 5, 7, 99999, 99999, 99999, 2},
                {5, 99999, 99999, 9, 99999, 99999, 3},
                {7, 99999, 99999, 99999, 8, 99999, 99999},
                {99999, 9, 99999, 99999, 99999, 4, 99999},
                {99999, 99999, 8, 99999, 99999, 5, 4},
                {99999, 99999, 99999, 4, 5, 99999, 6},
                {2, 3, 99999, 99999, 4, 6, 99999},};

        //创建MGraph对象
        MGraph graph = new MGraph(verxs);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createCraph(graph, verxs, data, weight);
        minTree.showGraph(graph);
        //测试普利姆算法
        minTree.prim(graph, 0);//
    }


}

//创建最小生成树->村庄的图
class MinTree {
    /*创建图的邻接矩阵*/

    /**
     * @param graph  图对象
     * @param verxs  图对应的顶点个数
     * @param data   图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createCraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {//顶点
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    //编写prim算法，得到最小生成树

    /**
     * @param graph 图
     * @param v     表示从图的第几个顶点开始生成'A'->0 'B'->1...
     */
    public void prim(MGraph graph, int v) {
        //visited[] 标记结点(顶点)是否被访问过
        //visited[] 默认元素的值都是0, 表示没有访问过
        int visited[] = new int[graph.verxs];

        //把当前这个结点标记为已访问
        visited[v] = 1;
        //h1 和 h2 记录两个顶点的下标
        int h1 = -1; //第一个点的下标
        int h2 = -1;//第二个点的下标
        int minWeight = 99999; //将 minWeight 初始成一个大数，后面在遍历过程中，会被替换
        for (int k = 0; k < graph.verxs - 1; k++) {//因为有 graph.verxs顶点，普利姆算法结束后，有 graph.verxs-1边
            //这个是确定每一次生成的子图 ，和哪个结点的距离最近
            for (int i = 0; i < graph.verxs; i++) {// i结点表示被访问过的结点
                for (int j = 0; j < graph.verxs; j++) {//j结点表示还没有访问过的结点
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边是最小
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            //将当前这个结点标记为已经访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值 99999
            minWeight = 99999;
        }

    }
}

class MGraph {
    int verxs;//表示图的节点个数
    char[] data;//存放结点数据
    int[][] weight;//存放边，就是我们的邻接矩阵

    MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
