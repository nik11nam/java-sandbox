package org.neet.array;

public class ContainerWithMostWater {

    // O(n2) - quadratic time
    private static int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        for (int i=0; i < height.length; i++) {
            for (int j=i+1; j < height.length; j++) {
                int area = (j-i) * Math.min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    // O(n) - linear time - two pointers
    private static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length-1;

        while(left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxAreaBruteForce(height));
        System.out.println(maxArea(height));
    }

}
