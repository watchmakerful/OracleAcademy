package com.alex.home_works.hm1.parser;

/**
 * Created by Алексей on 27.05.2016.
 */
public class Item {
    private int position;
    private String boyName;
    private String girlName;

    public Item(int position, String boyName, String girlName) {
        setPosition(position);
        setBoyName(boyName);
        setGirlName(girlName);
    }

    public String getBoyName() {
        return boyName;
    }

    public void setBoyName(String boyName) {
        this.boyName = boyName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getGirlName() {
        return girlName;
    }

    public void setGirlName(String girlName) {
        this.girlName = girlName;
    }

    @Override
    public String toString() {
        return Integer.toString(this.position)+"|"+this.boyName+"|"+this.girlName;
    }
}
