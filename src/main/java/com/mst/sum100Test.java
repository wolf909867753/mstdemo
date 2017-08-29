package com.mst;

import java.util.ArrayList;

/**
 * 编写一个在1，2，…，9（顺序不能变）数字之间插入+或-或什么都不插入，使得计算结果总是100的程序，并输出所有的可能性。例如：1 + 2 + 34 – 5 + 67 – 8 + 9 = 100。
 * Created by wanglu-jf on 17/8/29.
 */
public class sum100Test {
    private static int TARGET_SUM = 100;
    private static int[] VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    private static ArrayList add(int digit, String sign, ArrayList branches) {
        for (int i = 0; i < branches.size(); i++) {
            branches.set(i, digit + sign + branches.get(i));
        }

        return branches;
    }

    private static ArrayList f(int sum, int number, int index) {
        int digit = Math.abs(number % 10);
        if (index >= VALUES.length) {
            if (sum == number) {
                ArrayList result = new ArrayList();
                result.add(Integer.toString(digit));
                return result;
            } else {
                return new ArrayList();
            }
        }

        ArrayList branch1 = f(sum - number, VALUES[index], index + 1);
        ArrayList branch2 = f(sum - number, -VALUES[index], index + 1);

        int concatenatedNumber = number >= 0 ? 10 * number + VALUES[index] : 10 * number - VALUES[index];
        ArrayList branch3 = f(sum, concatenatedNumber, index + 1);
        ArrayList results = new ArrayList();

        results.addAll(add(digit, "+", branch1));
        results.addAll(add(digit, "-", branch2));
        results.addAll(add(digit, "", branch3));

        return results;
    }

    public static void main(String[] args) {
        ArrayList list = f(TARGET_SUM, VALUES[0], 1);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
