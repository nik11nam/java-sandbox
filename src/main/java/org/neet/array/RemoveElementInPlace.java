package org.neet.array;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val
 *
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 *
 * 1. Use two pointers, i = start index and boundary = last index
 * 2. When num matches target, swap num[i] with num[boundary] and decrement boundary
 * 3. If not matching increment i
 *
 */
public class RemoveElementInPlace {

    public int removeElement(int[] nums, int target) {
        int i = 0, boundary = nums.length-1;

        while (i <= boundary) {
            if (nums[i] == target) {
                swap(nums, i, boundary);
                boundary--;
            } else {
                i++;
            }
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int target = 2;

        RemoveElementInPlace r = new RemoveElementInPlace();
        int count = r.removeElement(nums, target);

        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }

}
