package demo;

/***
 *  题目：求1+2!+3!+...+20!的和  
 */
public class demo {

    public static void main(String[] args) {
        int sum=0;
        for (int i = 1; i < 21; i++) {
            int jiecheng = jiecheng(i);
            sum+=jiecheng;
        }
        System.out.println(sum);
    }

    public static int jiecheng(int value){
        int sum=0;
        if(value==1){
            return 1;
        }
        sum=value*jiecheng(value-1);
        return sum;
    }

}
