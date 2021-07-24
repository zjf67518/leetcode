import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class test3 {
    public static void main(String[] args) {
        int res = splitArray(new int[]{45354,123,543,645,7612,3124,1235,43654}, 8);
        StringBuilder sb = new StringBuilder();
        System.out.println(res);
    }
    public static int splitArray(int[] nums, int m) {
        int len = nums.length;

        int[][] dp = new int[len + 1][m + 1];

        for (int i = 0; i <= len; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        int[][] sum = new int[len + 1][len + 1];

        for (int i = 0; i <= len; i++) {
            sum[i][0] = 0;
            sum[0][i] = 0;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    sum[i][j] = nums[i - 1];
                } else {
                    sum[i][j] = sum[i - 1][j] + nums[i - 1];
                }
            }
        }

        for (int i = 1; i <= len; i++) {
            dp[i][1] = sum[i][1];
        }

        for (int i = 2; i <= len; i++) {
            int temp = Math.min(i, m);
            for (int j = 2; j <= temp; j++) {
                dp[i][j] = 0;
                for (int k = j - 1; k < i; k++) {
                    dp[i][j] = Math.max(dp[i][j], Math.min(dp[k][j - 1], sum[i][k + 1]));
                }
            }
        }
        return dp[len][m];
    }
}
