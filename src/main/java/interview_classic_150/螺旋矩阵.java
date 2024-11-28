package interview_classic_150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

/**
 * 54 螺旋矩阵
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * <img src="https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg"/>
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * <img src="https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg"/>
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 提示：
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * 
 */

public class 螺旋矩阵 {

    private HashSet<Integer> table;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns
                    || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        int[] flag = { 1, 2, 3, 4 };
        table = new HashSet<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int rows = matrix.length;
        int colums = matrix[0].length;
        int sum = rows * colums;
        int x = 0, y = 0;
        int signal = 1;
        int tag = signal;
        while (table.size() < sum) {
            if (tag != signal) {
                tag = signal;
            } else {
                table.add(x * 10 + y);
                ans.add(matrix[y][x]);
            }
            switch (signal) {
                case 1:
                    x++;
                    if (x >= colums || isBoundray(x, y)) {
                        signal = flag[signal % 4];
                        x--;
                    }
                    break;
                case 2:
                    y++;
                    if (y >= rows || isBoundray(x, y)) {
                        signal = flag[signal % 4];
                        y--;
                    }
                    break;
                case 3:
                    x--;
                    if (x < 0 || isBoundray(x, y)) {
                        signal = flag[signal % 4];
                        x++;
                    }
                    break;
                case 4:
                    y--;
                    if (y < 0 || isBoundray(x, y)) {
                        signal = flag[signal % 4];
                        y++;
                    }
                    break;
            }
        }
        return ans;
    }

    public boolean isBoundray(int x, int y) {
        if (table.contains(x * 10 + y))
            return true;
        return false;
    }

    @Test
    public void test() {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matrix2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        int[][] matrix3 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 },
                { 21, 22, 23, 24 } };
        List<Integer> ans = spiralOrder(matrix3);
        ans.forEach((e) -> System.out.print(e + " "));

    }
}
