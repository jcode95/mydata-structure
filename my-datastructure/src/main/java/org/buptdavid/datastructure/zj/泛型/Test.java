package org.buptdavid.datastructure.zj.泛型;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author jiezhou
 * @CalssName: Test
 * @Package org.buptdavid.datastructure.zj.泛型
 * @Description: 泛型测试
 * @date 2022/8/8/23:10
 */
public class Test {


    public static void main(String[] args) {
        ArrayList<MemberInfo> ls = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.setAge(i);
            memberInfo.setCreateTime(new Date());
            ls.add(memberInfo);
        }
        System.out.println("ls----- = " + ls.size());
        List<MemberInfo> page = new Test().getPage(ls,90,100);
        for (MemberInfo memberInfo : page) {
            System.out.println("memberInfo = " + memberInfo.toString());
        }


        System.out.println("++++++++++++++++++++++++++");
        ArrayList<MemberInfo2> ls2 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            MemberInfo2 memberInfo2 = new MemberInfo2();
            memberInfo2.setName("c" + i);
            memberInfo2.setTitle("c" + i);
            ls2.add(memberInfo2);
        }
        System.out.println("ls2----- = " + ls.size());
        List<MemberInfo2> page2 = new Test().getPage(ls2, 1, 80);
        for (MemberInfo2 memberInfo2 : page2) {
            System.out.println("memberInfo2 = " + memberInfo2.toString());
        }
    }


    public <E> List<E> getPage(List<E> list, int start, int end) {
        List<E> es = list.subList(start, end);
        return es;
    }
}
