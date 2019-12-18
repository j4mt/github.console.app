package com.j4mt.github.search.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repositories {

    private ArrayList<Repository> items;

    public ArrayList<Repository> getItems() {
        return items;
    }

    public void setItems(ArrayList<Repository> items) {
        this.items = items;
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {

        return items.stream()
                .map(Repository::toString)
                .collect(Collectors.joining("\n"));
    }
}
