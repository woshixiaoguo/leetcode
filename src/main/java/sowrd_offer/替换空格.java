package sowrd_offer;

import org.junit.Test;

public class 替换空格 {
    /**
     *  请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     *  输入：s = "We are happy."
     *  输出："We%20are%20happy."
     *
     *  0 <= s 的长度 <= 10000
     */

    public String replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            if(letter == ' '){
                stringBuffer.append("%20");
            }else{
                stringBuffer.append(letter);
            }
        }
        return stringBuffer.toString();
    }

    @Test
    public void test(){
        String test = "We are happy.";
        System.out.println(replaceSpace(test));
    }

}
