package org.sandbox.fp.utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {
        // Arraylist insert by index
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(1,3);
        l.add(4);

        for(int i:l){
            System.out.println(i);
        }

        //  hashcode verification
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println("s1 hashcode:" + s1.hashCode());
        System.out.println("s2 hashcode:" + s2.hashCode());
        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println(s1.equals(s2));
    }

}
