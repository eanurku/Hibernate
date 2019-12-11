package com.mappingsortedset;

import com.Certificate;

import java.util.Comparator;

public class MyClassForComparision implements Comparator<Certificate> {

    @Override
    public int compare(Certificate certificate1, Certificate certificate2) {
       final int before=-1;
       final int after=1;

        if(certificate2==null) return after;

        String name1 = certificate1.getCertificateName();
        String name2 = certificate2.getCertificateName();
        if(name1==null) return before;
        else if(name2==null) return after;
        else return name1.compareTo(name2) *-1;
    }
}
