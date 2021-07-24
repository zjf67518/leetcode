import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] nums = {2,4,2,45,5,86,87,3,36,24,1};
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int flag = 0;
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println(Arrays.toString(nums));
                return;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
