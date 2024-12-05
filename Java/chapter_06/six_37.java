package chapter_6;

import java.util.Stack;

/*
* 735. 行星碰撞
* */
public class six_37 {
    /**
     思路很简单，这个代码说实话写的很恶心。
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (stack.empty()) {
                stack.push(asteroid);
                continue;
            }
            // 只有前正，后负才会发生碰撞。
            if (stack.peek() > 0 && asteroid < 0) {
                // 用于标识在处理完新来的后，是否要继续处理（吃掉里面的）
                boolean flag = true;
                // 因为吃掉后要考虑要不要继续往里吃，所以弄了个循环
                while (flag) {
                    int inner = stack.pop();
                    if (inner + asteroid != 0 && inner > 0 && asteroid < 0) {
                        // 要吃掉
                        if (inner < -asteroid) {
                            // 要吃掉旧的
                            if (!stack.empty() && stack.peek() > 0) {
                                // 要继续吃
                                flag = true;
                            } else {
                                // 不继续吃
                                stack.push(asteroid);
                                flag = false;
                            }
                        } else {
                            // 要吃掉新的
                            stack.push(inner);
                            flag = false;
                        }
                    } else if (inner + asteroid == 0) {
                        // 为0直接提出while
                        break;
                    } else {
                        // 不需要吃掉，直接push进去退出while
                        stack.push(inner);
                        stack.push(asteroid);
                        flag = false;
                    }
                }
            } else {
                // 不需要吃掉，直接push进去
                stack.push(asteroid);
            }
        }
        int[] arr = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            arr[i] = stack.pop();
        }
        // 比下面的更快一些
        return arr;
        // stream():可以把它们看成遍历数据集的高级迭代器,它不是一个数据结构，
        // 它不存储任何数据，它是一种数据处理工具，代表了一种能力。
        // return stack.stream().mapToInt(i->i).toArray();
    }
}
