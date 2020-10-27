/*
import java.util.*;
public class Main{
    static StringBuilder str=new StringBuilder();
//    public static void main(String[] ar){
        *//*

*/
/*Scanner sc=new Scanner(System.in);
        String inString= sc.next();
        String string = resString(inString);
        System.out.printf("%-8s", string);
        sc.close();*//*
*/
/*


        *//*

*/
/*Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            StringBuffer sb=new StringBuffer(s);
            System.out.println(sb.reverse().toString());

        }*//*
*/
/*



        *//*

*/
/*double avg=0.0;
        double sum=0;
        int count=0;
        int count1=0;
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int a=sc.nextInt();
            if(a<0){
                count++;
            }
            if(a>=0){
                sum+=a;
                count1++;
            }

            avg=sum/count1;
            System.out.println(count);
            System.out.println(avg);
        }*//*
*/
/*


//    }
    public static String resString(String inString){
        if(inString.length()>100){
            return null;
        }

        for (int i =  inString.length()-1; i >=0; i--) {
            str.append(inString.charAt(i));
        }

        return str.toString();

    }


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){

            String a=sc.nextLine();
            for (int i = 0; i < Integer.parseInt(a); i++) {
                String str = sc.nextLine();
                String string = ressString(str);
                System.out.println(string);
            }

        }
    }

    public static String ressString(String in){
        if(in.length()<8){
            StringBuilder sb=new StringBuilder(in);
            for(int i=0;i<8-in.length();i++){
                sb.append("0");
            }
            return sb.toString()+"\r\n";
        }else if(in.length()>8){
            String temp=in.substring(8,in.length());

            String temp1 = in.substring(0,8);
            String string = ressString(temp);
            return temp1+"\r\n"+string;
        }else{
            return in+"\r\n";
        }
    }

}*//*



import java.util.*;
import java.lang.*;
public class Main{
    public static void main(String[] agrs){

        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String iniString=sc.nextLine();
            int[] mat =new int[128];
            tongji(iniString,mat);

        }




    }
    public static  void tongji(String in,int[] mat){
        for(int i=0;i<in.length();i++){
            if(in.charAt(i)>='a'&&in.charAt(i)<='z'||in.charAt(i)>='A'&&in.charAt(i)<='Z'||in.charAt(i)>='0'&&in.charAt(i)<='9'||in.charAt(i)==' '){
                //存储字符的ASCII码
                int tmp=in.charAt(i);
                mat[tmp]++;
            }

        }

        //找出最大数
        int max=0;
        for(int j=0;j<mat.length;j++){
            if(max<mat[j]){
                max=mat[j];
            }
        }

        //输出
        String result="";
        for(int i=max;i>0;i--){
            for(int j=0;j<128;j++){
                if(mat[j]==i){
                    result+=(char)j;
                }
            }

        }

        System.out.println(result);

    }



}*/


/*import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();
            int flag = scanner.nextInt();
            Arrays.sort(arr);//升序
            if (flag == 0){
                for (int i = 0; i < arr.length - 1; i++)
                    System.out.print(arr[i] + " ");
                System.out.println(arr[arr.length - 1]);
            }else {
                for (int i = arr.length - 1; i >= 1; i--)
                    System.out.print(arr[i] + " ");
                System.out.println(arr[0]);
            }

            new DecimalFormat().format("0.0",102.4);

        }
    }*/
/*
import java.util.*;
public class Main{
    public static void main(String[] agr){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            StringBuilder sb=new StringBuilder(str);
            for(int i=0;i<sb.length();i++) {


                if(chack(sb.charAt(i))){
                    if(i==0){
                        sb.insert(i,"*");
                    }
                    if(i-1>=0&&!chackX(sb.charAt(i-1))&&!chack(sb.charAt(i-1))){//校验前面
                        sb.insert(i,"*");
                    }
                    //校验后面
                    if(i+1<=sb.length()-1&&!chack(sb.charAt(i+1))&&!chackX(sb.charAt(i+1))){
                        sb.insert(i+1,"*");
                    }
                    if(i==sb.length()-1&&chack(sb.charAt(i))){
                        sb.insert(i+1,"*");
                        break;
                    }
                }
            }
            System.out.println(sb.toString());
        }


    }

    public static boolean chack(char c){
        if(c>='0'&&c<='9'){
            return true;
        }
        return false;
    }
    public static boolean chackX(char c){
        if(c=='*'){
            return true;
        }
        return false;
    }
}
*/
/*
import java.util.*;
public class Main{
    public static void main(String[] agr){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            char[] c=str.toCharArray();
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<c.length;i++){
                if(chack(c[i])){
                    sb.append("*"+c[i]+"*");
                }else{
                    sb.append(c[i]);
                }

            }
            String string = sb.toString();
            String replace = string.replace("**", "");

            System.out.println(replace);
        }
    }

    public static boolean chack(char c){
        if(c>='0'&&c<='9'){
            return true;
        }
        return false;
    }

}*/

/*
import java.util.*;
import java.lang.*;
public class Main{
    public static void main(String[] agr){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String ip=sc.nextLine();
            boolean b=chackIp(ip);
            if(b){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    public static boolean chackIp(String ip){
        boolean contains = ip.contains(" ");
        boolean b = ip.contains("\\.");
        if(ip.contains(" ")||ip.contains("\\.")){
            return false;
        }
        String[] ipArr=ip.split("\\.");
        if(ipArr.length!=4){
            return false;
        }
        for(int i=0;i<ipArr.length;i++){
            if(ipArr[i].length()>8){
                return false;
            }
            String tmp=ipArr[i];
            try{
                long l = Long.parseLong(tmp);
                if(l<0||l>255){
                    return false;
                }

            }catch(Exception e){
                return false;
            }

        }
        return true;
    }
}*/

/*import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            //可以被5整除的数的和
//            int fiveSum=0;
//            //可以被3整除的数的和（不包括被5整除的数）
//            int threeSum=0;
//            List<Integer> list=new ArrayList<Integer>();//其他不能被5或者3整除的数都放在这个list里面
//            int num=scanner.nextInt();
//            for(int i=0;i<num;i++){
//                int v=scanner.nextInt();
//                if(v%5==0){//v被5整除
//                    fiveSum+=v;
//                }else if(v%3==0){
//                    threeSum+=v;
//                }else{
//                    list.add(v);
//                }
//            }
//            System.out.println(divide(fiveSum, threeSum, list));
//
//        }
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(7);
        integers.add(5);integers.add(5);
        integers.add(-6);
        integers.add(-9);integers.add(7);
        integers.add(2);


        boolean b = canFind(integers, 5);
        System.out.println(b);


    }
    private static boolean divide(int fiveSum, int threeSum, List<Integer> list) {

        int otherSum=0;
        for(int i:list){
            otherSum+=i;
        }
        // 和为偶数才可能划分
        if ((fiveSum + threeSum + otherSum) % 2 == 0) {
            // 两个数之间的差
            int diff = Math.abs(fiveSum - threeSum);
            // 差与余下数的和相等，则可以划分
            if (diff == otherSum) {
                return true;
            }else if (diff > otherSum) { // 差比余下数的和大，则不可以划分
                return false;
            } else {
                int sum = (fiveSum - threeSum + otherSum) / 2;
                return canFind(list, sum);
            }
        }
        return false;

    }
    *//**
 * 在list中能否找到一组数据使用得其和是sum
 *
 * @param list 整数集合
 * @param sum  和
 * @return true：可以找到，false：不可以找到
 *//*
    private static boolean canFind(List<Integer> list, int sum) {
        int count=0;
        for(int i=0;i<list.size()-1;i++){
            int tmpSum= list.get(i);
            for(int j=i+1;j<list.size();j++){
                count++;
                System.out.println("i:"+i+",j:"+j+",count:"+count);

                tmpSum+=list.get(j);
                if(sum==tmpSum){
                    return true;
                }
            }

        }
        System.out.println(count);
        return false;
    }

}*/

/*
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String var = sc.nextLine();//被加数
            String var2 = sc.nextLine();//加数
            if (var.length() < var2.length()) {
                String tmp = var;
                var = var2;
                var2 = tmp;
            }
            StringBuilder sbb = new StringBuilder(var2);
            for (int i = 0; i < var.length() - var2.length(); i++) {

                sbb.insert(0, "0");

            }
            var2 = sbb.toString();
            int[] ints = new int[var.length() + 1];
            boolean flg = false;
            for (int i = var.length() - 1; i >= 0; i--) {
                char c = var.charAt(i);//取到最后一个数字
                for (int i1 = i; i1 >= 0; i1--) {
                    char c1 = var2.charAt(i1);
                    int varc = Integer.parseInt(c + "");
                    int varc1 = Integer.parseInt(c1 + "");
                    if (flg) {
                        varc = varc + 1;
                    }
                    int var3 = varc + varc1;
                    if (var3 >= 10) {
                        int var4 = var3 % 10;//得到余数
                        ints[i + 1] = var4;
                        //判断是否为最后一个第一个索引
                        if (i == 0) {
                            int var5 = var3 / 10;//得到商
                            ints[i] = var5;
                        }
                        flg = true;
                    } else {
                        ints[i + 1] = var3;
                        flg = false;
                    }
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ints.length; i++) {
                sb.append(ints[i]);
            }
            String var6 = sb.toString();
            if(var6.charAt(0)=='0'){
                var6 = var6.substring(1);
            }
            System.out.println(var6);
        }
    }
}*/

/*import scala.Int;

*//*import java.util.*;

//栈结构
public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        while (sc.hasNext()) {
            int n=sc.nextInt();
            int[] var =new int[n];
            for (int i = 0; i < n; i++) {
                stack.push(sc.nextInt());
                Integer peek = stack.peek();
                sb.append(peek +" ");

            }

            for (int i = 0; i < n; i++) {
                //每一个进栈就出
                int var2 = var[i];
                sb.append(var2+" ");
            }




            for (Integer l : ls) {
                sb.append(l+" ");
            }
            sb.substring(0,sb.length()-1);

        }
    }
}*//*
import java.util.*;
public class Main{
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(sear(a,b));//求最小公倍数
        }
    }
    public static int sear(int a,int b){
        return max_com_div(a,b);
    }
    public static int max_com_div(int x,int y){
        if(x<y){
            int temp;
            temp=x;
            x=y;
            y=temp;
        }
        int count=1;
        while (true){
            int var = x * count;
            if(var%y==0){
                return var;
            }else{
                count++;
            }


        }

    }
}*/







/*
import java.util.*;
public class Main{
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(sear(a,b));//求最小公倍数
        }
    }
    public static int sear(int a,int b){
        return (a*b)/max_com_div(a,b);
    }
    //求最大公约数

    //两数相乘=最大公约数*最小公倍数
    public static int max_com_div(int x,int y){
        if(x<y){
            int temp;
            temp=x;
            x=y;
            y=temp;
        }
        int z=0;
        while(y!=0){
            z=x%y;
            x=y;
            y=z;
        }
        return x;
    }
}*/

import java.util.*;
public class Main {
    public static void main(String[] arg) {
        Long time=10L;
        long currentTime=6L;
        System.out.println(String.valueOf(time - currentTime + "-1"));


    }
}
