package interview_classic_150;

import org.junit.Test;

/**
 * 45 跳跃游戏II
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * 
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * 
 * 
 * 提示:
 * 
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 */

public class 跳跃游戏II {
    int step = 0;

    // 21ms 13.27%
    public int jump(int[] nums) {
        int index = nums.length - 1; // 最后一位坐标
        if (index == 0)
            return 0;
        // System.out.println("index: " + index);
        int i;
        int keypoint = index - 1;
        for (i = keypoint; i >= 0; i--) {
            if (nums[i] + i >= index) {
                keypoint = i; // 找到能到达最后一位的最靠前的坐标
            }
        }
        step++;
        if (keypoint > 0) {
            int[] arr = new int[keypoint + 1];
            System.arraycopy(nums, 0, arr, 0, keypoint + 1);
            jump(arr);
        }
        return step;
    }

    // 贪心算法 时间O(n^2) 空间O(1) 12ms
    // 和上面的方法一样找到可以到达最后一位的最靠前的坐标
    // 但是正序寻找，上面是逆序寻找
    public int jump2(int[] nums) {
        int index = nums.length - 1;
        int step = 0;
        while (index > 0) {
            for (int i = 0; i < index; i++) {
                if (nums[i] + i >= index) {
                    index = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    // 正向查找可到达的最大位置 时间O(n) 空间O(1) 1ms
    // 在每个点的跳跃边界内，找到跳得最远的那个作为下一个边界
    public int jump3(int[] nums) {
        int index = nums.length - 1;
        int boundary = 0;
        int step = 0;
        int max = 0;
        for (int i = 0; i < index; i++) {
            max = Math.max(nums[i] + i, max);
            if (i == boundary) {
                boundary = max;
                step++;
            }
        }
        return step;
    }

    @Test
    public void test() {
        int[] nums = { 2, 3, 1, 1, 4 };
        int[] nums2 = { 2, 3, 0, 1, 4 };
        int[] nums3 = { 0 };
        int[] nums4 = { 1, 2, 3 };
        int ans = jump3(nums3);
        System.out.println(ans);

    }
}
