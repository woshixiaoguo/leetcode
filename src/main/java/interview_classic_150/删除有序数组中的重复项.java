package interview_classic_150;

import org.junit.Test;

/**
 * 26 删除有序数组中的重复项
 *
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持
 * 一致 。然后返回 nums 中唯一元素的个数。
 * 
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * 
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums
 * 的大小不重要。
 * 返回 k 。
 * 判题标准:
 * 
 * 系统会用下面的代码来测试你的题解:
 * 
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 * 
 * int k = removeDuplicates(nums); // 调用
 * 
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums
 * 示例 2：
 * 
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 * 
 * 
 * 提示：
 * 
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按 非严格递增 排列
 */

public class 删除有序数组中的重复项 {

    // 0ms 43.9MB
    public int removeDuplicates(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow]) {
                fast++;
            } else {
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return slow + 1;

    }

    // 1ms 43.87MB
    public int removeDuplicates2(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < (nums.length - 1)) { // fast++后涉及读操作，因此 -1
            while (fast < (nums.length - 1) && nums[fast] == nums[slow]) {
                fast++;
            }
            if (nums[fast] == nums[slow]) // 阻止后面的赋值
                break;
            System.out.println("fast: " + fast);
            slow++;
            nums[slow] = nums[fast];
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return slow + 1;
    }

    @Test
    public void test() {
        // int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int[] arr2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int ans = removeDuplicates2(arr2);
        System.out.println(ans);
    }

}
