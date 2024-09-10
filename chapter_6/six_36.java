package chapter_6;

import java.util.Stack;

/*
* 150. 逆波兰表达式求值
* */
public class six_36 {
    /**
     比较基础的栈的用法
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                // 后出来的数在前
                int res = accumulate(a, b, token);
                stack.push(Integer.valueOf(res));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }

    public int accumulate(int a, int b, String str) {
        if (str.equals("+"))
            return a + b;
        else if (str.equals("-"))
            return a - b;
        else if (str.equals("*"))
            return a * b;
        else
            return a / b;
    }
}
