import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class test2 {
    public static void main(String[] args) {
        int[]arr=new int[]{1, 6, 2, 3, 5, 4, 8, 7, 9};
        System.out.println(Arrays.toString(findKMax( arr,5)));
        System.out.println(Arrays.toString(findKMin( arr,5)));
    }
    public static int[] findKMax(int[] arr, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>(k);
        for(int i = 0; i < arr.length; i++) {
            if(que.size() < k) {
                que.add(arr[i]);
            } else if(que.peek() < arr[i]){
                que.poll();
                que.add(arr[i]);
            }
        }
        int[] res = new int[k];
        for(int i = k-1; i >= 0; i--) {
            res[i] = que.poll();
        }
        return res;
    }
    public static int[] findKMin(int[] arr, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0; i < arr.length; i++) {
            if(que.size() < k) {
                que.add(arr[i]);
            } else if(que.peek() > arr[i]){
                que.poll();
                que.add(arr[i]);
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = que.poll();
        }
        return res;
    }
}

