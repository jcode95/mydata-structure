package org.buptdavid.datastructure.zj;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author jiezhou
 * @CalssName: Demo4
 * @Package org.buptdavid.datastructure.zj
 * @Description:
 * @date 2020/7/6/11:14
 */
public class Demo4 {


    public static void main(String[] args) {
       /* Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        String s = new Demo4().tranMineSet2Str(integers);


        Set<Integer> set = new Demo4().tranMineSet(null);
*/
//        new Demo4().a();
//        System.out.println(set);

    }


    private Set<Integer> tranMineSet(String dataStr) {
        Set<Integer> set = new HashSet<>();
        if (dataStr != null && dataStr != "") {
            String[] str = dataStr.split("\\$");
            for (int i = 0; i < str.length; i++) {
                set.add(Integer.parseInt(str[i]));
            }
        }
        return set;
    }

    private String tranMineSet2Str(Set<Integer> mineSet) {
        StringBuffer sb = new StringBuffer();
        if (mineSet != null && mineSet.size() != 0) {
            Iterator<Integer> iterator = mineSet.iterator();
            while (iterator.hasNext()) {
                Integer mineId = iterator.next();
                sb.append(mineId).append("$");
            }
            if (sb.lastIndexOf("$") != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } else {
            return "";
        }

    }

    public int a() {
        /*int q=1;
        try {
            return q+1;
        }catch (Exception e){

        }finally {
            return q;
        }*/

        TreeSet<Demo5> set = new TreeSet<Demo5>();
        set.add(new Demo5(1));
        set.add(new Demo5(2));
        set.add(new Demo5(3));
        set.add(new Demo5(3));
        set.add(new Demo5(3));
        set.add(new Demo5(3));
        for (Demo5 demo5 : set) {
            System.out.println(demo5.getA());
        }

        return 1;
    }

    class Demo5 implements Comparable{

        int a;
        Demo5(int a){
            this.a=a;
        }
        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        @Override
        public int compareTo(Object o) {
            if(this.getA()>((Demo5) o).getA()){
                return -1;
            }
            if(this.getA()<((Demo5) o).getA()){
                return 1;
            }
            return 0;
        }


    }


}
