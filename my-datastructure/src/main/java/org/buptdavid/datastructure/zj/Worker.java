package org.buptdavid.datastructure.zj;

import java.util.concurrent.CountDownLatch;

public class Worker extends Thread {
    //工作者
    private String name;
    //第一阶段工作时间
    private long time;

    public Worker() {
    }

    private CountDownLatch countDownLatch;

    public Worker(String name, long time, CountDownLatch countDownLatch) {
        super();
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "开始工作");
            Thread.sleep(time);
            System.out.println(name + "第一阶段工作完成，消耗时间time=" + time);
            countDownLatch.countDown();
            Thread.sleep(10000);
            System.out.println(name + "第二阶段工作完成，消耗时间time=" + (time + 10000));

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Worker worker0 = new Worker("worker0", (long) (Math.random() * 2000 + 3000), countDownLatch);
        Worker worker1 = new Worker("worker1", (long) (Math.random() * 2000 + 3000), countDownLatch);
        Worker worker2 = new Worker("worker2", (long) (Math.random() * 2000 + 3000), countDownLatch);
        worker0.start();
        worker1.start();

        countDownLatch.await();
        System.out.println("准备工作继续");
        worker2.start();
        /*Map<Integer, Map<Integer, Long>> map = new HashMap();
		Map<Integer, Long> map1 = new HashMap<Integer, Long>();
//		map1.put(2,10L);
//		map1.put(1,1000L);
//		map1.put(3,1000L);
		Map<Integer, Long> map2 = new HashMap<Integer, Long>();*/
//		map2.put(2,10L);
//		map2.put(1,1000L);
//		map2.put(3,1000L);


//		map.put(200,map1);
//		map.put(100,map1);
//		map.put(300,map2);

		/*String param = JSON.toJSONString(null);
		System.out.println("param:" + param);
		String gxd = "1000";
		String value = gxd + "|" + param;
		Map<Integer, Map<Integer, Long>> valueMap = (Map<Integer, Map<Integer, Long>>) JSON.parse(param);*/
//		Map<Integer, Long> integerLongMap = valueMap.get("200");
//		Long aLong = integerLongMap.get(1);

//		System.out.println(value);

		/*Map<Integer, Map<Integer, Long>> pullTimeMap = (Map<Integer, Map<Integer, Long>>) JSON.parse("");
		System.out.println(pullTimeMap);*/

		/*try {
//			int i=10/0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		AtomicLong meritPointworldWonder = new AtomicLong(0);
		meritPointworldWonder.addAndGet(50);
//		meritPointworldWonder.getAndAdd(50);
		System.out.println(meritPointworldWonder);
		System.out.println("fdzzzzzzzzzzzzzzzzzzzzzzzzsf");*/



		/*Worker test = new Worker();
		int  res = test.strIndex("aaaabcd","abc");
		System.out.println(res);*/


    }

    /**
     * 便利蜂算法面试题：字符串是否包含另一个字符串的位置
     *
     * @param haystack
     * @param needle
     * @return
     */
    int strIndex(String haystack, String needle) {
        //conner case
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.length() == needle.length()) {
            if (haystack == needle) {
                return 0;
            }
            return -1;
        }

        //截取判断
        for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
            String tmp = haystack.substring(i, i + needle.length());

            if (tmp.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}