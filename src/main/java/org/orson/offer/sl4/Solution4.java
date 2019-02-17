package org.orson.offer.sl4;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 队列是 先进先出
 * 堆栈是 先进后出
 */
public class Solution4 {

    // for push
    Stack<Integer> stack1 = new Stack<>();
    // for poll
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        // 其实返回-1也不太合理，Java中队列的行为是如果没有元素就返回null的，这里如果不返回-1，直接抛出异常也不合理。
        return stack2.empty()? -1 : stack2.pop();
    }
}
