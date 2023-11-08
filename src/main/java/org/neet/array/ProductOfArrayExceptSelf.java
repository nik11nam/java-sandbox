package org.neet.array;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product
 * of all the elements of nums except nums[i]
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */
public class ProductOfArrayExceptSelf {

    private static int[] productOfArrayExceptSelf(int[] nums) {
        int total = 1;
        for (int num : nums) {
            total = total * num;
        }

        int[] result = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            result[i] = total / nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums)));
    }
}
