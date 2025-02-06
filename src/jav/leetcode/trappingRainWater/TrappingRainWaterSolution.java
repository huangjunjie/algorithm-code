package jav.leetcode.trappingRainWater;

public class TrappingRainWaterSolution {

    public static void main(String[] args) {
        int[] input = {0};
        System.out.println(new TrappingRainWaterSolution().trap(input));
    }

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
     * Example 2:
     * <p>
     * Input: height = [4,2,0,3,2,5]
     * Output: 9
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
     * <p>
     * 1
     * 1         1
     * 1     1   1
     * 1 1   1 1 1
     * 1 1   1 1 1
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if(height.length == 1 || height.length == 2) return 0;
        int area = 0;
        int up = 0;
        int down = height.length - 1;
        while (up < down && height[up] <= height[up + 1]) up++;
        while (up < down && height[down] <= height[down - 1]) down--;
        if (up == down) return 0;
        int index = height[up] < height[down] ? up : down;
        int rank = height[up] < height[down] ? 1 : -1;
        while (true) {
            index += rank;
            if ((rank == -1 && index < up) || (rank == 1 && index > down)) break;
            if (rank == 1) {
                if (height[index] <= height[up]) {
                    area += height[up] - height[index];
                }
                if (height[index] > height[up]) {
                    up = index;
                    index = height[index] < height[down] ? index : down;
                    rank = height[index] < height[down] ? 1 : -1;
                }
            } else {
                if (height[index] <= height[down]) {
                    area += height[down] - height[index];
                }
                if (height[index] > height[down]) {
                    down = index;
                    index = height[index] < height[up] ? index : up;
                    rank = height[index] < height[up] ? -1 : 1;
                }
            }
        }
        return area;
    }
}
