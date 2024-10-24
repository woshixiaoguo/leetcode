package sowrd_offer;

import org.junit.Test;

public class 和为s的两个数字 {
    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[2,7] 或者 [7,2]
     * 示例 2：
     *
     * 输入：nums = [10,26,30,31,47,60], target = 40
     * 输出：[10,30] 或者 [30,10]
     *  
     *
     * 限制：
     *
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^6
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int[] result = new int[2];
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    result[0] = nums[left];
                    result[1] = nums[right];
                    break;
                }
                if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return result;
        }
    }

    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            int i = 0, j = nums.length - 1;
            while (i < j) {
                int s = nums[i] + nums[j];
                if (s < target)
                    i++;
                else if (s > target)
                    j--;
                else
                    return new int[] { nums[i], nums[j] };
            }
            return new int[0];
        }
    }

    @Test
    public void test() {
        int[] test = { 10, 26, 30, 31, 47, 60 };
        int target = 40;
        int[] result = new Solution().twoSum(test, target);
        for (int ans : result) {
            System.out.println(ans);
        }
    }

}
