package org.buptdavid.datastructure.zj.thread.test;


import java.util.concurrent.*;

public class CountTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10000;
    private long start;
    private long end;


    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i < end; i++) {
                sum += i;
            }
        } else {
            //分成100个小任务
            long step = (start + end) / 100;
            CopyOnWriteArrayList<CountTask> countTasks = new CopyOnWriteArrayList<CountTask>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = step + pos;
                if (lastOne > end) {
                    lastOne = end;
                }
                CountTask countTask = new CountTask(pos, lastOne);
                pos += step + 1;
                countTasks.add(countTask);
                countTask.fork();
                boolean exec = countTask.exec();
                System.out.println("exec = " + exec);
            }
            for (CountTask countTask : countTasks) {
                sum += countTask.join();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(0L, 500);
        ForkJoinTask<Long> result = forkJoinPool.submit(countTask);
        try {
            Long aLong = result.get();
            System.out.println("sum=:" + aLong);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        int sums = 0;
        for (int i = 0; i < 500; i++) {
            sums+=i;
        }
        System.out.println("sums = " + sums);


        System.out.println(Runtime.getRuntime().availableProcessors());
    }


}
