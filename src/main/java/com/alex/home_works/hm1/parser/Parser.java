package com.alex.home_works.hm1.parser;


import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.regex.*;



/**
 * Created by root on 26.05.2016.
 */
public class Parser {
    public static ArrayList<Item> parse(String path) throws IOException {
        String str = new String(Files.readAllBytes(Paths.get(path)));
        ArrayList<Item> items = new ArrayList<Item>();
        Pattern pattern = Pattern.compile("<td>(\\d+)</td><td>(.+)</td><td>(.+)</td>");
        Matcher matcher = pattern.matcher(str);

        int position;
        String boyName;
        String girlName;

        while (matcher.find()) {
            position = Integer.parseInt(matcher.group(1));
            boyName = matcher.group(2);
            girlName = matcher.group(3);
            items.add(new Item(position,boyName,girlName));
        }
        return items;
    }





    public static void main(String[] args) throws IOException {

        String fileName = "C:\\Users\\Алексей\\IdeaProjects\\OracleAcademy\\src\\main\\java\\com\\alex\\home_works\\hm1\\parser\\baby2008.html";

        ArrayList<Item> items = parse(fileName);

        String fileNameOut = "C:\\Users\\Алексей\\IdeaProjects\\OracleAcademy\\src\\main\\java\\com\\alex\\home_works\\hm1\\parser\\baby2008.csv";

        Saver.save(items,fileNameOut);

    }


}
