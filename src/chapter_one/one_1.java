package chapter_one;

/*
* 29. 两数相除
* */
public class one_1 {
    /**
     思路：
     这道题思路很正常，除法吗，就是利用被除数减除数，然后找个值记录一下减了几次。
     注意：
     1.如果你就呢么原始的写，会超时，所以它中间那里有个while的操作，就是用来减少减的次
     数（一次减两个除数、减四个除数...）
     2.在开始处，它全变为了负数，为什么？如果不变一正一负，你后面还得分类（比如呢两个
     while）；如果全变成正数，负到正时可能溢出的。说到这里那两数相除可能溢出吗？这道
     题不可能，因为它是整数除法，所以它的数字段一定是变小的（除了除1，也就是下面代码，
     第一个if的意义）
     */
    public int divide(int dividend, int divisor) {
        //因为是整数除法，所以只有一种情况会溢出，而且题中又说，如果溢出返回 231 − 1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int temp = 0;
        int ans = 0;
        if (dividend > 0) {
            dividend = -dividend;
            temp++;
        }
        if (divisor > 0) {
            divisor = -divisor;
            temp++;
        }
        //注意这里是俩负数
        while (dividend <= divisor) {
            //每次又新int这俩，就是为了对应下面呢个while循环
            int value = divisor;
            int min_ans = 1;
            //！！！再次注意，这里是负数
            //这里只是为了加快速度，不加这个会超出时间限制；0xc0000000防止越界(没意思~~)
            while (value >= 0xc0000000 && dividend <= value + value) {
                //一次可以就是原来两倍
                min_ans += min_ans;
                value += value;
            }
            ans += min_ans;
            dividend -= value;
        }
        if (temp == 1) {
            ans = -ans;
        }
        return ans;
    }
}
