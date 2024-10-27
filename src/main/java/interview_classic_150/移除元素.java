package interview_classic_150;

import org.junit.Test;

/**
 * 27 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val
 * 不同的元素的数量。
 * 
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 * 用户评测：
 * 
 * 评测机将使用以下代码测试您的解决方案：
 * 
 * int[] nums = [...]; // 输入数组
 * int val = ...; // 要移除的值
 * int[] expectedNums = [...]; // 长度正确的预期答案。
 * // 它以不等于 val 的值排序。
 * 
 * int k = removeElement(nums, val); // 调用你的实现
 * 
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // 排序 nums 的前 k 个元素
 * for (int i = 0; i < actualLength; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * 如果所有的断言都通过，你的解决方案将会 通过。
 * 
 * 
 * 
 * 示例
 * 
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2,_,_]
 * 解释：你的函数函数应该返回 k = 2, 并且 nums 中的前两个元素均为 2。
 * 你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
 * 示例 2：
 * 
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3,_,_,_]
 * 解释：你的函数应该返回 k = 5，并且 nums 中的前五个元素为 0,0,1,3,4。
 * 注意这五个元素可以任意顺序返回。
 * 你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
 * 
 * 
 * 提示：
 * 
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */

public class 移除元素 {
    /*
     * length
     * k 非目标值
     * length - k 目标值
     * if k > length - k
     *
     * if k < length - k
     */

    public static int removeElement(int[] nums, int val) {
        // int l = 0, r = nums.length - 1;
        // int sum = 0;
        // int temp = 0;
        // for (int i = 0; i < nums.length; i++) {
        // if(nums[i] != val) sum++;
        // }
        // while(l < sum){
        // // 找到目标值
        // while(l < sum && nums[l] != val){
        // l++;
        // }
        // temp++;
        // // 找到非目标值
        // while(r >= 0 && nums[r] == val ){
        // r--;
        // }
        // if(l < sum){
        // temp = nums[l];
        // nums[l] = nums[r];
        // nums[r] = temp;
        // System.out.println();
        // }
        // }
        // return sum;

        // 快慢指针
        // int l = 0;
        // for (int r = 0; r < nums.length; r++) {
        // if(nums[r] != val){
        // nums[l] = nums[r];
        // l++;
        // }
        // }
        // return l;

        // 对撞指针
        int l = 0, r = nums.length; // 防止数组只有一个元素时, l < r 判断失败
        while (l < r) {
            if (nums[l] == val) {
                nums[l] = nums[r - 1];
                r--;
            } else {
                l++;
            }
        }
        return l;
    }

    @Test
    public void test() {
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        // int[] nums2 = { 3, 2, 2, 3 };
        // int[] nums3 = { 1 };
        int val = 2;
        // int val2 = 3;
        // int val3 = 2;
        int res = removeElement(nums, val);
        System.out.println(res);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
