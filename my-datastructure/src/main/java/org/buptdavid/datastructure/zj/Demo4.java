package org.buptdavid.datastructure.zj;

import java.util.*;

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
       /* for (int i = 0; i < 100; i++) {
            System.out.println(refreshTaskByColor(2));
        }*/

//        Calendar instance1 = Calendar.getInstance();
//        instance1.set(Calendar.DATE,11);
//        instance1.set(Calendar.HOUR_OF_DAY, 0);
//        instance1.set(Calendar.MINUTE, 4);
//        instance1.set(Calendar.SECOND, 0);
//        instance1.set(Calendar.MILLISECOND, 0);
        long curr = System.currentTimeMillis();
//        long curr=instance1.getTimeInMillis();
        long lingdianTime = curr / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset() + 23 * 1000 * 3600 + 55 * 1000 * 60;
        long nextTime = curr / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset() + 1000 * 3600 * 24 + 5 * 1000 * 60;
        if(curr>lingdianTime&&curr<nextTime){
            System.out.println("----------不能发---------------");
            return;
        }else{
            System.out.println("--------------能发-------");
        }


        Demo4 demo4 = new Demo4();
        System.out.println("demo4.b(); = " + demo4.b());

    }

    /**
     * 随机取到比beginColor 大或者等于beginColor 的 color
     * @param beginColor
     * @return
     */
    public static int refreshTaskByColor(int beginColor) {
        float ranRate = new Random().nextFloat();
        List<Float> rateList =  new ArrayList<>();
        rateList.add(0.2F);
        rateList.add(0.3F);
        rateList.add(0.37F);
        rateList.add(0.13F);
        float rate = 0;
        for (int i = beginColor-1; i < rateList.size(); i++) {
            rate = rateList.get(i) + rate;
            if (ranRate < rate) {
                return i+=2;
            }
        }
        return beginColor;
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
    public int b(){
        for (int i = 1; i <= 17; i++) {
            System.out.println("com/gamebase/zhuanpan/structs/ZhuanpanType$" + i+".class");
        }


       /* int q=1;
        try {
            q+=1;
//            q/=0;
            return q+1;
        }catch (Exception e){
            e.printStackTrace();
            return q+2;
        }finally {
            return q;
        }*/
       return 0;
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
