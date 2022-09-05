package sowrd_offer;

import org.junit.Test;

import java.util.Stack;

public class 包含min函数的栈 {
    /** initialize your data structure here. */
    /**
     * 包含min函数的栈
     */
    public class MinStack {
        Stack<Integer> stack;
        Stack<Integer> min_stack;


        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
            min_stack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            min_stack.push(Math.min(min_stack.peek(), x));

        }

        public void pop() {
            stack.pop();
            min_stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min_stack.peek();
        }
    }
    @Test
    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
}
