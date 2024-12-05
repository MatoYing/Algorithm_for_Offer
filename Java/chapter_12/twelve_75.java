package chapter_12;

/*
* 1122. 数组的相对排序
* */
public class twelve_75 {
    /**
     计数排序，很巧妙。把每个数字出现的次数记录下来，再根据arr2的顺序打出来。
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 找出数组中的最大值
        int max = -1;
        for (int i = 0; i < arr1.length; i++) {
            max = Math.max(arr1[i], max);
        }
        // +1因为有0，而且存的时候更方便
        int[] temp = new int[max + 1];
        // 计数
        for (int i = 0; i < arr1.length; i++) {
            temp[arr1[i]] += 1;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        // 先把arr2里的排完
        for (int i = 0; i < arr2.length; i++) {
            int count = temp[arr2[i]];
            // 防止对下面呢个处理arr2外的循环干扰
            temp[arr2[i]] = 0;
            for (int j = 0; j < count; j++) {
                ans[index] = arr2[i];
                index++;
            }
        }
        // 处理剩余的元素
        for (int i = 0; i <= max; i++) {
            if (temp[i] != 0) {
                for (int j = 0; j < temp[i]; j++) {
                    ans[index] = i;
                    index++;
                }
            }
        }
        return ans;
    }
}
