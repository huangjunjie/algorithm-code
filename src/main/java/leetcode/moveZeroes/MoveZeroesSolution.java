package jav.leetcode.moveZeroes;

import java.util.Arrays;
import java.util.LinkedList;

public class MoveZeroesSolution {

    public static void main(String[] args) {
        int[] input = {0, 1, 0, 3, 12};
        new MoveZeroesSolution().moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }

    /**
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * <p>
     * Note that you must do this in-place without making a copy of the array.
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
                result.add(nums[i]);
                continue;
            }
            result.add(result.size() - zeroNum, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result.get(i).intValue();
        }
    }

}
