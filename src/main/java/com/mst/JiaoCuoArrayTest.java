package com.mst;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个交错合并列表元素的函数。例如：给定的两个列表为[a，B，C]和[1，2，3]，函数返回[a，1，B，2，C，3]。
 * Created by wanglu-jf on 17/8/29.
 */
public class JiaoCuoArrayTest {
    public static void main(String[] args) {
        String [] array1 = {"a","B","C"};
        int [] array2 = {1,2,3};
        System.out.println(zuheArray(array1,array2));
    }

    private static List zuheArray(String [] array1, int [] array2){
        if(array1.length == 0 || array2.length ==0){
            return null;
        }
        List<String> list = new ArrayList<String>();
        int m = 0,n=0;
        for(int i=0;i<array1.length + array2.length;i++){
            if(i%2 == 0){
                list.add(array1[m++]);
            }else{
                list.add(array2[n++] + "");
            }
        }
        return list;
    }
}
