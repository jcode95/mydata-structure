package org.buptdavid.datastructure.zj.刷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    /*
    *
    *
    * [2,4,3]
       [5,6,4]
    *
    * */
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,5};//51+5=56
        int[] arr2 = new int[]{5};
        ListNode frist1 = new ListNode(arr1[0]);
        ListNode frist2 = new ListNode(arr2[0]);
        ListNode tail1 = frist1;
        ListNode tail2 = frist2;
        for (int i = 1; i < arr1.length; i++) {
            ListNode listNode = new ListNode(arr1[i]);
            tail1.next = listNode;
            tail1 = tail1.next;
        }
        for (int i = 1; i < arr2.length; i++) {
            ListNode listNode = new ListNode(arr2[i]);
            tail2.next = listNode;
            tail2 = tail2.next;
        }
        ListNode listNode = new Solution().addTwoNumbers(frist1, frist2);
        System.out.println(listNode.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(l1.val);
        List<Integer> list2 = new ArrayList<>();
        list2.add(l2.val);
        while (l1.next != null) {
            list1.add(l1.next.val);
            l1 = l1.next;
        }
        while (l2.next != null) {
            list2.add(l2.next.val);
            l2 = l2.next;
        }
//        1 2 3 4
//        0 0 2 3
        Collections.reverse(list1);
        Collections.reverse(list2);
        String process = process(list1, list2);//0,1
        String[] split = process.split(",");
        ListNode newFristNode1Head = new ListNode(Integer.parseInt(split[0]));
        ListNode newFristNode1Tail = newFristNode1Head;

        for (int i = 1; i <=split.length - 1; i++) {
            newFristNode1Tail.next = new ListNode(Integer.parseInt(split[i]));
            newFristNode1Tail = newFristNode1Tail.next;
        }
        return newFristNode1Head;

    }

    public String process(List<Integer> ls1, List<Integer> ls2) {
        Integer[] arr1 = new Integer[ls1.size()];
        Integer[] arr2 = new Integer[ls2.size()];
        ls1.toArray(arr1);
        ls2.toArray(arr2);
        int msxLength = arr1.length;

        if (arr2.length > arr1.length) {
            msxLength = arr2.length;
        }
        int[] var = new int[msxLength];
        int flg = 0;
        if (arr2.length > arr1.length) {
            flg = 1;
            int index = (arr2.length - arr1.length);
            for (int i = 0; i < arr1.length; i++) {
                var[index] = arr1[i];
                index++;
            }
        } else if (arr1.length > arr2.length) {
            flg = 2;
            int index = (arr1.length - arr2.length);
            for (int i = 0; i < arr2.length; i++) {
                var[index] = arr2[i];
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean flg1 = false;
        for (int i = msxLength - 1; i >= 0; i--) {
            if (flg == 0) {//个数相同
                int var2 = arr1[i] + arr2[i];
                if (flg1) {
                    var2 += 1;
                }
                if (var2 / 10 > 0) {
                    flg1 = true;
                } else {
                    flg1 = false;
                }
                if (msxLength == 1) {
                    if (var2 / 10 > 0) {
                        sb.append(var2 % 10);
                        sb.append(",");
                    } else {
                        sb.append(var2 % 10);
                        sb.append(",");
                    }
                    if (flg1 == true && i == 0) {
                        sb.append(1);
                    }

                } else {
                    sb.append(var2 % 10);
                    sb.append(",");
                    if (flg1 == true && i == 0) {
                        sb.append(1);
                    }
                }
            }
            if (flg == 1) {//arr2.length > arr1.length
                int var2 = var[i] + arr2[i];
                if (flg1) {
                    var2 += 1;
                }
                if (var2 / 10 > 0) {
                    flg1 = true;
                } else {
                    flg1 = false;
                }

                sb.append(var2 % 10);
                sb.append(",");
                if (flg1 == true && i == 0) {
                    sb.append(1);
                }
            }
            if (flg == 2) {//arr2.length < arr1.length
                int var2 = var[i] + arr1[i];
                if (flg1) {
                    var2 += 1;
                }
                if (var2 / 10 > 0) {
                    flg1 = true;
                } else {
                    flg1 = false;
                }
                sb.append(var2 % 10);
                sb.append(",");
                if (flg1 == true && i == 0) {
                    sb.append(1);
                }
            }
        }
        String substring = sb.toString().substring(0, sb.length());
        return substring;
    }
}