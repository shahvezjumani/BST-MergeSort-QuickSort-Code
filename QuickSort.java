import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int [] arr = {4,2,5,1,0,-4,45,20,10};
        sort(arr,0, arr.length-1);
        display(arr);
    }
    public static void sort(int [] arr,int low,int high){
        if(low < high){
            int si = low;
            int ei = high;
            int mi = si + (ei -si)/2;
            int pivot = arr[mi];

            while(si<=ei){
                while (arr[si] < pivot){
                    si++;
                }
                while (arr[ei] > pivot){
                    ei--;
                }
                if(si <= ei){
                    int temp = arr[si];
                    arr[si++] = arr[ei];
                    arr[ei--] = temp;
                }
            }
            sort(arr,low,ei);
            sort(arr,si,high);
        }
    }
    public static void display(int [] arr){
        System.out.println(Arrays.toString(arr));
    }
}
