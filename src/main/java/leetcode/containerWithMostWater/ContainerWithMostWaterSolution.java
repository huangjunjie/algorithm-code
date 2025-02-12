package leetcode.containerWithMostWater;

public class ContainerWithMostWaterSolution {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWaterSolution().maxArea(height));
    }


    /**
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     * <p>
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * <p>
     * Return the maximum amount of water a container can store.
     * <p>
     * Notice that you may not slant the container.
     * <p>
     * dp(x,y)  =  max((y - x) * min(height[x],height[y]))
     * <p>
     * 比较面积级别
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int result = -1;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (height[i] * height.length < result) break;
                int area = (j - i) * Math.min(height[i], height[j]);
                if (result < area) result = area;
            }
        }
        return result;
    }

    /**
     *     public int maxArea(int[] height) {
     *         int length = height.length;
     *         int res = 0;
     *
     *         int left = 0,right = length-1;
     *         while(left<right){
     *             res = Math.max(res,Math.min(height[left],height[right])*(right-left));
     *             if(height[left]<height[right]){
     *                 left++;
     *             }
     *             else{
     *                 right--;
     *             }
     *         }
     *         return res;
     *
     *     }
     *
     *     think ： set bigger standard num  = ( left - right ) * min( height[left] - height [right] )
     *
     */
}
