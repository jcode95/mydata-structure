package org.buptdavid.datastructure.zj.thread.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalRandomTest {

    public static void main(String[] args) throws InterruptedException {
//        ThreadLocalRandom current = ThreadLocalRandom.current();
////        Random current=new Random();
//
//        for (int i = 0; i < 100; i++) {
//            int random = current.nextInt(10);
//            new Thread(new ThreadTest(random)).start();
//        }
//        Thread.sleep(3000);
//        int i = current.nextInt(5, 7);
//        System.out.println(i);

        /*Map<String,String> map=new LinkedHashMap<>();
        //200003|200004|200005|200005           4000|2000|1000|500
        map.put("200003","4000");
        map.put("200004","2000");
        map.put("200005","1000");
        map.put("200006","500");
        int s200003=0;
        int s200004=0; int s200005=0;
        int s200006=0;
        for (int j = 0; j < 1000; j++) {
            int random = random(map);
            if(random==200003){
                s200003++;
            }
            if(random==200004){
                s200004++;
            }
            if(random==200005){
                s200005++;
            }
            if(random==200006){
                s200006++;
            }
        }
        System.out.println("s200003:"+s200003);
        System.out.println("s200004:"+s200004);
        System.out.println("s200005:"+s200005);
        System.out.println("s200006:"+s200006);
*/

        AtomicInteger q = new AtomicInteger(0);
        AtomicInteger w = new AtomicInteger(0);
        AtomicInteger e = new AtomicInteger(0);
        for (int i = 0; i < 100000; i++) {
            int a = a();
            if (a == -1) {
                q.incrementAndGet();
            }
            if (a == 0) {
                w.incrementAndGet();
            }
            if (a == 1) {
                e.incrementAndGet();
            }
        }

        System.out.println("q:" + q);
        System.out.println("w:" + w);
        System.out.println("e:" + e);

    }

    public static class ThreadTest implements Runnable {
        int val = 0;

        ThreadTest(int val) {
            this.val = val;
        }

        @Override
        public void run() {
            System.out.println("线程名称" + Thread.currentThread().getName() + "值：" + val);
            List<Integer> arr = new ArrayList<>();
            arr.add(val);

            //比较
            Boolean flg = false;
            for (int j = 0; j < arr.size(); j++) {
                for (int i = j + 1; i < arr.size() - 1; i++) {
                    if (arr.get(j) == arr.get(i)) {
                        System.out.println("true" + arr.get(j));

                        flg = true;
                        break;
                    }
                }
            }
            if (!flg) {
                System.out.println("false");
            }

        }
    }


    /**
     * 返回这个概率里面的随机值
     *
     * @param min 包含最小
     * @param max 包含最大
     * @return
     */
    public static int randomNum(int min, int max) {
        int num = max + 1 - min;
        if (num <= 0) {
            return min;
        }
        return min + ThreadLocalRandom.current().nextInt(num);
    }

    /**
     * 权重随机（效率佳）
     * 200003|200004|200005|200005           4000|2000|1000|500
     * 4000/7500
     * map
     * <p>
     * 0----500---1000-------2000-------4000
     */

    public static int random(Map<String, String> map) {
        Set<Map.Entry<String, String>> entries = map.entrySet();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int sum = 0;
        for (Map.Entry<String, String> entry : entries) {
            String value = entry.getValue();
            int valueInt = Integer.parseInt(value);
            sum += valueInt;
        }
        int randomInt = random.nextInt(sum) + 1;
        int sum_temp = 0;
        for (Map.Entry<String, String> entry : entries) {
            String value = entry.getValue();
            int valueInt = Integer.parseInt(value);
            sum_temp += valueInt;
            if (randomInt <= sum_temp) {
                return Integer.parseInt(entry.getKey());
            }
        }
        return -1;
    }

    /*
    *
    * 矿工品质	退一级权重	不变权重	进一级权重
        绿	       0	     10	      10
        蓝	      10	     20	      20
        紫	      10	     10	      10
        红

    * */
    public static int a() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int afterWeight = 10;
        int currWeight = 20;
        int beforeWeight = 20;
        int sum = afterWeight + currWeight + beforeWeight;
        int randomInt = random.nextInt(sum) + 1;
        int sum_temp = 0;
        sum_temp += afterWeight;
        if (randomInt <= sum_temp) {
            return -1;
        }
        sum_temp += currWeight;
        if (randomInt <= sum_temp) {
            return 0;
        }
        sum_temp += beforeWeight;
        if (randomInt <= sum_temp) {
            return 1;
        }
        return -2;

    }
}
