package com.alex.home_works.hm2.my_arraylist;

/**
 * Created by root on 09.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("I");
        System.out.println(list);

        System.out.println((list.remove("B")));
        System.out.println(list);
        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list);
        System.out.println("B "+list.contains("B"));
        System.out.println("C "+list.contains("C"));
        System.out.println(list.remove());
        System.out.println(list);
        System.out.println(list.remove("R"));
        System.out.println(list);
        System.out.println(list.remove("A"));
        System.out.println(list);

        for (int i = 0; i<26; i++) {
            list.add(i);
            System.out.println(list);
        }
        System.out.println(list.get(15));
        System.out.println(list.get(-1));
        System.out.println(list.get(27));

        System.out.println(list.isEmpty());
        list.clear();
        System.out.println(list.isEmpty());



    }

}
