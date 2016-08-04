package com.alex.home_works.hm2.my_linkedlist;

/**
 * Created by Алексей on 12.06.2016.
 */
public class MyLinkedList {
    private int items;
    private ListItem startItem;
    private ListItem currentItem;

    public MyLinkedList() {
        startItem = new ListItem();
        startItem.setNext(startItem);
        startItem.setPrevious(startItem);
        items = 0;
    }

    private void addBefore (ListItem item, Object o) {
        currentItem = new ListItem(o, item, item.getPrevious());
        currentItem.getPrevious().setNext(currentItem);
        item.setPrevious(currentItem);
        items++;
    }

    public boolean add (Object o) {
        if (items == 0) {
            startItem.setContents(o);
            items = 1;
            return true;
        }
        addBefore(startItem,o);
        return true;
    }

    private ListItem getItem (int index) {
        ListItem tempItem = startItem;
        for (int i = 0; i<index; i++) {
            tempItem = tempItem.getNext();
        }
        return tempItem;
    }



    public Object get (int index) {
        return getItem(index).getContents();
    }

    public void replace (int index, Object o) {
        getItem(index).setContents(o);
    }

    public void insert (int index, Object o) {
        addBefore(getItem(index).getNext(),o);
    }

    private void removeItem (ListItem item) {
        if (items == 0) return;
        if (item == startItem) {
            startItem = item.getNext();
        }
        item.setContents(null);
        item.getPrevious().setNext(item.getNext());
        item.getNext().setPrevious(item.getPrevious());
        items--;
    }

    public void delete (int index) {
        removeItem(getItem(index));
    }

    public boolean remove (Object o) {
        ListItem tempItem = startItem;
        for (int i = 0; i<items; i++) {
            if (tempItem.getContents().equals(o)) {
                removeItem(tempItem);
                return true;
            }
            tempItem = tempItem.getNext();
        }
        return false;
    }

    public int size() {
        return items;
    }

    public boolean isEmpty() {
        return (items==0);
    }

    public boolean contains(Object o) {
        ListItem tempItem = startItem;
        for (int i = 0; i<items; i++) {
            if (tempItem.getContents().equals(o)) {
                return true;
            }
            tempItem = tempItem.getNext();
        }
        return false;
    }

    public void clear(){
        startItem.setNext(startItem);
        startItem.setPrevious(startItem);
        startItem.setContents(null);
        items = 0;
    }


    @Override
    public String toString() {
        ListItem tempItem = startItem;
        StringBuilder output = new StringBuilder("MyLinkedList: ");
        output.append(items).append(" items.").append("\n");
        for (int i = 0; i<items; i++) {
            output.append(i).append(": ")
                    .append(tempItem.getPrevious().getContents().toString())
                    .append("<-")
                    .append(tempItem.getContents().toString())
                    .append("->")
                    .append(tempItem.getNext().getContents().toString())
                    .append("\n");
            tempItem = tempItem.getNext();
        }

        return output.toString();
    }



}

