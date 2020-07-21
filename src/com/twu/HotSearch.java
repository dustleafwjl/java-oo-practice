package com.twu;

public class HotSearch {
    private String text;
    private int heatCount = 0;
    private boolean isSuper = false;
    private int sellPrice;
    private int ranking;
    HotSearch(String text) {
        this.text = text;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getRanking() {
        return ranking;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setCount(int count) {
        this.heatCount = count;
    }
    public int getCount() {
        return heatCount;
    }
    public String getText() {
        return text;
    }
    public String toString() {
        return this.text+" "+this.heatCount;
    }
    public void setSuper(boolean aSuper) {
        isSuper = aSuper;
    }
    public boolean getIsSuper() {
        return isSuper;
    }
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof HotSearch) {
            HotSearch inItem = (HotSearch) o;
            return text.toUpperCase().equals(inItem.getText().toUpperCase());
        }
        return false;
    }
}
