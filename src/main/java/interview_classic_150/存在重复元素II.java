package interview_classic_150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
 * 219 存在重复元素II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j
 * ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true
 * ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 *
 * 示例 3：
 *
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 */
import org.junit.Test;

public class 存在重复元素II {

    // 超出时间限制
    boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        int length = Integer.MAX_VALUE;
        while (l < nums.length - 1) {
            int r = l + 1;
            while (r < nums.length) {
                if (nums[l] == nums[r])
                    length = (r - l) < length ? r - l : length;
                r++;
            }
            l++;
        }
        return length <= k;
    }

    // 哈希表
    // 22ms 56.6MB
    boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!table.containsKey(nums[i])) {
                table.put(nums[i], i);
            } else {
                int index = table.get(nums[i]);
                if ((i - index) <= k)
                    return true;
                else {
                    table.put(nums[i], i);
                }
            }
        }
        return false;
    }

    // 哈希表改进
    // 18ms 56.6MB
    boolean containsNearbyDuplicate3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }

    // 滑动窗口 ❌
    // 1722ms 54.3MB
    boolean containsNearbyDuplicate4(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) { // 窗口可能比数组长
            for (int j = i + 1; j < Math.min(nums.length, i + k + 1); j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    // 滑动窗口
    // 15ms 55.1MB
    boolean containsNearbyDuplicate5(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void Test() {
        int[] nums = { 1, 2, 3, 1, 2, 3 };
        int k = 2;

        int[] nums2 = { 1, 2, 3, 1 };
        int k2 = 3;

        int[] nums3 = { 99, 99 };
        int k3 = 2;

        int[] nums4 = { 2, 2 };
        int k4 = 3;

        boolean res = containsNearbyDuplicate4(nums4, k4);
        System.out.println(res);
    }
}
