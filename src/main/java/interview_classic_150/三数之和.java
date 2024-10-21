package interview_classic_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 15 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
 * k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * 
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * 
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * 
 * 
 * 提示：
 * 
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */

public class 三数之和 {
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();

    int l1 = 0, l2, l3;
    for (l1 = 0; l1 < nums.length - 2; l1++) {
      if (nums[l1] > 0)
        break;

      l2 = l1 + 1;
      l3 = nums.length - 1;
      while (l2 < l3) {
        if (m.containsKey(nums[l1]) && m.get(nums[l1]).contains(nums[l2])) {
          l2++;
          continue;
        }
        int sum = nums[l1] + nums[l2] + nums[l3];
        if (l2 < l3 && sum == 0) {
          ans.add(new ArrayList<Integer>(Arrays.asList(nums[l1], nums[l2], nums[l3])));
          if (m.containsKey(nums[l1]))
            m.get(nums[l1]).add(nums[l2]);
          else
            m.put(nums[l1], new ArrayList<Integer>(Arrays.asList(nums[l2])));
        } else if (l2 < l3 && sum < 0)
          l2++;
        else
          l3--;
      }
    }
    m.forEach(
        (key, value) -> {
          System.out.println("key: " + key);
          System.out.println("value: " + value);
        });
    return ans;
  }

  public List<List<Integer>> threeSum2(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    // 枚举 a
    for (int first = 0; first < n; ++first) {
      // 需要和上一次枚举的数不相同
      if (first > 0 && nums[first] == nums[first - 1]) {
        continue;
      }
      // c 对应的指针初始指向数组的最右端
      int third = n - 1;
      int target = -nums[first];
      // 枚举 b
      for (int second = first + 1; second < n; ++second) {
        // 需要和上一次枚举的数不相同
        if (second > first + 1 && nums[second] == nums[second - 1]) {
          continue;
        }
        // 需要保证 b 的指针在 c 的指针的左侧
        while (second < third && nums[second] + nums[third] > target) {
          --third;
        }
        // 如果指针重合，随着 b 后续的增加
        // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
        if (second == third) {
          break;
        }
        if (nums[second] + nums[third] == target) {
          List<Integer> list = new ArrayList<Integer>();
          list.add(nums[first]);
          list.add(nums[second]);
          list.add(nums[third]);
          ans.add(list);
        }
      }
    }
    return ans;
  }

  public static List<List<Integer>> threeSum3(int[] nums) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Arrays.sort(nums);

    int l1, l2, l3;
    for (l1 = 0; l1 < nums.length - 2; l1++) {
      if (nums[l1] > 0)
        break;
      if (l1 > 0 && nums[l1] == nums[l1 - 1])
        continue;
      l2 = l1 + 1;
      l3 = nums.length - 1;
      while (l2 < l3) {
        if (l2 > l1 + 1 && nums[l2] == nums[l2 - 1]) {
          l2++;
          continue;
        }
        if (l2 < l3 && (nums[l1] + nums[l2] + nums[l3]) == 0) {
          ans.add(new ArrayList<>(Arrays.asList(nums[l1], nums[l2], nums[l3])));
          l2++;
        }
        while (l2 < l3 && (nums[l1] + nums[l2] + nums[l3]) < 0)
          l2++;
        while (l2 < l3 && (nums[l1] + nums[l2] + nums[l3]) > 0)
          l3--;
      }
    }
    return ans;
  }

  @Test
  public void test() {
    // int[] nums = { -1, 0, 1, 2, -1, -4 };
    // int[] nums2 = { -1, -1, 0, 1, 2, 4 };
    // int[] nums3 = {0, 0, 0};
    // int[] nums4 = {0, 0, 0, 0};
    int[] nums5 = { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 };
    // int[] nums6 = {-1, 0, 1};
    List<List<Integer>> res = threeSum(nums5);
    for (List<Integer> list : res) {
      for (int num : list) {
        System.out.print(" " + num);
      }
      System.out.println();
    }
  }
}
