package com.alex.home_works.hm1.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Алексей on 28.05.2016.
 */
public class Saver {
    public static void save(ArrayList items, String path) throws IOException {
        ArrayList outputStrings = new ArrayList<String>();
        for (Object item:items) {
            System.out.println(item);
            outputStrings.add(item.toString());

        }


        Files.write(Paths.get(path),outputStrings);
    }
}
