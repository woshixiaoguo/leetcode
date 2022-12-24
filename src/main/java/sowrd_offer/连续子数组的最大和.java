package sowrd_offer;

import org.junit.Test;

public class 连续子数组的最大和 {
    /**
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     *
     * 要求时间复杂度为O(n)。
     *
     *  
     *
     * 示例1:
     *
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *  
     *
     * 提示：
     *
     * 1 <= arr.length <= 10^5
     * -100 <= arr[i] <= 100
     *
     *
     */



    class Solution {
        /**
         * 动态规划解法
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int maxSum = nums[0];
            int maxI = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > nums[i] + maxI) maxI = nums[i];
                else maxI += nums[i];
                if(maxI > maxSum) maxSum = maxI;
            }
            return maxSum;
        }
    }

    @Test
    public void test(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = new Solution().maxSubArray(nums);
        System.out.println(result);
    }
}
