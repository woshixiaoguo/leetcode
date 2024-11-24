package interview_classic_150;

import org.junit.Test;

/**
 * 36 有效的数独
 *
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 
 * 1. 数字 1-9 在每一行只能出现一次。
 * 2. 数字 1-9 在每一列只能出现一次。
 * 3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 
 * 
 * 注意：
 * 
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 * 
 * 
 * 示例 1：
 * 
 * <img src=
 * "https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/04/12/250px-sudoku-by-l2g-20050714svg.png"/>
 * 
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * 示例 2：
 * 
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在,
 * 因此这个数独是无效的。
 * 
 * 
 * 提示：
 * 
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 */

public class 有效的数独 {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!checkCol(board, i, j))
                    return false;
                if (!checkRow(board, i, j))
                    return false;
                if (!checkCell(board, i, j))
                    return false;
            }
        }
        return true;
    }

    public boolean checkCol(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            if (i == y || board[x][i] == '.')
                continue;
            if (board[x][i] == board[x][y]) {
                // System.out.println("y: " + i);
                // System.out.println("x: " + x);
                return false;
            }
        }
        return true;
    }

    public boolean checkRow(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            if (i == x || board[i][y] == '.')
                continue;
            if (board[i][y] == board[x][y]) {
                // System.out.println("x: " + i);
                // System.out.println("y: " + y);
                return false;
            }
        }
        return true;
    }

    public boolean checkCell(char[][] board, int x, int y) {
        int xindex = x / 3;
        int yindex = y / 3;
        for (int i = xindex * 3; i < (xindex + 1) * 3; i++) {
            for (int j = yindex * 3; j < (yindex + 1) * 3; j++) {
                if ((i == x && j == y) || board[i][j] == '.')
                    continue;
                if (board[i][j] == board[x][y]) {
                    // System.out.println(i + " " + j);
                    return false;
                }

            }
        }
        return true;
    }

    // 一次遍历
    public boolean isValidSudoku2(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] cell = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    // int index = Character.getNumericValue(c) - 1;
                    int index = c - '0' - 1;// 更快
                    rows[i][index]++;
                    cols[j][index]++;
                    cell[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || cols[j][index] > 1 || cell[i / 3][j / 3][index] > 1)
                        return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        boolean ans = isValidSudoku2(board);
        System.out.println(ans);

    }
}
