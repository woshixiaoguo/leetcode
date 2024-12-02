package interview_classic_150;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 228 汇总区间
 *
 * 给定一个 无重复元素 的 有序 整数数组 nums 。
 * 
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于
 * nums 的数字 x 。
 * 
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * 
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * 
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 
 * 
 * 提示：
 * 
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 */

public class 汇总区间 {

    // 6ms
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        ArrayList<String> table = new ArrayList<String>();
        int l = nums[0], r = l; // r = nums[1] 可能会数组越界

        for (int i = 1; i < nums.length; i++) {
            r = nums[i];
            if (r - nums[i - 1] == 1) {
                continue;
            } else {
                if (nums[i - 1] == l) { // 节点
                    table.add(String.valueOf(l));
                } else { // 区间
                    table.add(String.valueOf(l) + "->" + String.valueOf(nums[i - 1]));
                }
                l = r;
            }
        }
        if (l != r) {
            table.add(String.valueOf(l) + "->" + String.valueOf(r));
        } else {
            table.add(String.valueOf(l));
        }
        return table;
    }

    // 0ms
    // 在循环中取值，可以减去开头对数组长度为空的判断
    public List<String> summaryRanges2(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }

    @Test
    public void test() {
        int[] nums = { 0, 2, 3, 4, 6, 8, 9 };
        int[] nums2 = { 0, 1, 2, 4, 5, 7 };

        List<String> ans = summaryRanges(nums2);
        ans.forEach((e) -> System.out.println(e));
    }
}
