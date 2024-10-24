package sowrd_offer;

import org.junit.Test;

public class 调整数组顺序使奇数位于偶数前面 {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     *
     *  
     *
     * 示例：
     *
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     *  
     *
     * 提示：
     *
     * 0 <= nums.length <= 50000
     * 0 <= nums[i] <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    class Solution {
        public int[] exchange(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                while (nums[left] % 2 == 0 && nums[right] % 2 == 1) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                if (nums[left] % 2 == 1)
                    left++;
                if (nums[right] % 2 == 0)
                    right--;
            }
            return nums;
        }
    }

    class Solution2 {
        /**
         * 指针移动时一步到位，减少判断
         * 
         * @param nums
         * @return
         */
        public int[] exchange(int[] nums) {
            int left = 0, right = nums.length - 1, temp;
            while (left < right) {
                while (left < right && (nums[left] & 1) == 1)
                    left++;
                while (left < right && (nums[right] & 1) == 0)
                    right--;
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            return nums;
        }
    }

    @Test
    public void test() {
        int[] test = { 1, 2, 3, 4, 5, 6 };
        int[] result = new Solution2().exchange(test);
        for (int ans : result) {
            System.out.println(ans);
        }
    }
}
