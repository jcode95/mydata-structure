package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.MST.kruskal;


import java.util.*;

/**
 * @author jiezhou
 * @CalssName: Kruskal
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.程序员10大算法.MST.kruskal
 * @Description: 克鲁斯卡尔算法求最小生成树---合适稀疏的网
 * @date 2020/9/5/10:39
 */
public class Kruskal {
    //使用 INF 表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        //邻接矩阵的关系使用二维数组表示,99999这个大数，表示两个点不联通
       /* int[][] edges = new int[][]{
                {99999, 5, 7, 99999, 99999, 99999, 2},
                {5, 99999, 99999, 9, 99999, 99999, 3},
                {7, 99999, 99999, 99999, 8, 99999, 99999},
                {99999, 9, 99999, 99999, 99999, 4, 99999},
                {99999, 99999, 8, 99999, 99999, 5, 4},
                {99999, 99999, 99999, 4, 5, 99999, 6},
                {2, 3, 99999, 99999, 4, 6, 99999},};*/
        //克鲁斯卡尔算法的邻接矩阵
        int edges[][] = {
          /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
	/*A*/ {0, 12, INF, INF, INF, 16, 14},
	/*B*/ {12, 0, 10, INF, INF, 7, INF},
	/*C*/ {INF, 10, 0, 3, 5, 6, INF},
	/*D*/ {INF, INF, 3, 0, 4, INF, INF},
	/*E*/ {INF, INF, 5, 4, 0, 2, 8},
	/*F*/ {16, 7, 6, INF, 2, 0, 9},
	/*G*/ {14, INF, INF, INF, 8, 9, 0}};
        Node A = new Node('A', 1);
        Node B = new Node('B', 2);
        Node C = new Node('C', 3);
        Node D = new Node('D', 4);
        Node E = new Node('E', 5);
        Node F = new Node('F', 6);
        Node G = new Node('G', 7);
        Node[] data = new Node[]{A, B, C, D, E, F, G};
        MinSTree minSTree = new MinSTree(edges, data);
        minSTree.showGraph();
        minSTree.buildMinTree();
    }


}

class MinSTree {
    private int[][] edges;//边
    private Node[] data;//节点数据

    public MinSTree(int[][] edges, Node[] data) {
        this.edges = edges;
        this.data = data;
    }

    /**
     * 打印边的信息
     */
    public void showGraph() {
        if (edges != null) {
            for (int i = 0; i < edges.length; i++) {
                System.out.println(Arrays.toString(edges[i]));
            }
        }
    }

    public void buildMinTree() {
        //先对图的边按照从小到大排序,使用map
        ArrayList<String> tmp = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                if (tmp.contains(j + "-" + i + "," + edges[i][j]) || i == j) {
                    continue;
                }
                tmp.add(i + "-" + j + "," + edges[i][j]);
            }
        }
        String[] arr = new String[tmp.size()];
        tmp.toArray(arr);
        tmp = null;
        //对list进行从小到大排序，使用插入排序
        for (int i = 1; i < arr.length; i++) {
            String currStr = arr[i];
            if (currStr == null) {
                continue;
            }
            int currValue = Integer.parseInt(currStr.split(",")[1]);
            int insertIndex = i - 1;
            while (insertIndex >= 0 && currValue < Integer.parseInt(arr[insertIndex].split(",")[1])) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = currStr;
        }
        System.out.println(Arrays.toString(arr));
        //遍历数组arr
        int edgeCount = 0;
        /*
        *  //下面list嵌套list的解释：
        *   假如先找到A-B  然后再找到C-D,第三次的时候找到B-C,这时B-C
        *  的flg并不相同，所以要把C的flg设置成B的flg,但是C-D
        * 的flg已经处理过成为相同的，这时就要把D的flg一块处理成B的flg，
        *
        * 使用list嵌套list是便于存储相关联的node
        *
        *
        * */
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        ArrayList<Node> ls = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            int indexx = Integer.parseInt(str.split(",")[0].split("-")[0]);//第一个点的下标
            int indexy = Integer.parseInt(str.split(",")[0].split("-")[1]);//第二个点的下标
            /*1、设置第二个点的flg标识为第一个点的标识*/
            Node nodeX = data[indexx];
            Node nodeY = data[indexy];
            if (nodeY.flg != nodeX.flg) {
                nodeY.flg = nodeX.flg;
                if (list.size() > 0) {
                    for (int k = 0; k < list.size(); k++) {
                        if (list.get(k).contains(nodeY)) {
                            for (int p = 0; p < list.get(k).size(); p++) {
                                list.get(k).get(p).flg = nodeX.flg;
                            }
                        }
                    }
                }
                ls.add(nodeX);
                ls.add(nodeY);
                list.add(ls);
                edgeCount++;
                System.out.println(nodeX.point + " " + nodeY.point + " 权重: " + str.split(",")[1]);
                if (edgeCount == edges.length - 1) {//最小生成树的特点：n个顶点必然会有n-1条边
                    return;
                }
            }

        }


    }


}

class Node {
    public Character point;
    public int flg;

    public Node(Character point, int flg) {
        this.point = point;
        this.flg = flg;
    }
}
