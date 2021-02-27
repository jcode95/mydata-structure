package org.buptdavid.datastructure.zj.thread.test.forkjointask;

import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {
    final int n;

    Fibonacci(int n) {
        this.n = n;
    }

    @Override
    public Integer compute() {
        if (n <= 1) return n;
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.compute() + f1.join();
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci(5);
        boolean isZhengChang = f.exec();//得到任务是否正常完成、true如果此任务已知已正常完成
        System.out.println("isZhengChang = " + isZhengChang);
        Integer result = f.compute();
        System.out.println("result = " + result);

    }
}
