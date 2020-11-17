package org.buptdavid.datastructure.zj.thread.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterDemo {

    public static class Candidate{

        int id;
        volatile int score;
    }


    public static final AtomicIntegerFieldUpdater<Candidate> score=
            AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");
    //检测updater是否工作正确
    public static AtomicInteger allscore=new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final Candidate stu = new Candidate();
        Thread[] threads = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            threads[i]=new Thread(){
                @Override
                public void run() {
                   if(Math.random()>0.4){
                       score.incrementAndGet(stu);
                       allscore.incrementAndGet();
                   }
                }
            };
            threads[i].start();
        }

        for (int i = 0; i < 10000; i++) {
            threads[i].join();
        }
        System.out.println("score="+stu.score);
        System.out.println("allScore="+allscore);
    }

}
