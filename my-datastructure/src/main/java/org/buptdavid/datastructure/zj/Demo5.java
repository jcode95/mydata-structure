package org.buptdavid.datastructure.zj;

import java.util.ArrayList;

/**
 * @author jiezhou
 * @CalssName: Demo5
 * @Package org.buptdavid.datastructure.zj
 * @Description:
 * @date 2020/7/6/17:23
 */
public class Demo5 {
    public static void main(String[] args) {
        ArrayList<A> ls = new ArrayList<A>();
        for (int i = 4; i < 9; i++) {
            A a = new A();
            a.setId(i);
            a.setName("aa" + i);
            ls.add(a);
        }
//        for (int i =0; i < 3; i++) {
//            A a = new A();
//            a.setId(i);
//            a.setName("aa"+i);
//            ls.add(a);
//        }
        for (int k = 0; k < 1000; k++) {
            for (int i = 0; i < ls.size(); i++) {
                System.out.println(ls.get(i).toString());
            }
            System.out.println("===========================");
        }


    }

    static class A implements Comparable<Integer> {
        int id;
        String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Integer t) {
            return this.id - t;
        }

        @Override
        public String toString() {
            return "A{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
