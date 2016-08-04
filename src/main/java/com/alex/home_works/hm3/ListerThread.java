package com.alex.home_works.hm3;

import java.io.File;
import java.util.List;

import static com.alex.home_works.hm3.FileListerMulti.COUNT_LOCK;
import static com.alex.home_works.hm3.FileListerMulti.threadCount;
import static com.alex.home_works.hm3.FileListerMulti.ADD_LOCK;

/**
 * Created by Алексей on 14.07.2016.
 */
class ListerThread extends Thread {


    private File directory;
    private List<String> list;

    public ListerThread(File dir, List<String> files) {
        directory = dir;
        list = files;
        synchronized (COUNT_LOCK) {
            threadCount++;
        }
    }


    @Override
    public void run() {

        //System.out.print(threadCount + " ");
        File[] files = directory.listFiles();
        for (File currentFile : files) {
            if (currentFile.isDirectory()) {

                Thread newListThread = new ListerThread(currentFile, list);
                newListThread.start();


            } else
                synchronized (ADD_LOCK) {
                    list.add(currentFile.toString());
                }
        }
        synchronized (COUNT_LOCK) {
            threadCount--;
        }
    }

}
