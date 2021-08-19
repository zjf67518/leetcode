import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class heapSort {
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int []arr){
        //1.构建大顶堆
        for(int i = arr.length/2-1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for(int i = arr.length-1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }
    public static void adjustHeap(int []arr,int i,int length){
        int tmp = arr[i];
        for(int k = 2*i+1; k < length; k = 2*k+1) {
            if(k+1<length && arr[k] < arr[k+1]) {
                k++;
            }
            if(arr[k] > tmp) {
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = tmp;
    }
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
