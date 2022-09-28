package interview_classic;

import org.junit.Test;

public class URL化 {
    /**
     *
     * URL化。编写一种方法，将字符串中的空格全部替换为%20。
     * 假定该字符串尾部有足够的空间存放新增字符，
     * 并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     *
     * 输入："Mr John Smith    ", 13
     * 输出："Mr%20John%20Smith"
     */
    public String replaceSpaces(String S, int length) {
        char[] s = S.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(s[i] != ' '){
                stringBuilder.append(s[i]);
            }else{
                stringBuilder.append("%20");
            }
        }
        return stringBuilder.toString();
    }

    public String replaceSpaces2(String S, int length){
        char[] ch = new char[length * 3];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                ch[index++] = '%';
                ch[index++] = '2';
                ch[index++] = '0';
            } else {
                ch[index] = c;
                index++;
            }
        }
        return new String(ch, 0, index);
    }

    public String replaceSpaces3(String S, int length){
        //先把字符串转化为字符数组
        char[] chars = S.toCharArray();
        int index = chars.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            //如果遇到空格就把他转化为"%20"
            if (chars[i] == ' ') {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            } else {
                chars[index--] = chars[i];
            }
        }
        return new String(chars, index + 1, chars.length - index - 1);
    }

    @Test
    public void test(){
        String test = "Mr John Smith    ";
//        char[] ch = test.toCharArray();
        System.out.println(replaceSpaces(test, 13));
//        System.out.println(new String(ch, 0, 13));
    }
}
