package sowrd_offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 数组中重复的数字 {
    /**
     *
     *  找出数组中重复的数字。
     *
     *
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *
     * 2 <= n <= 100000
     */


    // 超出时间限制
    public int findRepeatNumber(int[] nums) {
        ArrayList<Integer> num = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++){
            while(num.contains(nums[i])){
                return nums[i];
            }
            num.add(nums[i]);
        }
        return 0;
    }


    // 遍历数组
    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }



    @Test
    public void test(){
        int[] nums = {2,3,1,0,2,5,3};
        System.out.println(findRepeatNumber(nums));
    }
}
