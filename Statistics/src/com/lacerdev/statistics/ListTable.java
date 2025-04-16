package com.lacerdev.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ListTable {
    private final HashMap<String, List<Double>> listsTable = new HashMap();
    private final Set<String> listsNames = listsTable.keySet();

    public boolean hasList(String name) {
        return listsTable.containsKey(name);
    }

    public boolean createList(String name) {
        // check if list already exists
        // if yes, return false
        // if no, add new to table and return true
        if (!this.hasList(name)) {
            listsTable.put(name, new ArrayList<Double>());
            return true;
        }

        return false;
    }

    public List<Double> getList(String name) {
        // check if list exists
        // if yes, return list
        // if no, return null
        return listsTable.get(name);
    }

    public boolean deleteList(String name) {
        // check if list exists
        // if yes, delete list and return true
        // if no, return false
        if (this.hasList(name)) {
            listsTable.remove(name);
            return true;
        }

        return false;
    }

    public boolean deleteAllLists() {
        listsTable.clear();
        return true;
    }
}