package com.alex.home_works.hm1.vowels;

import java.util.ArrayList;

/**
 * Created by root on 26.05.2016.
 */
public class Vowels {
    public static String[] splitByVowels(String input){
        if (input == null) {
            String[] outErr = new String[1];
            outErr[0] = "null";
            return outErr;
        }


        final String vowels = "AEIOUYaeiouy";
        int len = input.length();
        int outputIndex = -1;

        String[] outputStrings = new String[len];
        int start = 0;
        for (int i=0;i<len;i++){
            if (vowels.contains(input.substring(i,i+1))) {
                outputIndex++;
                outputStrings[outputIndex] = input.substring(start,i+1);
                start = i+1;
            }

        }
        if (start<len){
            outputStrings[outputIndex] =  outputStrings[outputIndex] + input.substring(start,len);

        }
        int outputLength = outputIndex+1;
        String[] outputStrings1 = new String[outputLength];
        for(int i=0;i<outputLength;i++) {
            outputStrings1[i] = outputStrings[i];
        }

        return outputStrings1;
    }


    public static void main(String[] args) {
        //final String vowels = "AEIOUYaeiouy";
        String input = "aaaazaa";
        String[] lines = splitByVowels(input);
        //System.out.println(lines.length);
        for (int j=0;j<lines.length;j++){
            System.out.println(lines[j]);
        }


    }
}
