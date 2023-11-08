package org.sandbox.dsa.algo.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicatesInArray {

    public static void main(String[] args) {
        String[] names = { "Java", "JavaScript", "Python", "C", "Ruby", "Java" };

        Set<String> duplicates = new HashSet<>();
        // Brute force - Time complexity O(n2)
        for (int i=0; i < names.length; i++) {
            for (int j=i+1; j < names.length; j++) {
                if (names[i] == names[j]) {
                    duplicates.add(names[i]);
                }
            }
        }

        String[] duplicatesArr = duplicates.toArray(new String[0]);
        System.out.println("Brute force: " + Arrays.toString(duplicatesArr));

        // Time complexity O(n)
        duplicates = new HashSet<>();
        Set<String> unique = new HashSet<>();
        for (int i=0; i < names.length; i++) {
            boolean isUnique = unique.add(names[i]);
            if (!isUnique) {
                duplicates.add(names[i]);
            }
        }

        duplicatesArr = duplicates.toArray(new String[0]);
        System.out.println("HashSet: " + Arrays.toString(duplicatesArr));

    }

}
