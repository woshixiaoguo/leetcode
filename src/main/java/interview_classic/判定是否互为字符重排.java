package interview_classic;

import org.junit.Test;

public class 判定是否互为字符重排 {
    /**
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     *
     * 输入: s1 = "abc", s2 = "bca"
     * 输出: true
     *
     * 0 <= len(s1) <= 100
     * 0 <= len(s2) <= 100
     */
    public boolean CheckPermutation(String s1, String s2) {
        int len = s1.length();
        if(len != s2.length()) return false;
        int[] table = new int[26];
        for(int i = 0; i < len; i++){
             table[s1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < len; i++){
            table[s2.charAt(i) - 'a']--;
            if(table[s2.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }

    @Test
    public void test(){
        String test = "abc";
        String test2 = "bca";
        String test3 = "bad";
        if(CheckPermutation(test,test2)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
