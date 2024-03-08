package org.neet.array;

/**
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
 * and an integer n, return true if n new flowers can be planted in the flowerbed without violating
 * the no-adjacent-flowers rule and false otherwise
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 *
 * Input: flowerbed = [0,0,1], n = 1
 * Output: true
 *
 * Input: flowerbed = [1,0,0], n = 1
 * Output: true
 *
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 *
 * 1. If 0 in middle check previous and next elements in array whether 0
 * 2. For 0 as 1st (i=0) or last (i=size-1) element, check only next or previous
 * 3. After planting, update the index with 1
 */
public class PlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;

        int size = flowerbed.length;
        int count = 0;
        for (int i=0; i<size; i++) {

            if ((flowerbed[i] == 0) && (i == 0 || flowerbed[i-1] == 0) && (i == size-1 || flowerbed[i+1] == 0)) {
                count++;
                if (count == n)
                    return true;

                // After planting, update the index with 1
                flowerbed[i] = 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};

        PlaceFlowers pf= new PlaceFlowers();
        System.out.println(pf.canPlaceFlowers(flowerbed, 1));
        System.out.println(pf.canPlaceFlowers(flowerbed, 2));
    }

}
