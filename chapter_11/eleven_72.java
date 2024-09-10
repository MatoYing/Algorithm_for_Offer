package chapter_11;

/*
* 69. x 的平方根
* */
public class eleven_72 {
    /**
     很基础的二分，要注意返回的是开方的整数
     不过这个while结束时的mid不好确定，但跳出来的时候一定是在平方根附近的！我的解决方式
     是加中间加了个mid+1的判断。
     (long) mid * mid是把前一个mid转为long类型，再和后一个mid相乘；(long)(mid * mid)
     是两个int的mid相乘（这里发生溢出），再转为long.
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        // 为0时直接输出0
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if ((long) mid * mid == x)
                return mid;
                // 除了0意外事件，和相等的，都会从这里结束
            else if ((long) mid * mid < x &&  (long) (mid + 1) * (mid + 1) > x)
                return mid;
            else if ((long) mid * mid < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return mid;
    }
}
