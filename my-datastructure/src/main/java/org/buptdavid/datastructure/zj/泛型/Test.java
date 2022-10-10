package org.buptdavid.datastructure.zj.泛型;

import java.lang.reflect.Array;
import java.util.*;

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

        List<MemberInfo2> pageList = getPageList(ls2, 999, 20);
        System.out.println("pageList = " + pageList);
    }


    public <E> List<E> getPage(List<E> list, int start, int end) {
        List<E> es = list.subList(start, end);
        return es;
    }


    /**
     * 获取list对应的page
     * @param list
     * @param pageNum
     * @param pageSize
     * @param <T>
     * @return
     */
    public static  <T> List<T> getPageList(List<T> list, int pageNum, int pageSize) {
        if (list == null) {
            return null;
        }
        if (list.size() == 0) {
            return list;
        }
        int count = list.size(); // 记录总数
        int pageCount = 0; // 页数,一共多少页

        if (count % pageSize == 0) {//取余计算总页数
            pageCount = count / pageSize;
        } else {
            pageCount = count / pageSize + 1;
        }
        int fromIndex = 0; // 开始索引
        int toIndex = 0; // 结束索引
        if (pageNum > pageCount) {
            return Collections.EMPTY_LIST;
        }

        if (pageNum != pageCount) {
            fromIndex = (pageNum - 1) * pageSize; //从第几个数据开始查
            toIndex = fromIndex + pageSize;
        } else {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = count;
        }
        return list.subList(fromIndex, toIndex);
    }
}
