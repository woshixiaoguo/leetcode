package sowrd_offer;

import org.junit.Test;

public class 旋转数组的最小数字 {
    /**
     *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     *
     * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。  
     *
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     *
     * 输入：numbers = [3,4,5,1,2]
     * 输出：1
     *
     *n == numbers.length
     * 1 <= n <= 5000
     * -5000 <= numbers[i] <= 5000
     * numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
     *
     */
    public int minArray(int[] numbers) {
        int leftIdx = 0, rightIdx = numbers.length-1;
        if(numbers[rightIdx] > numbers[leftIdx]){
            return numbers[leftIdx];
        }
        while(leftIdx < rightIdx){
            int mid = (leftIdx+rightIdx)/2;
            if(numbers[mid] > numbers[rightIdx]){
                leftIdx = mid +1;
            }else if(numbers[mid] < numbers[rightIdx]){
                rightIdx = mid;
            }else{
                rightIdx -= 1;
            }
        }
        return numbers[leftIdx];
    }

    @Test
    public void test(){
//        int[] numbers = {3,4,5,1,2};
//        int[] numbers = {2,2,2,0,1};
//        int[] numbers = {10,1,10,10,10};
        int[] numbers ={3,3,1,3};
        System.out.println(minArray(numbers));
    }
}
