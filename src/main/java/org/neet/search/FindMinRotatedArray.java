package org.neet.search;

public class FindMinRotatedArray {

    private static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            if (nums[l] <= nums[r]) {
                return nums[l];
            }

            int mid = (l + r) / 2;
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,1,2};
        System.out.println(findMin(nums));
    }
}
