package chapter_1;

/*
* 67. 二进制求和
* */
public class one_2 {
    /**
     思路：
        思路其实很简单的，但《剑指offer》的代码很难懂，下面我采用了更直白的写法，懂了这个它
        的写法也就懂了。
        思路就是将两个二进制数，分别将他们所对应的位数从低位加到高位，和正常加法一样，只不过
        是逢二进一。
     注意：
        1.len最大处对应数的最低位
     */
    public String addBinary(String a, String b) {
        //这个二进制不分正负数
        int a_len = a.length() - 1;
        int b_len = b.length() - 1;
        StringBuilder builder = new StringBuilder();
        //temp是要进位的数字
        int temp = 0;
        int sum;
        //要从高位遍历，二进制最后边的是最小的
        while (a_len >= 0 && b_len >= 0) {
            sum = temp;
            sum += a.charAt(a_len--) - '0';  //转换为int
            sum += b.charAt(b_len--) - '0';
            //System.out.println(sum);
            temp = sum / 2;
            builder.append(sum % 2);
        }
        //如果还没遍历完
        while (a_len >= 0 || b_len >= 0) {
            //注意之前可能还有进位
            sum = temp;
            //还是这么写是因为比如说后面是1111，之前进的1会导致后面仍然要进位
            if (a_len >= 0)
                sum += a.charAt(a_len--) - '0';
            else
                sum += b.charAt(b_len--) - '0';
            temp = sum / 2;
            builder.append(sum % 2);
        }
        //仍然是，处理上面结束后最后一个进位
        if (temp != 0)
            builder.append(temp);
        //之前的append使最低位变成了最高位
        return builder.reverse().toString();
    }
}
