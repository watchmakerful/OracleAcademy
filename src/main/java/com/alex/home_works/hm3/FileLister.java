package com.alex.home_works.hm3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 06.07.2016.
 */
public class FileLister {

    static void listFiles(File directory, List<String> list) {
        File[] files = directory.listFiles();
        for (File currentFile : files) {
            if (currentFile.isDirectory()) {
                listFiles(currentFile, list);
            } else list.add(currentFile.toString());
        }
    }


    public static void main(String[] args) {
        String initialPath = "c:/Maven";


        List<String> list = new ArrayList<>();

        listFiles(new File(initialPath), list);
        for (String filename : list) {
            System.out.println(filename);
        }


    }
}
