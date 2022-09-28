package interview_classic;

import org.junit.Test;

import java.util.HashSet;

public class 回文排列 {
    /**
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     *
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     *
     * 回文串不一定是字典当中的单词。
     *
     * 输入："tactcoa"
     * 输出：true（排列有"tacocat"、"atcocta"，等等）
     */

    public boolean canPermutePalindrome(String s) {
        HashSet<Character> characters = new HashSet<Character>();
//        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(characters.add(s.charAt(i))) ;
            else{
                characters.remove(s.charAt(i));
            }
            for (char c:characters
                 ) {
                System.out.print(c);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println(characters.size());
        if(characters.size() <= 1) return true;
        else return false;
    }

    @Test
    public void test(){
        String test = "tacetcoae";
        if(canPermutePalindrome(test)) System.out.println("true");
        else System.out.println("false");
    }
}
