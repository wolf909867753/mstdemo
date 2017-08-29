package com.mst;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 编写一个能将给定非负整数列表中的数字排列成最大数字的函数。例如，给定[50，2，1,9]，最大数字为95021。
 * Created by wanglu-jf on 17/8/29.
 */
public class SortMaxNumbersTest {
//    private static Integer[] VALUES = { 50, 2, 1, 9};
    private static Integer[] VALUES = { 50, 2, 100, 99, 5, 7, 51,50 ,11};
    public static void main(String[] args) {
        Arrays.sort(VALUES, new Comparator<Object>() {
            public int compare(Object lhs, Object rhs) {
                String v1 = lhs.toString();
                String v2 = rhs.toString();
                return (v1 + v2).compareTo(v2 + v1) * -1;
            }
        });
        System.out.println(VALUES);
        StringBuffer result = new StringBuffer();
        for (Integer integer : VALUES) {
            result.append(integer.toString());
        }
        System.out.println(result.toString());
    }
}
