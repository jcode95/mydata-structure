package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.stack;

/**
 * @author jiezhou
 * @CalssName: ArrayStackTest
 * @Package org.buptdavid.datastructure.zj.shangguigu.com.atguigu.sparsearray.stack
 * @Description: 栈
 * @date 2020/8/12/11:13
 */
public class ArrayStackTest {
    public static void main(String[] args) {
       /* ArrayStack stack = new ArrayStack(10);
        stack.push("2");
        stack.push("3");
        stack.push("1");
        System.out.println("----------出栈之前----------");
        stack.list();
        System.out.println("----------出栈数据----------");
        String pop = stack.pop();//出栈
        System.out.println(pop);
        System.out.println("----------出栈之后----------");
        stack.list();*/

        //表达式值计算
        ArrayStackTest stack = new ArrayStackTest();
        String str = "93*99/2-4+5/2+11-7";
        double compute = stack.compute(str);
        System.out.println(str + "=" + compute);
    }

    /**
     * 计算表达式的值
     *
     * @param str 表达式字符串
     * @return
     */
    public double compute(String str) {
        /**
         *  1、首先定义两个栈，存放数的栈和存放运算符的栈
         */
        ArrayStack numStack = new ArrayStack(str.length());
        ArrayStack operatorStack = new ArrayStack(str.length());

        int index = 0;
        while (index < str.length()) {
            int tmp = 0;//处理多位数
            if (chackNum(str.charAt(index))) {
                while (true) {
                    if (index + tmp + 1 < str.length() && chackNum(str.charAt(index + tmp + 1))) {
                        tmp++;
                    } else {
                        break;
                    }
                }
                //如果是数字，入栈numStack
                numStack.push(str.substring(index, index + tmp + 1));
            } else {
                //是运算符,先判断当前操作的运算符的优先级是否大于栈里面（栈不为空，如果栈为空，直接入栈，就没有后续操作）的栈顶的运算符的优先级，小于就让
                //运算符栈出栈，与数字栈出两个栈进行运算，得到值再入数字栈，在把当前运算符入运算符栈。
                if (operatorStack.isEmpty()) {
                    operatorStack.push(str.charAt(index) + "");
                } else {
                    String currOP = str.charAt(index) + "";
                    String stackOP = operatorStack.pop();
                    operatorStack.push(currOP);
                    if (chackOP(stackOP, currOP)) {
                        //取出数字栈的两个数
                        double a = Double.parseDouble(numStack.pop());
                        double b = Double.parseDouble(numStack.pop());
                        double result = processOP(a, b, stackOP);//做运算(注意“/“ 运算，var1必须是第一个参数)
                        //将结果压入数字栈里面
                        numStack.push(result + "");
                    } else {
                        operatorStack.push(stackOP);
                    }
                }
            }
            index = index + tmp + 1;
        }
        //最后
        //取出数字栈的两个数
        double result = 0.0;
        while (!operatorStack.isEmpty()) {
            double var = Double.parseDouble(numStack.pop());
            double var1 = Double.parseDouble(numStack.pop());
            //取出运算符栈的运算符
            String OP = operatorStack.pop();
            result = processOP(var, var1, OP);//做运算(注意 “/”和“-”的顺序)
            //将结果压入数字栈里面
            numStack.push(result + "");
        }
        return result;
    }

    private double processOP(double var, double var1, String op) {
        double result = 0;
        switch (op) {
            case "+":
                result = var + var1;
                break;
            case "-":
                result = var1 - var;
                break;
            case "*":
                result = var * var1;
                break;
            case "/":
                result = var1 / var;
                break;
        }
        return result;
    }

    /**
     * 判断运算符的优先级
     *
     * @param stackOP
     * @param currOP
     * @return
     */
    private boolean chackOP(String stackOP, String currOP) {
        if (stackOP.equals("+") || stackOP.equals("-")) {
            if (currOP.equals("*") || currOP.equals("/")) {
                return false;
            }
        }
        return true;
    }

    /**
     * 校验是否为数字
     *
     * @param c
     * @return
     */
    private boolean chackNum(char c) {
        return c >= '0' && c <= '9';
    }

}

class ArrayStack {
    private int maxSize;
    private String[] arr;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new String[maxSize];
    }


    /**
     * 出栈
     * @return
     */
    public String pop() {
        //判断栈是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈为空，不能出栈！");
        }
        String value = arr[top];
        top--;
        return value;
    }

    /**
     * 入栈并返回栈顶的值
     * @param value
     * @return
     */
    public String push(String value) {
        //判断栈是否满
        if (isFull()) {
            throw new RuntimeException("栈为满，不能入栈！");
        }
        top++;
        arr[top] = value;
        return arr[top];
    }

    /**
     * 遍历栈
     */
    public void list() {
        //判断栈是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }


    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 判断栈是否满
     *
     * @return
     */
    private boolean isFull() {
        return top == maxSize - 1;
    }


}
