package chapter_3;

/*
* 125. 验证回文串
* */
public class three_18 {
    /**
     非常简单
     */
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char ch1 = s.charAt(left);
            char ch2 = s.charAt(right);
            //在里面while也行，一直找到字符为止
            if (!Character.isLetterOrDigit(ch1)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(ch2)) {
                right--;
                continue;
            }
            if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
