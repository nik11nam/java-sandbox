package org.sandbox.oops.misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MidElementLinkedList {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(Arrays.asList(2, 4, 6, 8, 1, 7));

        int mid = (list.size()-1) / 2;
        System.out.println(list.get(mid));
    }

}
