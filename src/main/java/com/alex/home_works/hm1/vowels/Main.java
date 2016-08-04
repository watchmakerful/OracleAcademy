package com.alex.home_works.hm1.vowels;

/**
 * Created by root on 26.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        final String vowels = "AEIOUYaeiouy";
        String input = "cabriolettttt";
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
        for (int j=0;j<=outputIndex;j++){
            System.out.println(outputStrings[j]);
        }
    }
}
