package com.twu;

public class HotSearch {
    private String text;
    private int heatCount = 0;
    HotSearch(String text) {
        this.text = text;
    }

    public void setCount(int count) {
        this.heatCount = count;
    }

    public int getCount() {
        return heatCount;
    }
    public String toString() {
        return this.text+" "+this.heatCount;
    }
}
