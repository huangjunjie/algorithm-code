package leetcode.longestConsecutiveSequence;


import java.util.*;

public class LongestConsecutiveSequenceSolution {

    public static void main(String[] args) {
        int[] nums = {0,-1};
        System.out.println(new LongestConsecutiveSequenceSolution().longestConsecutive(nums));
    }


    /**
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     * <p>
     * You must write an algorithm that runs in O(n) time.
     * <p>
     * solve think :
     * <p>
     * resolve question with hashMap;
     * <p>
     * k must resolve distance and start point (or start point and end point)
     * v
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int MAX_VALUE = 0xFFFFFFF;
        Map<Integer, Integer> numsMap = new TreeMap<Integer, Integer>();
        for (int i : nums) {
            numsMap.put(i, 0);
        }

        Set<Map.Entry<Integer, Integer>> entries = numsMap.entrySet();

        int maxCount = 0;
        int nowCount = 0;
        int nowValue = MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getKey();
            if (nowValue == MAX_VALUE) {
                maxCount = 1;
                nowCount = 1;
                nowValue = key;
                continue;
            }

            //tell right
            if (key.intValue() == nowValue + 1) {
                nowCount++;
                nowValue = key.intValue();
                if (nowCount > maxCount) {
                    maxCount = nowCount;
                }
            } else {
                nowCount = 1;
                nowValue = key.intValue();
            }
        }

        return maxCount;
    }
}
