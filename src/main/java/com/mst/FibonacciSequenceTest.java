package com.mst;

/**
 * 编写一个计算前100位斐波那契数的函数。根据定义，斐波那契序列的前两位数字是0和1，随后的每个数字是前两个数字的和。例如，前10位斐波那契数为：0，1，1，2，3，5，8，13，21，34。
 * Created by wanglu-jf on 17/8/29.
 */
public class FibonacciSequenceTest {

    public static long fibonacciSequence(long i){
        if(i< 0 ){
            return 0;
        }if(i == 0 || i == 1){
            return Long.valueOf(i);
        }else{
            return fibonacciSequence(i-1) + fibonacciSequence(i-2);
        }
    }

    // 获取和
    private static String getCount(int num) {
        String strNums = "";
        for (int i = 0; i <= num; i++) {
            strNums += fibonacciSequence(i) + ",";
        }
        strNums = strNums.substring(0, strNums.length()-1);
        return strNums;
    }

    public static void main(String[] args) {
        System.out.println(fibonacciSequence(0));
        System.out.println(fibonacciSequence(1));
        System.out.println(getCount(100));
    }
}
