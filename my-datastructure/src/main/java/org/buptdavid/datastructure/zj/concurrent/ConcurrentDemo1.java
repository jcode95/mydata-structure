package org.buptdavid.datastructure.zj.concurrent;

public class ConcurrentDemo1 {
    private static int t = 0;
    private static int t1 = 1;

    public static class Task implements Runnable {
        public void run() {
            Boolean flg = t != (t = t1);
            System.out.println(Thread.currentThread().getId() + "= flg==" + flg);
            if (flg) {
                System.err.println(Thread.currentThread().getId() + "= ======================================flg==" + flg);
            }
        }
    }

    public static void main(String[] args) {
        Task task = new Task();

        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }


    }


}
