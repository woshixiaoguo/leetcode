package interview_classic_150;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;

/**
 * 189 轮转数组
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * 
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * 
 * 
 * 提示：
 * 
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 */

public class 轮转数组 {

    // 使用长为k的队列
    public void rotate(int[] nums, int k) {
        if (k == 0) // 避免 new ArrayBlockingQueue 出错
            return;
        int l = nums.length;
        int offset = k % l; // k 可以大于数组长度
        if (offset == 0) // 避免 new ArrayBlockingQueue 出错
            return;
        Queue<Integer> queue = new ArrayBlockingQueue<>(offset);
        int left = 0, right = l - offset; // right 坐标 不能是 l - offset + 1
        while (left < l) {
            if (queue.offer(nums[left])) {
                nums[left] = nums[right];
                left++;
                right++;
            } else {
                int temp = (int) queue.poll();
                queue.offer(nums[left]);
                nums[left] = temp;
                left++;
            }
        }
    }

    // 数组拷贝
    public void rotate2(int[] nums, int k) {
        int l = nums.length;
        int[] copy = new int[nums.length];
        // int offset = k % l;
        for (int i = 0; i < l; i++) {
            copy[(i + k) % l] = nums[i];
        }
        System.arraycopy(copy, 0, nums, 0, l);

    }

    // 翻转
    public void rotate3(int[] nums, int k) {
        int l = nums.length;
        reverse(nums, 0, l - 1);
        int offset = k % l;
        reverse(nums, 0, offset - 1);
        reverse(nums, offset, l - 1);

    }

    void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[e];
            nums[e] = nums[s];
            nums[s] = temp;
            s++;
            e--;
        }
    }

    @Test
    public void test() {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 10;
        int[] nums2 = { -1 };
        int k2 = 2;

        rotate3(nums, k);
        // reverse(nums, 2, 5);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

}
