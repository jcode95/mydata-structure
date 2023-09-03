package bloomfilter;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BloomFilter {
    private BitSet bitSet;
    private int size;
    private int[] seeds;
    private int hashNum;

    public BloomFilter(int size, int hashNum) {
        this.size = size;
        this.hashNum = hashNum;
        this.seeds = generateSeeds(hashNum);
        this.bitSet = new BitSet(size);
    }

    // 哈希函数生成器
    private int[] generateSeeds(int hashNum) {
        int[] seeds = new int[hashNum];
        Random random = new Random();
        for (int i = 0; i < hashNum; i++) {
            seeds[i] = random.nextInt(Integer.MAX_VALUE);
        }
        return seeds;
    }

    // 添加元素到布隆过滤器
    public void add(int num) {
        for (int seed : seeds) {
            int index = hash(num, seed) % size;
            bitSet.set(index);
        }
    }

    // 判断元素是否可能在布隆过滤器中
    public boolean contains(int num) {
        for (int seed : seeds) {
            int index = hash(num, seed) % size;
            if (!bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }

    // 哈希函数
    private int hash(int num, int seed) {
        return (num ^ seed) * 31;
    }

    public static void main(String[] args) {
        int dataSize = 40;
        int hashNum = 5;

        // 创建布隆过滤器
        BloomFilter bloomFilter = new BloomFilter(dataSize, hashNum);

        // 生成40亿个不重复的随机数
        Set<Integer> data = new HashSet<>();
        Random random = new Random();
        while (data.size() < dataSize) {
            data.add(random.nextInt());
        }

        // 将数据添加到布隆过滤器中
        for (int num : data) {
            bloomFilter.add(num);
        }

        // 测试判断一个数是否可能在布隆过滤器中
        int testNum = random.nextInt();
        boolean exists = bloomFilter.contains(testNum);
        System.out.println("Number " + testNum + " may exist in the dataset: " + exists);
    }
}
