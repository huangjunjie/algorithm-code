package leetcode.mergeIntervals;


import java.util.Arrays;
import java.util.TreeMap;

public class MergeIntervalsSolution {
    public static void main(String[] args) {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = new MergeIntervalsSolution().merge(input);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }

    /**
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     * Example 2:
     * <p>
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= intervals.length <= 10^4
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 10^4
     * <p>
     * explain :
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int len = 0;
        int[][] result = new int[intervals.length][2];
        TreeMap<Integer, Integer> leftIntervalMap = new TreeMap<Integer, Integer>();
        TreeMap<Integer, Integer> rightIntervalMap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < intervals.length; i++) {
            if (leftIntervalMap.containsKey(intervals[i][0])) {
                int rightValue = intervals[leftIntervalMap.get(intervals[i][0])][1];
                if (rightValue < intervals[i][1]) {
                    rightIntervalMap.remove(rightValue);
                    leftIntervalMap.put(intervals[i][0], i);
                } else {
                    continue;
                }
            } else {
                leftIntervalMap.put(intervals[i][0], i);
            }

            if (rightIntervalMap.containsKey(intervals[i][1])) {
                int leftValue = intervals[rightIntervalMap.get(intervals[i][1])][0];
                if (leftValue > intervals[i][0]) {
                    leftIntervalMap.remove(leftValue);
                    rightIntervalMap.put(intervals[i][1], i);
                } else {
                    leftIntervalMap.remove(intervals[i][0]);
                }
            } else {
                rightIntervalMap.put(intervals[i][1], i);
            }
        }
        //if (leftIntervalMap.size() == rightIntervalMap.size()) System.out.println("corrects !!!");
        int left = 0;
        int right = 0;
        int lValue = 0;
        int rValue = 0;
        while (true) {
            left = leftIntervalMap.firstKey();
            right = intervals[leftIntervalMap.get(left)][1];

            do {
                lValue = leftIntervalMap.firstKey();
                rValue = intervals[leftIntervalMap.get(lValue)][1];
                if (rValue > right) right = rValue;
                leftIntervalMap.remove(lValue);
                if (leftIntervalMap.isEmpty()) break;
            } while (right >= leftIntervalMap.firstKey());

            result[len][0] = left;
            result[len++][1] = right;
            if (leftIntervalMap.isEmpty()) break;
        }
        int[][] resultConst = new int[len][2];
        for (int i = 0; i < len; i++) {
            System.arraycopy(result[i], 0, resultConst[i], 0, 2);
        }
        return resultConst;
    }
}
