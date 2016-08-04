package com.alex.home_works.hm2.my_arraylist;

import java.util.Arrays;

/**
 * Created by root on 09.06.2016.
 */
public class MyArrayList {
    private final int defaultSize = 16;
    private Object[] storage = new Object[defaultSize];
    private int lastEl = -1;
    private final double coefficient = 0.75;

    private void checkSize() {
        if (storage.length*coefficient < lastEl) {

            Object[] newStorage = new Object[storage.length*2];
            System.arraycopy(storage,0,newStorage,0,lastEl+1);
            storage = newStorage;
        }
    }

    public boolean add (Object o){
        lastEl++;
        checkSize();
        storage[lastEl] = o;
        return true;
    }

    public boolean remove ()
    {
        boolean empty = isEmpty();
        if (empty) return false;
        storage[lastEl] = null;
        if (lastEl >= 1) {
            lastEl--;

        }
        return !empty;

    }

    public boolean remove (Object o) {
        for (int i=0;i<=lastEl;i++) {
            if (storage[i]!=null) {
                if ((storage[i] == o) || (storage[i].equals(o))) {

                    System.arraycopy(storage,i+1,storage,i,lastEl-i);
                    storage[lastEl] = null;
                    lastEl--;
                    return true;
                }

            }
        }
        return false;
    }

    public int size() {
        return storage.length;
    }

    public boolean contains (Object o) {
        for (Object obj: storage) {
            if (obj!=null) {
                if (obj == o) return true;
                if (obj.equals(o)) return true;
            }
        }
        return false;
    }

    public boolean isEmpty()
    {
        return ((lastEl <= 0) && (storage[0] == null));
    }

    @Override
    public String toString() {
        return "MyArrayList: " +
                "lastEl=" + lastEl + ", size=" + size() +
                ", storage=" + Arrays.toString(storage);
    }


    public void clear() {
        storage = new Object[defaultSize];
        lastEl = -1;
    }

    public Object get (int index) {
        if ((index <= lastEl) && (index>=0) && !isEmpty()) return storage[index];
        return null;
    }
}
