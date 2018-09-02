package com.mbfw.entity.qr;

public class PageLimit {

    private int start;

    private int size;

    private String index;

    public PageLimit(int start, int size) {
        this.start = start;
        this.size = size;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
