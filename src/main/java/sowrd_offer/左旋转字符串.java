package sowrd_offer;

import org.junit.Test;

public class 左旋转字符串 {
    /**
     *  字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     *  输入: s = "abcdefg", k = 2
     *  输出: "cdefgab"
     */

    public String reverseLeftWords(String s, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = n; i < s.length(); i++){
            stringBuffer.append(s.charAt(i));
        }
        for(int i = 0; i < n; i++){
            stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();

    }

    //字符串切片
    public String reverseLeftWords2(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }



    @Test
    public void test(){
        String test = "abcdefg";
        System.out.println(reverseLeftWords(test,2));
    }
}
