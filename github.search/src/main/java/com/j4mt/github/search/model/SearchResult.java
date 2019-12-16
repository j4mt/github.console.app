package com.j4mt.github.search.model;

public class SearchResult {

    private String name;

    private long stars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStars() {
        return stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return String.format("SearchResult : {name='%s', stars=%d}", name, stars);
    }
}
