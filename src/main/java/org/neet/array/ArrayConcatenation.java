package org.neet.array;

import java.util.Arrays;

public class ArrayConcatenation {

    public int[] concatenate(int[] nums) {
        int[] result = new int[nums.length * 2];

        for (int i=0; i < nums.length; i++) {
            result[i] = nums[i];
            result[i + nums.length] = nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};

        ArrayConcatenation a = new ArrayConcatenation();
        System.out.println(Arrays.toString(a.concatenate(nums)));
    }

}
