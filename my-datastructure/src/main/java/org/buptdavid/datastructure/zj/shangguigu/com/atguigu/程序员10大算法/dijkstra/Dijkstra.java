package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.dijkstra;

import java.util.Arrays;

/**
 * @author jiezhou
 * @CalssName: Dijkstra
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.dijkstra
 * @Description: 迪杰斯特拉算法-最短路径问题（贪心算法思想）
 * @date 2020/9/5/18:07
 */
public class Dijkstra {
    public static final int N = 65535; // 代表正无穷 不可以连接

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
        //创建 Graph对象
        Graph graph = new Graph(vertex, matrix);
        graph.showGraph();
        graph.dsj(6);
        graph.show();

    }


}

class Graph {
    private char[] vertex;//顶点数组
    private int[][] matrix; //邻接矩阵
    private VisitedVertex vv;//各个数组的处理对象（这里便于处理各个数组，就用一个对象包装起来了）

    /**
     * @param vertex
     * @param matrix
     */
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void show() {
        vv.show();
    }

    public void showGraph() {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 迪杰斯特拉
     *
     * @param index
     */
    public void dsj(int index) {
        vv = new VisitedVertex(vertex.length, index);
        //更新index顶点到周围顶点的距离和前驱顶点
        update(index);
        for (int j = 0; j < vertex.length - 1; j++) {//比遍历n-1次，为什么要减1，因为出发点已经处理了
            // 选择并返回新的访问顶点
            index = vv.updateArr();
            update(index);
        }
    }

    /**
     * //更新index顶点到周围顶点的距离和前驱顶点
     *
     * @param index
     */
    private void update(int index) {
        int len = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            //取到出发点到index点的距离+index点到i点的距离
            len = vv.getDis(index) + matrix[index][i];
            if (!vv.in(i)) {//判断是否访问过，访问过的不能做相应的处理
                //没有被访问过
                len = Math.min(len, vv.getDis(i));//取到最小的，出发点到i点的距离与出发点先到index再到i点的距离取最小的来更新dis（出发点到各个顶点的距离集合）数组
                vv.updateDis(i, len);
                //更新i顶点的前驱为index顶点
                vv.updatePre(i, index);
            }
        }
    }

}

class VisitedVertex {
    // 记录各个顶点是否访问过 1表示访问过,0未访问,会动态更新
    public int[] already_arr;
    // 每个下标对应的值为前一个顶点下标, 会动态更新(我看了看没有必要用这个)
//    public int[] pre_visited;
    // 记录出发顶点到其他所有顶点的距离,比如G为出发顶点，就会记录G到其它顶点的距离，会动态更新，求的最短距离就会存放到dis
    public int[] dis;

    //构造器

    /**
     * @param length :表示顶点的个数
     * @param index: 出发顶点对应的下标, 比如G顶点，下标就是6
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
//        this.pre_visited = new int[length];
        this.dis = new int[length];
        //初始化 dis数组
        Arrays.fill(dis, 65535);
        //设置出发顶点为被访问过
        this.already_arr[index] = 1;
        //设置出发顶点的访问距离为0
        this.dis[index] = 0;
    }

    /**
     * 功能: 判断index顶点是否被访问过
     *
     * @param index
     * @return 如果访问过，就返回true, 否则访问false
     */
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    /**
     * 功能: 更新出发顶点到index顶点的距离
     *
     * @param index
     * @param len
     */
    public void updateDis(int index, int len) {
        this.dis[index] = len;
    }

    /**
     * 功能: 更新next这个顶点的前驱顶点为pre顶点
     *
     * @param next
     * @param pre
     */
    public void updatePre(int next, int pre) {
//        this.pre_visited[next] = pre;
    }

    /**
     * 功能:返回出发顶点到index顶点的距离
     *
     * @param index
     */
    public int getDis(int index) {
        return dis[index];
    }

    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (this.dis[i] < min && !in(i)) {//找出没有被访问过并且距离最小的点的下标
                min = this.dis[i];
                index = i;
            }
        }
        //更新 index 顶点被访问过
        already_arr[index] = 1;
        return index;
    }

    public void show() {
        System.out.println("==========================");
        //输出already_arr
        for (int i : already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出pre_visited
        /*for (int i : pre_visited) {
            System.out.print(i + " ");
        }*/
        System.out.println();
        //输出dis
        for (int i : dis) {
            System.out.print(i + " ");
        }
        System.out.println();
        //为了好看最后的最短距离，我们处理
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int count = 0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print(vertex[count] + "(" + i + ") ");
            } else {
                System.out.println("N ");
            }
            count++;
        }

    }
}
