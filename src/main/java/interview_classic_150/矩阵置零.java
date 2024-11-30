package interview_classic_150;

import java.util.HashSet;
import java.util.Stack;

import org.junit.Test;

/**
 * 73 矩阵置零
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 示例 1：
 *
 * <img src="https://assets.leetcode.com/uploads/2020/08/17/mat1.jpg"/>
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 
 * 示例 2：
 * 
 * <img src="https://assets.leetcode.com/uploads/2020/08/17/mat2.jpg"/>
 * 
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 * 
 * 提示：
 * 
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 * 
 * 
 * 进阶：
 * 
 * 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 */

public class 矩阵置零 {

    /**
     * 先找出每行的0的位置，然后置零一行，最后指令所有列
     * 不能置零行的同时，置零列，因为会影响后面行的0元素位置获取
     * 
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Stack<Integer> table = new Stack<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            Stack<Integer> stack = new Stack<Integer>();
            for (int j = 0; j < matrix[0].length; j++) {
                // 查找当前行零的位置
                // System.out.println("check: " + j);
                if (matrix[i][j] == 0) {
                    stack.push(j);
                    table.push(j);
                }
            }
            // 对行清零
            if (!stack.empty()) {
                for (int l = 0; l < matrix[0].length; l++) {
                    matrix[i][l] = 0;
                }
            }

            // for (int[] rows : matrix) {
            // for (int value : rows) {
            // System.out.print(value + " ");
            // }
            // System.out.println();
            // }
            // System.out.println("-------------");
        }
        // 对列清零
        while (!table.empty()) {
            Integer pop = table.pop();
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][pop] = 0;
            }
        }
    }

    /**
     * 使用两个数组标记出现零的行和列
     * 
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    @Test
    public void test() {
        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int[][] matrix2 = { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 }, { 1, 2, 1, 3 }, { 0, 0, 1, 1 } };
        setZeroes(matrix2);
        for (int[] rows : matrix2) {
            for (int value : rows) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }
}
