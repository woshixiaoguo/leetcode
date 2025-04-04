package interview_classic_150;

import javax.swing.plaf.synth.SynthRadioButtonUI;

import org.junit.Test;

/**
 * 6 Z字形变换
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * 
 * P A H N
 * A P L S I I G
 * Y I R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * string convert(string s, int numRows);
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P I N
 * A L S I G
 * Y A H R
 * P I
 * 示例 3：
 * 
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * 
 * 
 * 提示：
 * 
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */

public class Z字形变换 {

    public String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows == 1)
            return s;
        int[] steps = new int[numRows];
        for (int i = 0; i < numRows - 1; i++) {
            steps[i] = (numRows - i - 1) * 2;
        }
        steps[numRows - 1] = steps[0];

        // for (int i = 0; i < numRows; i++) {
        // System.out.println(steps[i]);
        // }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            boolean flag = true;
            for (int j = i; j < s.length();) {
                sb.append(s.charAt(j));
                // System.out.println(i);
                if (flag)
                    j += steps[i];
                else
                    j += steps[numRows - i - 1];
                flag = !flag;
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String s2 = "A";
        int numRows2 = 1;
        String ans = convert(s2, numRows2);
        System.out.println(ans);

    }
}
