package com.alex.home_works.hm2.list_tests;

/**
 * Created by root on 09.06.2016.
 */




public class ListsTest {
    public static void main(String[] args) {
        final int[] operationNumbers = {1000,10000,100000,1000000};
        Methods.arrayListAddTime(1000000);
        System.out.println("n: ArrayList, LinkedList");
        for (int i:operationNumbers) {
            System.out.print(i+": ");
            System.out.print(Methods.arrayListAddTime(i)+", ");
            System.out.print(Methods.linkedListAddTime(i)+", ");
            System.out.print(Methods.arrayListInsertTime(i)+", ");
            System.out.println(Methods.linkedListInsertTime(i));
        }
    }
}
