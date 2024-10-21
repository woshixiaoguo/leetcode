package interview_classic_150;

import org.junit.Test;

/**
 * 11 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 返回容器可以储存的最大水量。
 * 
 * 说明：你不能倾斜容器。
 * 
 * <img width="50px" height="100px" src=
 * "https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg">
 * 
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * 
 * 输入：height = [1,1]
 * 输出：1
 * 
 * 
 * 提示：
 * 
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 * 
 */

public class 盛最多水的容器 {
    public static int maxArea(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            max = Math.max(area, max);
            if (height[l] <= height[r])
                l++;
            else
                r--;
        }

        return max;
    }

    @Test
    public void test() {
        int[] nums = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int res = maxArea(nums);
        System.out.println(res);
    }
}
