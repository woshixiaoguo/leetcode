package interview_classic_150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/*
 * 128 最长连续序列
 *
 * 给定一个未排序的整数数组 nums
 * ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

/*
 * 当字符串长度超过1时，才需考虑子串连续问题，小于2时字符串本身就连续。
对字符串进行排序后，可能存在重复字符影响连续性，然而依据题意，该子串不该被重复字符分割。
*/

public class 最长连续序列 {
  // 双指针
  // 12ms 98.27% 55.25MB 97.57%
  public int longestConsecutive(int[] nums) {
    if (nums.length < 2)
      return nums.length;
    int max = 0;
    Arrays.sort(nums);
    for (int k = 0; k < nums.length; k++) {
      System.out.println(nums[k]);
    }
    int i = 0, j = 1;
    while (j < nums.length) {
      while (j < nums.length && nums[j] - nums[j - 1] <= 1) {
        if (nums[j] - nums[j - 1] == 0) // 减去重复字符
          i++;
        j++;
      }
      max = Math.max(max, j - i);
      j++;
      i = j - 1;
    }
    return max;
  }

  // 哈希表
  // 26ms 82.61% 66.17MB 6.75%
  public int longestConsecutive2(int[] nums) {
    Set<Integer> num_set = new HashSet<Integer>();
    for (int num : nums) {
      num_set.add(num);
    }

    int longestStreak = 0;

    for (int num : num_set) {
      if (!num_set.contains(num - 1)) { // 判断该数是否为子串开头
        int currentNum = num;
        int currentStreak = 1;

        while (num_set.contains(currentNum + 1)) { // 计算以该数开头的子串的长度
          currentNum += 1;
          currentStreak += 1;
        }

        longestStreak = Math.max(longestStreak, currentStreak);
      }
    }

    return longestStreak;
  }

  @Test
  public void test() {
    int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    int[] nums2 = {0, -1};
    int[] nums3 = {1, 2, 0, 1};
    int res = longestConsecutive(nums2);
    System.out.println(res);
  }
}
