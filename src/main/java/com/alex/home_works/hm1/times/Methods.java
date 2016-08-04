package com.alex.home_works.hm1.times;

/**
 * Created by root on 26.05.2016.
 */
public class Methods {
    private static final String SUBSTRING="String";


    public static long stringsPlusTime(int operations){
        String myString="";
        long start,finish;
        start = System.currentTimeMillis();
        for (int i=0;i<operations;i++){
            myString = myString + SUBSTRING;
        }
        finish = System.currentTimeMillis();
        return finish - start;
    }
    public static long stringsConcatTime(int operations){
        String myString="";
        long start,finish;
        start = System.currentTimeMillis();
        for (int i=0;i<operations;i++){
            myString = myString.concat(SUBSTRING);
        }
        finish = System.currentTimeMillis();
        return finish - start;
    }
    public static long stringBufferAppendTime(int operations){
        StringBuffer myString = new StringBuffer("");
        long start,finish;
        start = System.currentTimeMillis();
        for (int i=0;i<operations;i++){
            myString.append(SUBSTRING);
        }
        finish = System.currentTimeMillis();
        return finish - start;
    }
    public static long stringBuilderAppendTime(int operations){
        StringBuilder myString = new StringBuilder("");
        long start,finish;
        start = System.currentTimeMillis();
        for (int i=0;i<operations;i++){
            myString.append(SUBSTRING);
        }
        finish = System.currentTimeMillis();
        return finish - start;
    }


}
