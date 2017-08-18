package com.mst;

/**
 * 实现一个静态方法,判断传入的字符串是不是合法的IP地址
 * Created by wanglu-jf on 17/8/18.
 */
public class IPUtils {

    public static boolean Isipv4(String ipv4){
        if(ipv4==null || ipv4.length()==0){
            return false;//字符串为空或者空串
        }
        //因为java doc里已经说明, split的参数是reg, 即正则表达式, 如果用"|"分割, 则需使用"\\|"
        String[] parts=ipv4.split("\\.");
        if(parts.length!=4){
            return false;//分割开的数组根本就不是4个数字  
        }
        for(int i=0;i<parts.length;i++){
            try{
                int n=Integer.parseInt(parts[i]);
                if(n<0 || n>255){
                    return false;//数字不在正确范围内  
                }
            }catch (NumberFormatException e) {
                return false;//转换数字不正确  
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("[实现一个静态方法,判断传入的字符串是不是合法的IP地址：]"+Isipv4("192.168.0.1"));
        System.out.println("[实现一个静态方法,判断传入的字符串是不是合法的IP地址：]"+Isipv4("0.0.0.0"));
        System.out.println("[实现一个静态方法,判断传入的字符串是不是合法的IP地址：]"+Isipv4("192.068.0.1"));
        System.out.println("[实现一个静态方法,判断传入的字符串是不是合法的IP地址：]"+Isipv4("092.168.1"));
        System.out.println("[实现一个静态方法,判断传入的字符串是不是合法的IP地址：]"+Isipv4(""));
    }
}
