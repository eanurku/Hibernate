package com.mappingsortedmap;


import java.util.Comparator;

public class MyClassForComparision implements Comparator<String> {

    @Override
    public int compare(String key1, String key2) {
       final int before=-1;
       final int after=1;

        if(key2==null) return after;

        Comparable name1 = key1;
        Comparable name2 = key2;
        if(name1==null) return before;
        else if(name2==null) return after;
        else return name1.compareTo(name2) *-1;
    }
}
