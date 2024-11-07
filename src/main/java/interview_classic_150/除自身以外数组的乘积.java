package interview_classic_150;

import org.junit.Test;

/**
 * 238 除自身以外数组的乘积
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 * 
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * 
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * 
 * 
 * 提示：
 * 
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内
 * 
 * 
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 */

public class 除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] left = new int[l];
        int[] right = new int[l];
        left[0] = 1;
        right[l - 1] = 1;
        for (int i = 0; i < l - 1; i++) {
            left[i + 1] = nums[i] * left[i];
        }

        for (int i = l - 1; i > 0; i--) {
            right[i - 1] = nums[i] * right[i];
        }
        for (int i = 0; i < l; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }

    // 空间复杂度 O(1) 输出数组不算进空间复杂度
    public int[] productExceptSelf2(int[] nums) {
        int l = nums.length;
        int[] ans = new int[l];
        ans[0] = 1;

        for (int i = 0; i < l - 1; i++) {
            ans[i + 1] = nums[i] * ans[i];
        }

        int R = 1;
        for (int i = l - 1; i >= 0; i--) {
            ans[i] *= R;
            R *= nums[i];
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = { -1, 1, 0, -3, 3 };
        int[] nums2 = { 1, 2, 3, 4 };

        int[] ans = productExceptSelf2(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
