package interview_classic_150;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 68 文本左右对齐
 *
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 
 * 注意:
 * 
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 
 * 
 * 示例 1:
 * 
 * 输入: words = ["This", "is", "an", "example", "of", "text", "justification."],
 * maxWidth = 16
 * 输出:
 * [
 * "This is an",
 * "example of text",
 * "justification. "
 * ]
 * 示例 2:
 * 
 * 输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * 输出:
 * [
 * "What must be",
 * "acknowledgment ",
 * "shall be "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be " 而不是 "shall be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * 
 * 输入:words =
 * ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth
 * = 20
 * 输出:
 * [
 * "Science is what we",
 * "understand well",
 * "enough to explain to",
 * "a computer. Art is",
 * "everything else we",
 * "do "
 * ]
 * 
 * 
 * 提示:
 * 
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] 由小写英文字母和符号组成
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 */

public class 文本左右对齐 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int count = 0;
        List<String> ans = new ArrayList<>();
        List<String> row = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            count += words[i].length() + 1;
            if (count > maxWidth + 1) {
                // ans.add(sb.toString());
                if ((count - words[i].length() - 1) == maxWidth + 1) {// 不以空格结尾
                    ans.add(align(row, row.size() - 1, maxWidth)); // 空格比单词数少一个
                } else {
                    ans.add(align(row, maxWidth - (count - words[i].length() - 1) + row.size(), maxWidth));
                }
                count = words[i].length() + 1;
                row.clear();
                row.add(words[i]);
                // row.add(" ");

            } else {
                row.add(words[i]);
                // row.add(" ");
            }
        }
        StringBuilder sb = new StringBuilder();
        row.forEach((e) -> {
            sb.append(e);
            sb.append(" ");
        });
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        ans.add(sb.toString().substring(0, maxWidth));
        // ans.add(row.toString());
        return ans;
    }

    public String align(List<String> row, int blankN, int maxWidth) {
        System.out.println("blankN: " + blankN + "maxWidth: " + maxWidth);
        StringBuilder sb = new StringBuilder();
        if (row.size() == 1) {
            sb.append(row.get(0));
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int l = blankN / (row.size() - 1);
        int r = blankN % (row.size() - 1);
        // sb.append(row.get(0));
        // for (int i = 0; i < l + r; i++) {
        // sb.append(" ");
        // }
        // for (int i = 1; i < row.size(); i++) {
        // sb.append(row.get(i));
        // for (int j = 0; j < l; j++) {
        // sb.append(" ");
        // }
        // }
        outer: for (int i = 0; i < row.size(); i++) {
            sb.append(row.get(i));

            if (sb.length() == maxWidth)
                break outer;
            if (r > 0) {
                for (int j = 0; j <= l; j++) {
                    sb.append(" ");
                }
                r--;
            } else {
                for (int j = 0; j < l; j++) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();

    }

    @Test
    public void test() {
        String[] words = { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
                "computer.", "Art", "is", "everything", "else", "we", "do" };
        int maxWidth = 20;
        String[] words2 = { "What", "must", "be", "acknowledgment", "shall", "be" };
        int maxWidth2 = 16;
        List<String> fullJustify = fullJustify(words, maxWidth);
        fullJustify.forEach((e) -> {
            System.out.print(e);
            System.out.println("|");
        });

    }
}
