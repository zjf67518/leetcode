import java.util.HashMap;

public class A {
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] > len || nums[i] <= 0) {
                continue;
            }
            res[nums[i]-1] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return len+1;
    }

    public static void main(String[] args) {
        int res = firstMissingPositive(new int[] {3,4,-1,1});
        System.out.println(res);
    }
}
//  id 书 读者 标签
//  查询一个标签下，被打次数最多的10本书。
// select tag from table
// where book = '明日之后'
// group by tag
// order by sum(id) desc
// limit 10