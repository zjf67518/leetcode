import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int[] nums = {2,4,2,45,5,86,87,3,36,24,1};
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i; j < len; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            int tmp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = tmp;
        }
        System.out.println(Arrays.toString(nums));
    }
}
