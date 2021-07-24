import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {2,4,2,45,5,86,87,3,36,24,1};
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int preIndex = i-1;
            int cur = nums[i];
            while(preIndex >= 0 && cur < nums[preIndex]) {
                nums[preIndex+1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex+1] = cur;
        }
        System.out.println(Arrays.toString(nums));
    }
}
