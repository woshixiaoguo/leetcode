package sowrd_offer;

import org.junit.Test;

public class 在排序数组中查找数字 {
    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     * nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     *
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums 是一个非递减数组
     * -109 <= target <= 109
     *
     *
     */

    public int search(int[] nums, int target) {
        int len =  nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] < target){
//                System.out.println(1);
//                i += target - nums[i] - 1;
            } else if (nums[i] == target) {
//                System.out.println(2);
                sum += 1;
            }else{
                break;
            }
        }
        return sum;
    }


    //二分查找
    public int search2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }



    @Test
    public void test(){
        int[] nums = {5,7,7,8,8,10};
        System.out.println(search(nums,8));
    }
}
