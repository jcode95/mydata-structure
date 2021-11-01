package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.tree.huffman;

import java.io.*;
import java.util.*;

/**
 * @author jiezhou
 * @CalssName: HuffmanEncoding
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.tree.huffman
 * @Description: 哈夫曼编码
 * @date 2020/8/24/11:10
 */
public class HuffmanEncoding2Decoding {
    private static HashMap<Byte, String> varMap = new HashMap<Byte, String>();//如：a:100
    private static String sb = "";//构造哈夫曼编码表的辅助字符串

    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        System.out.println("压缩之前的长度："+str.length());
        HuffmanEncodeNode root = new HuffmanEncoding2Decoding().encode(str.getBytes());
        for (Map.Entry<Byte, String> entry : varMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        byte[] v = huffmanEncode(str.getBytes(),varMap);
        System.out.println("压缩之后的长度："+v.length);
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }
        byte[] s = huffmanDecode(v,varMap);
        System.out.println("解码之后的原字符串：" + new String(s));


        /* -------------------------文件压缩------------------------------*/
       /* HuffmanEncoding2Decoding huffman = new HuffmanEncoding2Decoding();
        String srcFile = "F:\\huffmanZip\\草稿.txt";
        String zipFile = "F:\\huffmanZip\\b.rar";
        String unzipFile = "F:\\huffmanZip\\c.txt";
        huffman.zip(srcFile, zipFile);
        System.out.println("压缩完成！");
        unZip(zipFile, unzipFile);
        System.out.println("解压完成！");*/
    }

    /**
     * @param srcFile 原始文件全路径
     * @param outFile 压缩后文件输出的路径
     */
    public  void zip(String srcFile, String outFile) {
        FileInputStream in = null;
        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            in = new FileInputStream(srcFile);
            byte[] bytes = new byte[in.available()];//创建和原文件大小一样的byte数组，用于接收文件内容
            //读取文件
            in.read(bytes);
            /*读取完毕，*/
            System.out.println("压缩之前的长度："+bytes.length);
            //1、使用文件内容构建哈夫曼树，得到哈夫曼编码表varMap
            HuffmanEncodeNode encode = encode(bytes);
            //2、使用哈夫曼编码压缩成byte数组
            byte[] huffmanEncodeByte = huffmanEncode(bytes, varMap);//这就是压缩后的数组
            System.out.println("压缩之后的长度："+huffmanEncodeByte.length);
            //3、创建文件的输出流
            os = new FileOutputStream(outFile);
            //4、创建一个和文件输出流关联的ObjectOutputStream;
            oos = new ObjectOutputStream(os);
            //5、把压缩之后的字节数组写入压缩文件
            oos.writeObject(huffmanEncodeByte);
            //6、这里我们以对象流的方法写入哈夫曼的编码表
            oos.writeObject(varMap);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (os != null) {
                    os.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 解压
     * @param zipFile 准备解压的文件
     * @param outFile 解压之后的文件
     */
    public static void unZip(String zipFile, String outFile) {
        InputStream is = null;
        ObjectInputStream ois = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);

            byte[] bytes = (byte[]) ois.readObject();//读取原始文件
            HashMap<Byte, String> map = (HashMap<Byte, String>) ois.readObject();//读取编码表
            //解码
            byte[] var = huffmanDecode(bytes, map);
            os = new FileOutputStream(outFile);
            os.write(var);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @param srcByte      原始数组
     * @param huffmanCodes 哈夫曼编码表
     * @return 压缩后的数组
     */
    private static byte[] huffmanEncode(byte[] srcByte, HashMap<Byte, String> huffmanCodes) {
        StringBuilder sb = new StringBuilder();
        if (huffmanCodes.isEmpty()) {
            return null;
        }
        //遍历bytes 数组
        for (byte b : srcByte) {
            sb.append(huffmanCodes.get(b));
        }
        String var = sb.toString();//1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
        //将var转为byte数组，用于网络传输
        int len;
        if (var.length() % 8 == 0) {
            len = var.length() / 8;
        } else {
            len = var.length() / 8 + 1;
        }
        byte[] result = new byte[len];
        int index = 0;//记录byte数组的第几位
        for (int i = 0; i < var.length(); i += 8) {
            String var1;
            if (i + 8 > var.length()) {
                var1 = var.substring(i);
            } else {
                var1 = var.substring(i, i + 8);
            }
            result[index] = (byte) Integer.parseInt(var1, 2);
            index++;
        }
        return result;
    }

    /**
     * @param flg 是否需要按位与
     * @param b   原byte数组里面的元素
     * @return
     */
    private static String byte2String(boolean flg, byte b) {
        int tmp = b;//转为int类型
        if (flg) {//不是最后一位就需要按位与
            tmp |= 256;
        }
        String string = Integer.toBinaryString(tmp);
        if (flg) {
            return string.substring(string.length() - 8);
        }
        return string;
    }

    /**
     * 哈夫曼解码
     *
     * @param bytes 压缩之后的byte数组
     * @param varMap 哈夫曼编码表
     * @return 原数据的byte数组
     */
    private static byte[] huffmanDecode(byte[] bytes, HashMap<Byte, String> varMap) {
        if (bytes.length == 0) {
            return null;
        }
        /*压缩后的byte数组转为二进制的字符串*/
        StringBuilder sb = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < bytes.length; k++) {
            boolean flg = (k == bytes.length - 1);
            stringBuilder.append(byte2String(!flg, bytes[k]));
        }
        String str = stringBuilder.toString();//二进制字符串
//        System.out.println("byte转二进制字符串：" + str);
        if (str == null) {
            return null;
        }
        //创建一个list用来存放原来的数据的byte数组
        ArrayList<Byte> srcBytesList = new ArrayList<>();
        //定义两个指针，i指向起点指针，j指向后指针
        int i = 0;
        int j = 1;
        while (i <= str.length() && j <= str.length()) {
            Byte var = chack(str.substring(i, j), varMap);
            if (var != null) {
                srcBytesList.add(var);
                i = j;
                j++;
            } else {
                j++;
            }
        }
        byte[] srcBytes = new byte[srcBytesList.size()];
        for (int k = 0; k < srcBytesList.size(); k++) {
            srcBytes[k]=srcBytesList.get(k);
        }
        return srcBytes;
    }

    private static Byte chack(String str, HashMap<Byte, String> varMap) {
        for (Map.Entry<Byte, String> entry : varMap.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * 哈夫曼树 得到哈弗曼树和哈夫曼编码表varMap
     *
     * @param srcBytes 原byte数组
     * @return 哈夫曼树
     */
    public HuffmanEncodeNode encode(byte[] srcBytes) {
        HashMap<Byte, Integer> map = new HashMap<>();
        //统计字符 的个数，存在map里面
        for (int i = 0; i < srcBytes.length; i++) {
            Integer integer = map.get(srcBytes[i]);
            if (integer == null) {
                integer = 0;
            }
            map.put(srcBytes[i], integer + 1);
        }
        Set<Map.Entry<Byte, Integer>> set = map.entrySet();
        //创建一个list
        ArrayList<HuffmanEncodeNode> ls = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : set) {
            ls.add(new HuffmanEncodeNode(entry.getValue(), entry.getKey()));
        }
        //根据ls创建哈夫曼树
        HuffmanEncodeNode root = createHuffmanTree(ls);
        //得到哈夫曼编码表varMap
        processEncoding(root);
        return root;
    }

    private void processEncoding(HuffmanEncodeNode node) {
        if (node.left == null && node.right == null) {
            varMap.put(node.data, sb);
            return;
        }
        sb += node.left.flg;
        processEncoding(node.left);
        sb = sb.substring(0, sb.length() - 1);//退回到当前节点的上级，相当于回到上一级 所以,sb.length() - 1
        sb += node.right.flg;
        processEncoding(node.right);
        sb = sb.substring(0, sb.length() - 1);//退回到当前节点的上级，相当于回到上一级
    }

    /**
     * 创建哈夫曼树
     *
     * @param ls
     * @return
     */
    private HuffmanEncodeNode createHuffmanTree(List<HuffmanEncodeNode> ls) {
        while (ls.size() > 1) {
            Collections.sort(ls);//排序，每进行一次就重新排序一次
            HuffmanEncodeNode left = ls.get(0);
            HuffmanEncodeNode right = ls.get(1);
            right.flg = 1;
            if (left.weight > right.weight) {
                left.flg = 0;
                right.flg = 1;
                HuffmanEncodeNode tmp = left;
                left = right;
                right = tmp;
            }
            HuffmanEncodeNode father = createHuffmanTree(left, right);
            //移除原来使用过的叶子节点
            ls.remove(left);
            ls.remove(right);
            //添加父节点
            ls.add(father);
        }
        return ls.get(0);
    }

    private HuffmanEncodeNode createHuffmanTree(HuffmanEncodeNode left, HuffmanEncodeNode right) {
        int weight = left.weight + right.weight;
        HuffmanEncodeNode father = new HuffmanEncodeNode(weight);
        father.left = left;
        father.right = right;
        return father;
    }
}

class HuffmanEncodeNode implements Comparable<HuffmanEncodeNode> {
    public byte data; //字符
    public int weight;//权重
    public int flg = 0;//是左节点是0，是右节点是1
    public HuffmanEncodeNode left;
    public HuffmanEncodeNode right;

    public HuffmanEncodeNode(int weight, byte data) {
        this.weight = weight;
        this.data = data;
    }

    public HuffmanEncodeNode(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HuffmanEncodeNode{" +
                "data=" + data +
                ", weight=" + weight +
                ", flg=" + flg +
                '}';
    }

    @Override
    public int compareTo(HuffmanEncodeNode o) {
        return this.weight - o.weight;
    }
}
