package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author jiezhou
 * @CalssName: Graph
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.graph
 * @Description: 图
 * @date 2020/8/28/9:49
 */
public class Graph {
    private List<String> pointList;//存放点的集合
    private int edgeNum;//边的条数
    private int[][] edges;//边的条数
    private boolean[] isVisit;//是否被访问过
    private LinkedBlockingQueue<Integer> bq;//广度优先遍历需要的队列
    private Stack<Integer> stack;//自己使用栈来实现深度与广度的遍历，此属性只在自己的写的方法里面使用

    /**
     * @param n
     */
    public Graph(int n) {
        this.edgeNum = 0;
        this.edges = new int[n][n];
        isVisit = new boolean[n];
        pointList = new ArrayList<>();
        bq = new LinkedBlockingQueue<>();
        stack = new Stack<>();
    }

    /**
     * 自动扩容
     */
    private void dilatation() {
        int newLength = edges.length + 1;
        int[][] newArr = new int[newLength][newLength];
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                newArr[i][j] = edges[i][j];
            }
        }
        isVisit = Arrays.copyOf(isVisit, isVisit.length + 1);
        edges = newArr;
    }

    /**
     * 插入节点
     *
     * @param point
     */
    public void insertPoint(String point) {

        //判断是否超过二维数组的最大值
        if (edges.length == pointList.size()) {
            //需要自动扩容
            dilatation();
        }
        pointList.add(point);
    }

    /**
     * @param indexx 节点下标x
     * @param indexy 节点下标y
     * @param weight 权重
     */
    public void addEdge(int indexx, int indexy, int weight) {
        if (indexx > edges.length - 1 || indexy > edges.length - 1) {
            System.out.println("下标为[" + indexx + "," + indexy + "],没有对应数据！");
            return;
        }
        edges[indexx][indexy] = weight;
        edges[indexy][indexx] = weight;
        edgeNum++;
    }

    /**
     * 返回边的条数
     *
     * @return
     */
    public int getEdgeNum() {
        return edgeNum;
    }

    /**
     * 返回节点的个数
     *
     * @return
     */
    public int getPointNum() {
        return pointList.size();
    }

    /**
     * 根据索引下标返回节点
     *
     * @param index 下标
     * @return
     */
    public String getPointByIndex(int index) {
        if (index > pointList.size() - 1) {
            System.out.println("下标为 " + index + " ,没有对应数据！");
            return "";
        }
        return pointList.get(index);
    }

    /**
     * 根据两个点返回他们之前的权重
     *
     * @param indexx 第一个点
     * @param indexy 第二个点
     * @return
     */
    public int getP1ByP2Weight(int indexx, int indexy) {
        return edges[indexx][indexy];
    }

    private void showGraph() {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * @param indexx 目标点的下标
     * @return 返回目标点的第一个邻接点的下标，没有找到就返回-1
     */
    public int getFristNeighbor(int indexx) {
        for (int i = 0; i < pointList.size(); i++) {
            if (edges[indexx][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param indexx 当前点的下标
     * @param indexy 当前点的下一个邻接点的下标
     * @return 当前点的下一个邻接点的下一个邻接点的下标，就相当于返回 indexy 在indexx维度下的下一个邻接点的下标
     */
    public int getNextNeighbor(int indexx, int indexy) {
        for (int i = indexy + 1; i < pointList.size(); i++) {
            if (edges[indexx][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     *
     * @param bs     节点是否被访问过的存储数组
     * @param indexx 当前节点的下标
     */
    public void dfs(boolean[] bs, int indexx) {
        String s = getPointByIndex(indexx);
        System.out.print(s + "-->");//输出当前点
        int y = getFristNeighbor(indexx);//获取当前点在indexx维度的第一个邻接点的下标
        //设置当前点为访问过的标识
        bs[indexx] = true;
        while (y != -1) {
            //如果找到并且f下标的点没有访问过
            if (!bs[y]) {
                dfs(bs, y);
            }
            //如果被访问过了
            y = getNextNeighbor(indexx, y);//在indexx维度的f下标下获取下一个邻接点的下标
        }
    }

    /**
     * 深度优先遍历
     */
    public void dfs() {
        for (int i = 0; i < pointList.size(); i++) {
            if (!isVisit[i])
                dfs(isVisit, i);
        }
    }

    /**
     * 广度优先遍历
     */
    public void bfs() {
        for (int i = 0; i < isVisit.length; i++) {
            isVisit[i] = false;
        }
        for (int i = 0; i < pointList.size(); i++) {
            if (!isVisit[i])
                bfs(isVisit, i, bq);
        }
    }

    /**
     * 广度优先遍历
     *
     * @param isVisit 节点是否被访问过的存储数组
     * @param i       当前节点的下标
     * @param bq      存储输出的元素下标队列
     */
    private void bfs(boolean[] isVisit, int i, LinkedBlockingQueue<Integer> bq) {
        System.out.print(getPointByIndex(i) + "-->");//输出当前节点
        isVisit[i] = true;//设置为被访问
//        bq.peek()//此方法不移除元素
//        bq.poll();//会移除元素
        try {
            bq.put(i);//入队
            //找下一个邻接点
            while (!bq.isEmpty()) {
                //取出队列的头结点的下标
                Integer poll = bq.poll();
                //获取头结点对应的第一个邻接点的下标
                int f = getFristNeighbor(poll);
                //如果找到
                while (f != -1) {
                    //判断是否访问过
                    if (!isVisit[f]) {
                        System.out.println(getPointByIndex(f) + "-->");
                        //设置为已经访问过
                        isVisit[f] = true;
                        bq.put(f);
                    }
                    //如果没有找到，以poll为维度f为下标找下一个邻接点
                    f = getNextNeighbor(poll, f);//体现广度优先
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*-----------------------------------my---------------------------*/
    private void dfsMy(boolean[] isVisit, int currIndexx) {
        //先把当前节点放入栈
        stack.push(currIndexx);
        //设置当前节点为已经访问过
        isVisit[currIndexx] = true;
        //找到当前节点所有的邻接节点，取没有访问过里面最小的
        int min = getMaxNeighbor(currIndexx);
        while (0 != min) {
            //找到，就递归
            dfsMy(isVisit, min);
            //弹栈
            Integer pop = stack.pop();
            System.out.print(pointList.get(pop) + "<--");
            //找出p栈顶pop的节点所有的邻接节点，取没有访问过里面最小的
            min = getMaxNeighbor(stack.peek());
        }
    }

    private void dfsMy() {
        for (int i = 0; i < isVisit.length; i++) {
            isVisit[i] = false;
        }
        dfsMy(isVisit, 0);
    }

    private void bfsMy() {
        for (int i = 0; i < isVisit.length; i++) {
            isVisit[i] = false;
        }
        for (int i = 0; i < pointList.size(); i++) {

            bfsMy(isVisit, i);
        }
    }

    private void bfsMy(boolean[] isVisit, int i) {
//
        if (!isVisit[i]) {
            isVisit[i] = true;
            System.out.print(pointList.get(i) + "-->");
        }
        List<Integer> ls = getNeighborLs(i);
        if (ls != null && ls.size() > 0) {
            for (int j = 0; j < ls.size(); j++) {
                if (!isVisit[ls.get(j)]) {
                    isVisit[ls.get(j)] = true;
                    System.out.print(pointList.get(ls.get(j)) + "-->");
                }
            }
        }
    }


    /**
     * //找到当前节点所有的邻接节点，取没有访问过里面最小的
     *
     * @param currIndexx 当前节点下标
     * @return
     */
    private int getMinNeighbor(int currIndexx) {
        int minIndex = 999;
        for (int i = 0; i < pointList.size(); i++) {
            if (i == currIndexx) {
                continue;
            }
            if (edges[currIndexx][i] > 0 && minIndex > i && !isVisit[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * //找到当前节点所有的邻接节点，取没有访问过里面最小的
     *
     * @param currIndexx 当前节点下标
     * @return
     */
    private int getMaxNeighbor(int currIndexx) {
        int maxIndex = 0;
        for (int i = 0; i < pointList.size(); i++) {
            if (i == currIndexx) {
                continue;
            }
            if (edges[currIndexx][i] > 0 && i >= maxIndex && !isVisit[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * @param currIndexx 当前节点下标
     * @return 所有邻接点的下标集合
     */
    private List<Integer> getNeighborLs(int currIndexx) {
        ArrayList<Integer> objects = new ArrayList<Integer>();
        for (int i = 0; i < pointList.size(); i++) {
            if (i == currIndexx) {
                continue;
            }
            if (edges[currIndexx][i] > 0) {
                objects.add(i);
            }
        }
        return objects;
    }

    /*-----------------------------------my---------------------------*/
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        /*graph.insertPoint("A");
        graph.insertPoint("B");
        graph.insertPoint("C");
        graph.insertPoint("D");
        graph.insertPoint("E");
        graph.insertPoint("F");
        graph.insertPoint("G");
        graph.insertPoint("H");
        graph.insertPoint("I");*/
        for (int i = 0; i <= 7; i++) {
            graph.insertPoint(i + "");

        }

        /*graph.addEdge(0, 1, 1);
        graph.addEdge(0, 7, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 1);
        graph.addEdge(5, 7, 1);
        graph.addEdge(6, 5, 1);
        graph.addEdge(7, 8, 1);*/
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 1);
        graph.addEdge(3, 7, 1);
        graph.addEdge(4, 7, 1);
        graph.addEdge(5, 6, 1);
       /* graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(1, 5, 1);*/
        System.out.println("-----------");
        graph.showGraph();
//        System.out.println(graph.getPointByIndex(4));
        System.out.println("-----------dfs---------");
        graph.dfs();
//        System.out.println();
        System.out.println("-----------bfs---------");
        graph.bfs();
//        System.out.println();
        System.out.println("-----------dfsMy---------");
        graph.dfsMy();
        while (!graph.stack.isEmpty()) {
            System.out.println(graph.pointList.get(graph.stack.pop()));
        }

        System.out.println("-----------bfsMy---------");
        graph.bfsMy();
        System.out.println("-----------ssss---------");
        int[][] edges = graph.edges;
        for (int i = 0; i < edges.length; i++) {
            for (int k = 0; k < edges.length; k++) {
                if (edges[i][k] != edges[k][i]) {
                    System.out.println("edges[i][k]=" + edges[i][k] + ",i:" + i + " k:" + k);
                }
            }

        }
    }
}
