package chapter_13;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
* 93. 复原 IP 地址
* */
public class thirteen_87 {
    /**
     不难，就是if比较多。思路和原来一样。
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        String str = "";
        backtrack(0, res, temp, s, str);
        return res;
    }

    public void backtrack(int n, List<String> res, List<String> temp, String s, String str) {

        // if (temp.size() != 4 && (s.length() - n) / (4 - temp.size()) > 3) {
        //     return;
        // }
        if ((4 - temp.size()) * 3 < (s.length() - n) || (4 - temp.size()) > (s.length() - n)) {
            // 如果剩下的个数都不够填充或过多
            return;
        }
        if (temp.size() > 4) {
            // 超过4个分割
            return;
        }
        if (temp.size() != 0) {
            if (temp.get(temp.size() - 1).length() > 3) {
                // 位数超过3
                return;
            }
            if (Integer.parseInt(temp.get(temp.size() - 1)) > 255) {
                // 数字超过255
                return;
            }
        }
        if (n == s.length()) {
            if (temp.size() != 4) {
                // 没分购4个
                return;
            }
            String ans = String.join(".", temp);
            res.add(ans);
            return;
        }

        for (int i = n; i <= s.length() - 1; i++) {
            str += s.charAt(i);
            if (str.length() != 1 && str.charAt(0) == '0') {
                // 防止0开头
                return;
            }
            temp.add(str);
            backtrack(i + 1, res, temp, s, "");
            temp.remove(temp.size() - 1);
        }
    }
}
