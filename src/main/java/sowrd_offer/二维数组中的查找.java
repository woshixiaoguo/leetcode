package sowrd_offer;

import org.junit.Test;

public class 二维数组中的查找 {
    /**
     *
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     *
     * 给定 target = 5，返回 true。
     *
     * 给定 target = 20，返回 false。
     *
     *
     * 0 <= n <= 1000
     *
     * 0 <= m <= 1000
     *
     * 解题思路：树的中序遍历
     *
     * 1. 优先行遍历，
     *   等于目标数，直接返回true
     *   小于目标数且未到行尾，n +1
     *   大于目标数或遍历到行尾，m+1 n=0
     *   遍历完则返回false
     */

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int nMax = matrix.length;
        if(nMax == 0) return false;
        int mMax = matrix[0].length;
        if(mMax == 0) return false;
        int n = 0, m = 0;
        while(n < nMax || m < mMax){
            if(matrix[n][m] == target) return true;
            if(matrix[n][m] < target && n < nMax-1){
                n++;
                System.out.println(matrix[n][m]);
//
            }
            else if(m < mMax-1 && (matrix[n][m] > target || n == nMax-1)){
                n = 0;
                m++;
                System.out.println(matrix[n][m]);
//               if(findson(matrix, n=0, m+1, target)) return true;
            }else{
                return false;
            }
        }
        return false;
    }

   //二分查找
   public boolean findNumberIn2DArray2(int[][] matrix, int target) {
       for (int[] row : matrix) {
           int index = search(row, target);
           if (index >= 0) {
               return true;
           }
       }
       return false;
   }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    @Test
    public void test(){
        int[][] matrix = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        findNumberIn2DArray(matrix, 31);
    }
}
