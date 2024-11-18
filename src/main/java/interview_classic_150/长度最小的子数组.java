package interview_classic_150;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

/**
 * 209 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * 
 * 
 * 提示：
 * 
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 
 * 
 * 进阶：
 * 
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 */

public class 长度最小的子数组 {

    // 超出时间限制
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int left = 0; left < nums.length; left++) {
            int sum = 0;
            for (int right = left; right < nums.length; right++) {
                sum += nums[right];
                if (sum >= target) {
                    min = Math.min(min, right - left + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    // 滑动窗口
    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    @Test
    public void test() {
        int target = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target2 = 213;
        int[] nums2 = { 12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12 };
        int target3 = 15;
        int[] nums3 = { 1, 2, 3, 4, 5 };
        int ans = minSubArrayLen(target3, nums3);
        System.out.println(ans);

    }
}
