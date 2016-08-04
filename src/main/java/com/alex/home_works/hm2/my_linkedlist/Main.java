package com.alex.home_works.hm2.my_linkedlist;

/**
 * Created by Алексей on 12.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(2));
        System.out.println(list.get(4));
        System.out.println(list.get(6));
        list.delete(0);
        System.out.println(list);
        list.delete(0);
        list.delete(0);
        list.delete(0);
        list.delete(0);
        System.out.println(list);
        list.delete(0);
        System.out.println(list);
        list.delete(0);
        System.out.println(list);
        list.add("Z");
        System.out.println(list);
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        System.out.println(list);
        System.out.println(list.remove("A"));
        System.out.println(list);
        System.out.println(list.remove("F"));
        System.out.println(list);
        System.out.println(list.contains("E"));
        System.out.println(list.contains("F"));
        list.clear();
        System.out.println(list);
    }
}
