package org.neet.array;

import java.util.Arrays;

/**
 * 1. Initial max = -1 (last element)
 * 2. Reverse iteration
 * 3. newMax = max(oldMax, arr[i])
 */
public class ReplaceElementsWithGreatestRightSide {

    // O(n)
    private int[] replaceElements(int[] nums) {
        int max = -1;
        for (int i=nums.length-1; i>=0; i--) {
            int temp = nums[i];
            nums[i] = max;
            max = Math.max(max, temp);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {17,18,5,4,6,1};

        ReplaceElementsWithGreatestRightSide rr = new ReplaceElementsWithGreatestRightSide();
        System.out.println(Arrays.toString(rr.replaceElements(nums)));
    }

}
