package com.mst.yzd;

public class YuanZhuoDelNum {

    public static void main(String[] args) {
        int method = method(100);
        System.out.println(method);
    }

    private static int method(int peopleNum){
        Boolean[] arrays = new Boolean[peopleNum];
        for (int i = 0;i<peopleNum;i++){
            arrays[i] = true;
        }


        int index = 0;
        int countNum = 0;
        while(peopleNum > 1){
            if(arrays[index]){
                countNum++;
                if(3 == countNum){
                    arrays[index] = false;
                    countNum = 0;
                    peopleNum--;
                }
            }
            index++;
            if(index == arrays.length){
                index = 0;
            }
        }
        int n = 0;
        for (int i=0;i<arrays.length;i++ ) {
            if(arrays[i]){
                n = i;
                break;
            }
        }

        return n;

    }
}
