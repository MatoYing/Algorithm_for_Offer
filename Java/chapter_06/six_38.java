package chapter_6;

import java.util.Stack;

/*
* 739. 每日温度
* */
public class six_38 {
    /**
     刚开始理解错了题意，它这个是捕获到第一个比自己高的就行。
     所以大致思路就是，顺序遍历数组，比他小就push，遇见比他大的就pop，并计算天数差
     ，注意栈里面放的是数组下标(起初一直不知道satck如何又有index又有value)！！！
     然后通过取出index用原数组进行比，并且计算天数。
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                // 如果不pop那你接下来push进来的值一路往下压，你还得判断之前的值在ans中
                // 是否已经有值
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
}
