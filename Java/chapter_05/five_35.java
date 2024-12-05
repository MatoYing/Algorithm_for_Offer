package chapter_5;

import java.util.Arrays;
import java.util.List;

/*
*  539. 最小时间差
* */
public class five_35 {
    /**
     书上呢个方法没啥意思，他就是为了避免排序，创造了长1440的数组（一天1440分钟），然后一个一
     个遍历时间，把数组里面对应的转成true，最后在遍历数组，相邻的为true的一个一个减，找出最小。
     我就直接转成分钟排序写了。
     */
    public int findMinDifference(List<String> timePoints) {
        int[] arr = new int[timePoints.size()];
        for(int i = 0; i < timePoints.size(); i++) {
            arr[i] = Integer.parseInt(timePoints.get(i).substring(0, 2)) * 60 + Integer.parseInt(timePoints.get(i).substring(3));
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }
        return Math.min(min, 1440 - (arr[arr.length - 1] - arr[0]));  // 想呢个时钟图
    }
}
