package sowrd_offer;

import org.junit.Test;

import static java.lang.Math.min;

public class on1中缺失的数字 {

    /**
     *
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     *
     *  输入: [0,1,3]
     *  输出: 2
     *
     *  1 <= 数组长度 <= 10000
     *
     *  解题思路：找出第一个比 index大的数
     */
    public int missingNumber(int[] nums) {
        int leftIdx = 0;
        int rightIdx = nums.length-1;
        int mid;
        while(rightIdx >= leftIdx){
            mid = (rightIdx+leftIdx)/2;
            if(nums[mid] - 1 == mid){
                return mid;
            }else if(nums[mid] == mid){
                leftIdx = mid + 1;
            }else{
                rightIdx = mid - 1;
            }
        }
        return leftIdx;
    }

    public int missingNumber2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    @Test
    public void test(){
//        int[] test = {0,1,2,3,4,5,6,7,8,9,10,12};
        int[] test = {0};
        System.out.println(missingNumber(test));
    }
}
