package chapter_11;

/*
* 852. 山脉数组的峰顶索引
* */
public class eleven_69 {
    /**
     这题就是找最大值，呃，挺没意思的。用二分的话时间复杂度低一些。mid如果比前后数字都打就是山峰...
     这也体现出另一种适合二分的场景，就是分段排序。
     */
    public int peakIndexInMountainArray(int[] arr) {
        // 由于第一个和最后一个可能是最大值，并且防止下面越界，先单独判断
        // 并且题上说了长度最小为3
        if (arr[0] > arr[1])
            return 0;
        if (arr[arr.length - 1] > arr[arr.length - 2])
            return arr.length - 1;
        //这里注意起始位置也要改。比如left，你如果写0，因为mid是有可能等与left的，到时候-1就会越界
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;
                // 题目说了，没有等于的情况
            else if (arr[mid] < arr[mid + 1])  //arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]
                left = mid + 1;
            else
                right = mid - 1;

        }
        return -1;
    }
}
