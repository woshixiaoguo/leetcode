package interview_classic;


 import org.junit.Test;

 import java.util.HashSet;
 import java.util.Set;

public class 判断字符是否唯一 {
    /**
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     *
     * 输入: s = "leetcode"
     * 输出: false
     *
     * 0 <= len(s) <= 100
     * s[i]仅包含小写字母
     * 如果你不使用额外的数据结构，会很加分。
     */
    public boolean isUnique(String astr) {
        Set<Character> unique = new HashSet<>();
        for(int i = 0; i < astr.length(); i++){
            if(!unique.add(astr.charAt(i))) return false;
//            System.out.println(unique.add(astr.charAt(i)));
        }
        return true;
    }

    @Test
    public void test(){
        String test = "leetcode";
//        String test = "abc";
        if(isUnique(test)) System.out.println("true");
        else System.out.println(false);
    }
}
