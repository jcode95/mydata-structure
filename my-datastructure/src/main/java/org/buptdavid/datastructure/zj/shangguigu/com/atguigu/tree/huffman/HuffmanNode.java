package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.tree.huffman;


class HuffmanNode implements Comparable<HuffmanNode>{
    public int weight;//权重
    public HuffmanNode left;
    public HuffmanNode right;

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "weight=" + weight +
                '}';
    }

    public HuffmanNode(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.weight-o.weight;
    }
}