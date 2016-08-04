package com.alex.home_works.hm2.my_linkedlist;

/**
 * Created by Алексей on 12.06.2016.
 */
public class ListItem {
    private Object contents;
    private ListItem next;
    private ListItem previous;

    public ListItem(Object contents, ListItem next, ListItem previous) {
        this.contents = contents;
        this.next = next;
        this.previous = previous;
    }

    public ListItem() {

    }

    public Object getContents() {
        return contents;
    }

    public void setContents(Object contents) {
        this.contents = contents;
    }

    public ListItem getNext() {
        return next;
    }

    public void setNext(ListItem next) {
        this.next = next;
    }

    public ListItem getPrevious() {
        return previous;
    }

    public void setPrevious(ListItem previous) {
        this.previous = previous;
    }
}
