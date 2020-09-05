package org.buptdavid.datastructure.zj.concurrent;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTaskTest extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public ForkJoinTaskTest(long start, long end) {
        this.start = start;
        this.end = end;
    }

    protected Long compute() {
        long sum = 0;
        Boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i < end; i++) {
                sum += i;
            }
        } else {
            //分成100个小任务
            long step = (start + end) / 100;
            ArrayList<ForkJoinTaskTest> subCountTasts = Lists.newArrayList();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if (lastOne > end) {
                    lastOne = end;
                }
                ForkJoinTaskTest subCountTast = new ForkJoinTaskTest(pos, lastOne);
                pos += step + 1;
                subCountTasts.add(subCountTast);
                subCountTast.fork();
            }

            for (ForkJoinTaskTest subCountTast : subCountTasts) {
                sum += subCountTast.join();

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTaskTest countTast = new ForkJoinTaskTest(0L, 4L);
        ForkJoinTask<Long> result = forkJoinPool.submit(countTast);
        try {
            Long aLong = result.get();
            System.out.println("sum =" + aLong);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Long a = 0L;
        for (int i = 0; i < 4L; i++) {
            a += i;
        }
        System.out.println("a=" + a);

    }


}
