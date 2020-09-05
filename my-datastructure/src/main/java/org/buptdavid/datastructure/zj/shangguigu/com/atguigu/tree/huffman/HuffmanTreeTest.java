package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.tree.huffman;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author jiezhou
 * @CalssName: HuffmanTreeTest
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.tree
 * @Description: 哈夫曼树(WPL, 最权小路径，带权最优二叉树)
 * @date 2020/8/24/9:55
 */
public class HuffmanTreeTest {
    public static void main(String[] args) {
        int[] arr = new int[]{13, 7, 8, 3, 29, 6, 1};
        HuffmanNode root = new HuffmanTreeTest().createTree(arr);
        System.out.println(root.toString());
    }


    public HuffmanNode createTree(int[] arr) {
        ArrayList<HuffmanNode> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new HuffmanNode(arr[i]));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);//从小到大排序
            HuffmanNode left = nodes.get(0);
            HuffmanNode right = nodes.get(1);
            //处理一下吧节点权重小的放到左节点
            if (left.weight > right.weight) {
                HuffmanNode tmp = left;
                left = right;
                right = tmp;
            }
            HuffmanNode father = createTree(left, right);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(father);
        }
        return nodes.get(0);
    }

    public HuffmanNode createTree(HuffmanNode left, HuffmanNode right) {
        //构建父节点
        int weight = left.weight + right.weight;
        HuffmanNode fatherNode = new HuffmanNode(weight);
        fatherNode.left = left;
        fatherNode.right = right;
        return fatherNode;
    }
}


