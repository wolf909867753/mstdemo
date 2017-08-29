package com.mst;

/**
 * 使用for循环、while循环和递归写出3个函数来计算给定数列的总和。
 * Created by wanglu-jf on 17/8/29.
 */
public class ForTest {
    private static int[] arr_Ints = { 2, 1, 4, 3, 6, 5, 8, 7, 10, 9 };

    public static void main(String[] args) {
        System.out.println("The Count is " + getNumByFor() + " .");
        System.out.println("The Count is " + getNumByWhile() + " .");
        System.out.println("The Count is " + getNumByEcursion(0) + " .");
    }

    /**
     * for 循环
     */
    private static int getNumByFor() {
        int count = 0;
        for (int i = 0; i < arr_Ints.length; i++) {
            count += arr_Ints[i];
        }
        return count;
    }

    /**
     * while 循环
     */
    private static int getNumByWhile() {
        int count = 0;
        int i = 0;
        while (i < arr_Ints.length) {
            count += arr_Ints[i];
            i++;
        }
        return count;
    }

    /**
     * 递归
     */
    private static int getNumByEcursion(int i) {
        if (arr_Ints.length == 0)
            return 0;
        else if (i < arr_Ints.length - 1)
            return arr_Ints[i] + getNumByEcursion(i + 1);
        else
            return arr_Ints[i];
    }
}
