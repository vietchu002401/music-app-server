package com.mymusic.app.model;

public class TopLoved {
    private String id;
    private int count;


    public TopLoved() {
    }

    public TopLoved(String id, int count) {
        this.id = id;
        this.count = count;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TopLoved id(String id) {
        setId(id);
        return this;
    }

    public TopLoved count(int count) {
        setCount(count);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", count='" + getCount() + "'" +
            "}";
    }

}
