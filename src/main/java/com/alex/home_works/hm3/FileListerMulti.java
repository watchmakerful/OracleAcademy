package com.alex.home_works.hm3;

import com.alex.home_works.hm2.my_linkedlist.ListItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 14.07.2016.
 */
public class FileListerMulti {
    static int threadCount = 0;
    static final Object COUNT_LOCK = new Object();
    static final Object ADD_LOCK = new Object();



    public static void main(String[] args) {

        List<String> list = new ArrayList<>();



        String initialPath = "m:/Downloads";




        Thread initialListThread = new ListerThread(new File(initialPath), list);
        initialListThread.start();
        try {
            initialListThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(threadCount>0) {

        }


        System.out.println("end");
        for (String filename : list) {
            System.out.println(filename);
        }


    }











}
