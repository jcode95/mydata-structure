package org.buptdavid.datastructure.zj.thread.test;

/**
 * @author jiezhou
 * @CalssName: AQSTest
 * @Package org.buptdavid.datastructure.zj.thread.test
 * @Description: 抽象队列同步器
 * 抽象：
 *      是juc的基石，抽象了通用方法
 * 队列同步器：
 *     对需要等待的线程进行管理，底层就是使用队列（单向CLH队列）来就行管理的，并通过一个int类型的变量（state）来表示锁的状态（占用/未占用）
 *     AQS在单向CLH队列上做了个变种，做成双向的
 *
 * @date 2021/3/3/10:25
 */
public class AQSTest {
}
