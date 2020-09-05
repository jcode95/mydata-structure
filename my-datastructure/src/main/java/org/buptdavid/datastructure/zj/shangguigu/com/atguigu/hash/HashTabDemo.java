package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.hash;

import java.util.Scanner;

/**
 * @author jiezhou
 * @CalssName: HashTabDemo
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.hash
 * @Description:
 * @date 2020/8/19/16:54
 */
public class HashTabDemo {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(700);
        String key = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("输入“add” 添加雇员");
        System.out.println("输入“list” 显示雇员");
        System.out.println("输入“find” 查找雇员");
        System.out.println("输入“delete” 删除雇员");
        System.out.println("输入“exit” 退出系统");
        while (true) {

            key = sc.nextLine();
            key=key.trim();
            switch (key){
                case "add":
                    System.out.println("请输入id");
                    int id = sc.nextInt();
                    System.out.println("请输入name");
                    String name = sc.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入id");
                    id = sc.nextInt();
                    hashTab.getEmpById(id);
                    break;
                case "delete":
                case "exit":
                    System.exit(0);
            }
        }
    }
}

