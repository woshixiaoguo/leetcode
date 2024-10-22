package interview_classic_150;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/* 1 两数之和

给定一个整数数组 nums 和一个整数目标值
target，请你在该数组中找出 和为目标值 target  的那 两个
整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。



示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]


提示：

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案


进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗? */

// 哈希表
// 由于数组中可能存在相同的两个数字为答案，而使用哈希表保存时，无法同时保存两个值
// 因此直接在遍历时查表，当前数字由数组给出，另一数字由表给出
// 这种一边遍历，一边往表中差值的做法同时可以规避两个数字相同导致表丢失的情况

public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(target - nums[i])) {
                return new int[] { table.get(target - nums[i]), i };
            }
            table.put(nums[i], i);
        }
        return new int[0];
    }

    @Test
    public void test() {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;

        int[] res = twoSum(nums2, target2);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
