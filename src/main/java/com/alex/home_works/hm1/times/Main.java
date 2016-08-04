package com.alex.home_works.hm1.times;


/**
 * Created by root on 26.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        final int[] operationNumbers = {10,100,1000,10000,100000};
        Methods.stringsPlusTime(10000);
        System.out.println("n: +, concat, buffer, builder");
        for (int i:operationNumbers) {
            System.out.print(i+": ");
            System.out.print(Methods.stringsPlusTime(i)+", ");
            System.out.print(Methods.stringsConcatTime(i)+", ");
            System.out.print(Methods.stringBufferAppendTime(i)+", ");
            System.out.println(Methods.stringBuilderAppendTime(i));
        }
        int i = 10000000;
        System.out.print(Methods.stringBufferAppendTime(i)+", ");
        System.out.println(Methods.stringBuilderAppendTime(i));
    }
}
