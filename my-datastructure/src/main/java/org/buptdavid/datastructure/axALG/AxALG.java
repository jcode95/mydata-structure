package org.buptdavid.datastructure.axALG;


import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * A*寻路算法
 */
public class AxALG {


    private static final int cost_map_horizontal = MapConstants.MAP_WIDTH;

    private static final int cost_map_vertical = MapConstants.MAP_HEIGHT;

    private static final int cost_map_diagonal = (int) Math.round(Math.sqrt(cost_map_horizontal * cost_map_horizontal) + (cost_map_vertical * cost_map_vertical));


    private int wMap; // 地图列数（每行格点数）
    private int hMap; // 地图行数（每列格点数）
    private Note[][] nodes;

/*    private void init(Note[][] nodes) {
        this.hMap = nodes.length;
        this.wMap = nodes[0].length;
        this.nodes = nodes;
    }*/

    public void init() {
        Note[][] nodes = new Note[100][100];
        for (int i = 0; i < 100; i++) {
            nodes[i] = new Note[100];
            for (int j = 0; j < 100; j++) {
                nodes[i][j] = new Note((byte) 0, (byte) 0);
                //在4,4 处设置一个障碍物
                if (i == 4 && j == 4) {
                    nodes[i][j].setType((byte) 5);
                }
                //在3,0处设置一个障碍物
                if (i == 3 && j == 0) {
                    nodes[i][j].setType((byte) 5);
                }
                //在3,2处设置一个障碍物
                if (i == 3 && j == 2) {
                    nodes[i][j].setType((byte) 5);
                }
            }
        }
        this.hMap = nodes.length;
        this.wMap = nodes[0].length;
        this.nodes = nodes;
    }

    //查找路径（寻路入口）
    public void find(Point startPoint, Point endPoint, LinkedList<Point> pathPoints) {
        this.init();//初始化地图
        if (!isChack(endPoint)) {  // 判断终点可不可达
            return;
        }

        LinkedList<ANode> openList = new LinkedList<ANode>();// 开放列表
        LinkedList<ANode> closeList = new LinkedList<ANode>();// 关闭列表
        Map<String, ANode> AStarMap = new HashMap<String, ANode>();
        boolean isFinded = false;// 能否找到路径，true-已找到
        ANode currentNode;// 起点
        ANode endNode;// 终点
        currentNode = new ANode(startPoint.x, startPoint.y);// 初始化起点为当前点
        endNode = new ANode(endPoint.x, endPoint.y);// 初始化终点
        AStarMap.put(startPoint.x + "_" + startPoint.y, currentNode);
        AStarMap.put(endPoint.x + "_" + endPoint.y, currentNode);

        openList.add(currentNode);// 把起点加入到开放列表中

        while (openList.size() > 0) {//只要openList（栈）里面有元素，就会一直循环
            // 取出并删除开放列表第一个元素
            currentNode = openList.getFirst();
            openList.removeFirst();
            // 加入到关闭列表
            currentNode.isInOpen = false;
            currentNode.isInClose = true;
            closeList.add(currentNode);
            //判断当前点是否为终点
            if (currentNode.x == endNode.x && currentNode.y == endNode.y) {
                isFinded = true;
                break;
            }
            //如果还没有走到终点
            //去相邻八个方向的节点，除去不可通过和已经在关闭列表的节点
            ArrayList<ANode> aroundNodes = this.getAroundsNode(currentNode.x, currentNode.y, AStarMap);
            // 检测相邻的八个方向的节点
            for (ANode node : aroundNodes) {
                // 计算 G， H 值
                int gValue = getG(currentNode, node);//起点到当前点的真实距离
                int hValue = getH(endNode, node);//当前点到终点的预测距离
                // 如果节点已在开放列表中，并且该节点新的G值比原来的G值小,修改F,G值，设置该节点的父节点为当前节点
                if (node.isInOpen) {
                    if (gValue < node.g) {
                        node.g = gValue;
                        node.h = hValue;
                        node.f = gValue + hValue;
                        node.parentNode = currentNode;
                        this.findAndSort(node, openList);
                    }
                } else {// 如果节点不在开放列表中,插入开放列表中，并按照估价值排序
                    node.g = gValue;
                    node.h = hValue;
                    node.f = gValue + hValue;
                    node.parentNode = currentNode;
                    node.isInOpen = true;
                    this.insertAndSort(node, openList);
                }
            }
        }
        if (isFinded) {// 找到路径
            this.createPath(startPoint.x, startPoint.y, closeList, pathPoints);
            return;
        } else {// 没有找到路径
            pathPoints.clear();
        }
    }

    /**
     * 生成路径
     *
     * @param x
     * @param y
     * @param closeList
     * @param pathPoints
     */
    private void createPath(int x, int y, LinkedList<ANode> closeList, LinkedList<Point> pathPoints) {
        //获取到最后一个点
        ANode node = closeList.get(closeList.size() - 1);
        closeList.remove(node);
        while (node.x != x || node.y != y) {
            pathPoints.add(0, new Point(node.x, node.y));
            node = node.parentNode;
        }
        pathPoints.add(0, new Point(node.x, node.y));
    }

    /**
     * 按由小到大顺序将节点插入到列表
     */
    private void insertAndSort(ANode node, LinkedList<ANode> openList) {
        int size = openList.size();
        if (size == 0) {
            openList.add(node);
        } else {
            for (int i = 0; i < size; i++) {
                //判断f值
                if (node.f < openList.get(i).f) {
                    openList.add(i, node);
                    return;
                }
            }
            //如果是当前oplist里面最大的，直接在后面添加
            openList.add(node);
        }

    }

    /**
     * 按由小到大顺序将节点插入到列表
     */
    private void findAndSort(ANode node, LinkedList<ANode> openList) {
        int size = openList.size();
        if (size == 0) {
            return;
        } else {
            openList.removeLast();
            openList.addLast(node);
        }

    }

    /**
     * (计算H值)当前点到终点的预测距离
     *
     * @param endNode
     * @param node
     * @return
     */
    private int getH(ANode endNode, ANode node) {
        int dx = Math.abs(endNode.x - node.x) * cost_map_horizontal;
        int dy = Math.abs(endNode.y - node.y) * cost_map_vertical;
        return dx + dy;
    }

    /**
     * 计算G值
     *
     * @param currentNode
     * @param node
     * @return
     */
    private int getG(ANode currentNode, ANode node) {
        int g = 0;
        if (currentNode.y == node.y) {// 横向
            g = currentNode.g + cost_map_horizontal;
        } else if (currentNode.x == node.x) {// 竖向
            g = currentNode.g + cost_map_vertical;
        } else {// 斜向
            g = currentNode.g + cost_map_diagonal;
        }
        return g;
    }

    //  //去相邻八个方向的节点，除去不可通过和已经在关闭列表的节点
    private ArrayList<ANode> getAroundsNode(int x, int y, Map<String, ANode> aStarMap) {
        ArrayList<ANode> arr = new ArrayList<>();
        int checkX, checkY;
        // 左
        checkX = x - 1;
        checkY = y;
        if (checkX >= 0) {
            checkNode(checkX, checkY, aStarMap, arr);
        }
        // 右
        checkX = x + 1;
        checkY = y;
        checkNode(checkX, checkY, aStarMap, arr);
        // 上
        checkX = x;
        checkY = y - 1;
        if (checkY >= 0) {
            checkNode(checkX, checkY, aStarMap, arr);
        }
        // 下
        checkX = x;
        checkY = y + 1;
        checkNode(checkX, checkY, aStarMap, arr);
        // 左上
        checkX = x - 1;
        checkY = y - 1;
        if (checkX >= 0 && checkY >= 0) {
            checkNode(checkX, checkY, aStarMap, arr);
        }
        // 左下
        checkX = x - 1;
        checkY = y + 1;
        if (checkX >= 0) {
            checkNode(checkX, checkY, aStarMap, arr);
        }

        // 右上
        checkX = x + 1;
        checkY = y - 1;
        if (checkY >= 0) {
            checkNode(checkX, checkY, aStarMap, arr);
        }
        // 右下
        checkX = x + 1;
        checkY = y + 1;
        checkNode(checkX, checkY, aStarMap, arr);
        return arr;
    }

    private void checkNode(int checkX, int checkY, Map<String, ANode> aStarMap, ArrayList<ANode> arr) {
        /**
         * 检查点在地图上是否可通过
         */
        Boolean isPass = true;//true 为可以通过，false 为不可以通过
        // 1. 是否是有效的地图上点（数组边界检查）
        if (checkX < 0 || checkX >= this.wMap) {
            isPass = false;
        }
        if (checkY < 0 || checkY >= this.hMap) {
            isPass = false;
        }
        if (!nodes[checkX][checkY].checkXY()) {
            isPass = false;
        }
        if (isPass) {
            ANode node = aStarMap.get(checkX + "*" + checkY);
            if (node != null) {
                if (!node.isInClose) {
                    arr.add(node);
                }
            } else {
                ANode aNode = new ANode(checkX, checkY);
                arr.add(aNode);
                aStarMap.put(checkX + "*" + checkY, aNode);
            }
        }
    }

    private boolean isChack(Point endPoint) {
        //判断是否超出地图范围
        if (endPoint.x < 0 || endPoint.x > 10000) {
            return false;
        }
        if (endPoint.y < 0 || endPoint.y > 10000) {
            return false;
        }
        //判断是否是障碍物
        if (nodes[endPoint.x][endPoint.y].getUse() == 2 || nodes[endPoint.x][endPoint.y].getType() == 5) {
            return false;
        }
        return true;
    }

    class ANode {

        public int x;
        public int y;
        public boolean isInOpen;
        public boolean isInClose;
        public int g;
        public int h;
        public int f;
        public ANode parentNode;

        public ANode(int x, int y) {
            this.x = x;
            this.y = y;
            this.isInOpen = false;
            this.isInClose = false;
            this.g = 0;
            this.h = 0;
            this.f = 0;
            this.parentNode = null;
        }
    }

}
