package bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class GuavaBloomFilterTest {
    // BloomFilter 容量
    private static final int capacity=100000;

    private static final int key = 1;

    // 构建 BloomFilter
    private static BloomFilter<Integer> bloomFilter=BloomFilter.create(Funnels.integerFunnel(),capacity);
    // 填充数据
    static {
        long startTime = System.currentTimeMillis()/1000;
        for (int i = 0; i < capacity; i++) {
            bloomFilter.put(i);
        }
        long endTime = System.currentTimeMillis()/1000;
        System.out.println("填充数据消耗时间: " + (endTime - startTime) + " 秒");
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
//        long startTime = System.currentTimeMillis();
        if(bloomFilter.mightContain(key)){
            System.out.println( " key : " + key + " 包含在布隆过滤器中 ");
        }else{
            System.out.println( " key : " + key + " 不包含在布隆过滤器中 ");
        }
        long endTime = System.nanoTime();
//        long endTime = System.currentTimeMillis();
        System.out.println("消耗时间: " + (endTime - startTime) + " 微秒");
        // 错误率判断
        double errNums = 0;
        for (int i=capacity+100000;i<capacity+20000000;i++){
            if(bloomFilter.mightContain(i)){
                ++endTime;
            }
        }
        System.out.println("错误率: " + (errNums/100000));
    }


}
