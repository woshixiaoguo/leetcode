package weekly_match;

import org.junit.Test;

/*
 * 100378 设计相邻元素求和服务
 * 给你一个 n x n 的二维数组 grid，它包含范围 [0, n2 - 1]
内的不重复元素。

实现 neighborSum 类：

neighborSum(int [][]grid) 初始化对象。
int adjacentSum(int value) 返回在 grid 中与 value
相邻的元素之和，相邻指的是与 value
在上、左、右或下的元素。 int diagonalSum(int value) 返回在
grid 中与 value
对角线相邻的元素之和，对角线相邻指的是与 value
在左上、右上、左下或右下的元素。

示例 1：

输入：

["neighborSum", "adjacentSum", "adjacentSum", "diagonalSum", "diagonalSum"]

[[[[0, 1, 2], [3, 4, 5], [6, 7, 8]]], [1], [4], [4], [8]]

输出： [null, 6, 16, 16, 4]

解释：


1 的相邻元素是 0、2 和 4。
4 的相邻元素是 1、3、5 和 7。
4 的对角线相邻元素是 0、2、6 和 8。
8 的对角线相邻元素是 4。


提示：

3 <= n == grid.length == grid[0].length <= 10
0 <= grid[i][j] <= n2 - 1
所有 grid[i][j] 值均不重复。
adjacentSum 和 diagonalSum 中的 value 均在范围 [0, n2 - 1] 内。
最多会调用 adjacentSum 和 diagonalSum 总共 2 * n2 次 */

public class 设计相邻元素求和服务 {
  public class neighborSum {
    int[][] grid;

    public neighborSum(int[][] grid) { this.grid = grid; }

    public int adjacentSum(int value) {
      int sum = 0;
      int width = this.grid.length;
      int idxi = -1, idxj = -1;
      for (int i = 0; i < width; i++) {
        for (int j = 0; j < width; j++) {
          if (this.grid[i][j] == value) {
            idxi = i;
            idxj = j;
          }
        }
      }
      sum = getValue(idxi - 1, idxj) + getValue(idxi + 1, idxj) +
            getValue(idxi, idxj - 1) + getValue(idxi, idxj + 1);
      return sum;
    }

    public int diagonalSum(int value) {
      int sum = 0;
      int width = this.grid.length;
      int idxi = -1, idxj = -1;
      for (int i = 0; i < width; i++) {
        for (int j = 0; j < width; j++) {
          if (this.grid[i][j] == value) {
            idxi = i;
            idxj = j;
          }
        }
      }
      sum = getValue(idxi - 1, idxj - 1) + getValue(idxi - 1, idxj + 1) +
            getValue(idxi + 1, idxj - 1) + getValue(idxi + 1, idxj + 1);

      return sum;
    }

    public int getValue(int i, int j) {
      int width = this.grid.length;
      if (i >= 0 && i < width && j >= 0 && j < width)
        return this.grid[i][j];
      else
        return 0;
    }
  }

  @Test
  public void test() {
    int[][] grid = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    neighborSum obj = new neighborSum(grid);
    int value = 1;
    int value2 = 4;
    int param_1 = obj.adjacentSum(value);
    int param_2 = obj.diagonalSum(value2);
    System.out.println("param_1: " + param_1);
    System.out.println("param_2: " + param_2);
  }
}
