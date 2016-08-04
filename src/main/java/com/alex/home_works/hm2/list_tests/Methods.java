package com.alex.home_works.hm2.list_tests;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by root on 09.06.2016.
 */
public class Methods {
    private static final String FIELD="String";


    public static long arrayListAddTime(int operations) {
        ArrayList myList = new ArrayList();
        long start, finish;
        start = System.currentTimeMillis();
        for (int i = 0; i < operations; i++) {
            myList.add(FIELD);
        }
        finish = System.currentTimeMillis();
        return finish - start;
    }

    public static long linkedListAddTime(int operations) {
        LinkedList myList = new LinkedList();
        long start, finish;
        start = System.currentTimeMillis();
        for (int i = 0; i < operations; i++) {
            myList.add(FIELD);
        }
        finish = System.currentTimeMillis();
        return finish - start;
    }

    public static long linkedListInsertTime(int operations) {
        LinkedList myList = new LinkedList();
        long start, finish;
        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            myList.add(FIELD);
        }
        for (int i = 0; i < operations-10; i++) {
            myList.add(8,FIELD);
        }
        finish = System.currentTimeMillis();
        return finish - start;
    }

    public static long arrayListInsertTime(int operations) {
        ArrayList myList = new ArrayList();
        long start, finish;
        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            myList.add(FIELD);
        }
        for (int i = 0; i < operations-10; i++) {
            myList.add(8,FIELD);
        }
        finish = System.currentTimeMillis();
        return finish - start;
    }

}
