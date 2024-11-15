package interview_classic_150;

import org.junit.Test;

/**
 * 42 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * 
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * 
 * 
 * 提示：
 * 
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class 接雨水 {

    public int trap(int[] height) {
        int ans = 0;
        int l = height.length;
        int[] left = new int[l];
        left[0] = height[0];
        for (int i = 1; i < l; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        int[] right = new int[l];
        right[l - 1] = height[l - 1];
        ans += (Math.min(left[l - 1], right[l - 1]) - height[l - 1]);
        for (int i = l - 2; i > -1; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
            ans += (Math.min(left[i], right[i]) - height[i]);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int[] height2 = { 4, 2, 0, 3, 2, 5 };
        int ans = trap(height2);
        System.out.println(ans);

    }
}
