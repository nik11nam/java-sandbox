package org.assessment.tel;

import java.util.Arrays;
import java.util.List;

// Aladdin and his carpet
public class AladdinFlyingCarpet {

    public static int optimalPoint(List<Integer> magic, List<Integer> dist) {
        // Write your code here
        int pos = -1, curr = 0, total = 0;
        for (int i = 0; i < magic.size(); i++) {
            int diff = magic.get(i) - dist.get(i);
            curr += diff;
            total += diff;
            if (curr < 0) {
                curr = 0;
                pos = i;
            }
        }
        if (total >= 0)
            return pos + 1;
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> magic = Arrays.asList(2,4,5,2);
        List<Integer> dist = Arrays.asList(4,3,1,3);
        System.out.println(optimalPoint(magic, dist));
    }


}
