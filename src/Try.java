// # 手上有 n 朵花，每朵的花瓣数保存在一个数组中。我们每次可以选择任意一朵，拿走其中的一瓣或者两瓣，求掰完所有花的最少次数。

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Try{
    public static void main(String[] args) {
        new ThreadPoolExecutor(50, 30, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));

        System.out.println(solve("1", "99"));
    }

    public static String solve (String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        int value = 0;
        while(len1 > 0 || len2 > 0) {
            int l = len1 > 0 ? Integer.valueOf(s.charAt(len1-1)) : 0;
            int r = len2 > 0 ? Integer.valueOf(t.charAt(len2-1)) : 0;
            if(flag == 1) {
                value = l+r+1;
            } else {
                value = l+r;
            }
            if(value >= 10) {
                flag = 1;
                value -= 10;
            } else {
                flag = 0;
            }
            len1--;
            len2--;
            sb.insert(0, value);
        }
        if(flag == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
