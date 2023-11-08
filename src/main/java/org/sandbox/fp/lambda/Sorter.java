package org.sandbox.fp.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorter {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        // Using lambda
        Comparator<String> comparator = ((o1, o2) -> o1.compareTo(o2));
        Collections.sort(names, comparator);

        Collections.sort(names, ((o1, o2) -> o1.compareTo(o2)));

        Collections.sort(names, Comparator.naturalOrder());

    }

}
