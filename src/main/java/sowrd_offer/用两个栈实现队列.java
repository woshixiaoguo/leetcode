package sowrd_offer;

import org.junit.Test;

import java.util.Stack;

class 用两个栈实现队列 {
    /**
     * 用两个栈实现队列
     * <p>
     * <p>
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 输入：
     * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     * [[],[],[5],[2],[],[]]
     * 输出：[null,-1,null,null,5,2]
     * <p>
     * 1 <= values <= 10000
     * 最多会对 appendTail、deleteHead 进行 10000 次调用
     * <p>
     * 解题思路： 一个栈负责入，一个栈负责出。只有当负责出的栈为空时，才将负责入的栈全部倾倒入负责出的栈中。
     */
    class CQueue {

        Stack<Integer> inStack;
        Stack<Integer> outStack;

        public CQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void appendTail(int value) {
            inStack.push(value);
        }

        public int deleteHead() {
            if (outStack.isEmpty()) {
                inToOut();
            }
            return outStack.isEmpty() ? -1 : outStack.pop();
        }

        private void inToOut() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
        @Test
    public void test(){
        System.out.println("hello");
    }
}



//class CQueue {
//
//    Stack<Integer> inStack;
//    Stack<Integer> outStack;
//    int size = 0;
//    public CQueue() {
//        inStack = new Stack<>();
//        outStack = new Stack<>();
//    }
//    public void appendTail(int value) {
//        inStack.push(value);
//        size++;
//    }
//
//    public int deleteHead() {
//        if(size==0){
//            return -1;
//        }
//        if(outStack.empty()){
//            while(!inStack.empty()){
//                outStack.push(inStack.pop());
//            }
//        }
//        size--;
//        return outStack.pop();
//
//    }
//}