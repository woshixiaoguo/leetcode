package interview_classic_150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

import org.junit.Test;

/**
 * 71 简化路径
 *
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为 更加简洁的规范路径。
 * 
 * 在 Unix 风格的文件系统中规则如下：
 * 
 * 一个点 '.' 表示当前目录本身。
 * 此外，两个点 '..' 表示将目录切换到上一级（指向父目录）。
 * 任意多个连续的斜杠（即，'//' 或 '///'）都被视为单个斜杠 '/'。
 * 任何其他格式的点（例如，'...' 或 '....'）均被视为有效的文件/目录名称。
 * 返回的 简化路径 必须遵循下述格式：
 * 
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 * 
 * 示例 1：
 * 
 * 输入：path = "/home/"
 * 
 * 输出："/home"
 * 
 * 解释：
 * 
 * 应删除尾随斜杠。
 * 
 * 示例 2：
 * 
 * 输入：path = "/home//foo/"
 * 
 * 输出："/home/foo"
 * 
 * 解释：
 * 
 * 多个连续的斜杠被单个斜杠替换。
 * 
 * 示例 3：
 * 
 * 输入：path = "/home/user/Documents/../Pictures"
 * 
 * 输出："/home/user/Pictures"
 * 
 * 解释：
 * 
 * 两个点 ".." 表示上一级目录（父目录）。
 * 
 * 示例 4：
 * 
 * 输入：path = "/../"
 * 
 * 输出："/"
 * 
 * 解释：
 * 
 * 不可能从根目录上升一级目录。
 * 
 * 示例 5：
 * 
 * 输入：path = "/.../a/../b/c/../d/./"
 * 
 * 输出："/.../b/d"
 * 
 * 解释：
 * 
 * "..." 在这个问题中是一个合法的目录名。
 * 
 * 
 * 
 * 提示：
 * 
 * 1 <= path.length <= 3000
 * path 由英文字母，数字，'.'，'/' 或 '_' 组成。
 * path 是一个有效的 Unix 风格绝对路径。
 * 
 */

public class 简化路径 {

    // 3ms
    public String simplifyPath(String path) {
        int start = 0;
        int end = 0;
        ArrayList<String> table = new ArrayList<String>();
        StringBuffer stringBuffer = new StringBuffer();
        while (end < path.length()) {
            while (end < path.length() && path.charAt(end) == '/') { // 找'/'
                end++;
            }
            table.add("/");
            start = end;
            while (end < path.length() && path.charAt(end) != '/') { // 找目录名
                end++;
            }
            String substring2 = path.substring(start, end);
            int flag = 3;
            if (substring2.equals("..")) {
                while (flag != 0 && table.size() != 0) {
                    table.remove(table.size() - 1);
                    flag--;
                }
                continue;
            }
            if (substring2.equals(".")) {
                table.remove(table.size() - 1);
            } else {
                table.add(substring2);
            }
            start = end;
        }
        if (table.size() > 0 && table.get(table.size() - 1).equals("")) { // 以"/"结尾，会多add()一个""
            int flag = 2;
            while (table.size() != 1 && flag != 0) {
                table.remove(table.size() - 1);
                flag--;
            }
        }
        if (table.size() == 0) // 保证根目录
            return "/";
        table.forEach((e) -> stringBuffer.append(e));
        return stringBuffer.toString();
    }

    // 3ms
    public String simplifyPath2(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }

    // 6ms
    public String simplifyPath3(String path) {
        ArrayList<String> table = new ArrayList<String>();
        String[] names = path.split("/");
        for (String name : names) {
            if (name.equals("..")) {
                if (!table.isEmpty()) {
                    table.remove(table.size() - 1);
                }
            } else if (name.length() > 0 && !name.equals(".")) {
                table.add(name);
            }
        }
        // System.out.println(table.size());
        String[] array = table.toArray(new String[table.size()]);
        if (array.length == 1) // 只有一个元素，无法join
            return "/" + array[0];
        String join = String.join("/", array);
        return "/" + join;
    }

    @Test
    public void test() {
        String path = "/.../a/../b/c/../d/./";
        String path2 = "/../";
        String path3 = "/home/user/Documents/../Pictures";
        String path4 = "/a/./b/../../c/";
        String path5 = "/home/";
        String path6 = "/.";
        // String ans = simplifyPath(path6);
        String ans = simplifyPath3(path3);
        System.out.println(ans);
    }
}
