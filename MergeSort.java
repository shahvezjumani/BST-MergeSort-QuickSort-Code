import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr = {4,2,5,1,0,-4,45,20,10};
        sort(arr,0, arr.length-1);
        display(arr);
    }
    public static void sort(int [] arr,int si,int ei){
        if(si < ei){
            int mi = si + (ei - si)/2;
            sort(arr,si,mi);
            sort(arr,mi+1,ei);
            merge(arr,si,mi,ei);
        }
    }
    public static void merge(int [] arr,int si,int mi,int ei){
        int size1 = mi - si + 1;
        int size2 = ei - mi;
        int [] L = new int[size1];
        int [] R = new int[size2];

        for(int i=0;i< L.length;i++){
            L[i] = arr[si+i];
        }
        for(int i=0;i< R.length;i++){
            R[i] = arr[mi+1+i];
        }
        int i=0,j=0;
        int k = si;

        while (i < L.length && j < R.length){
            if(L[i] < R[j]){
                arr[k++] = L[i++];
            } else if(L[i] > R[j]){
                arr[k++] = R[j++];
            }
        }
        while(i < L.length){
            arr[k++] = L[i++];
        }
        while(j < R.length){
            arr[k++] = R[j++];
        }
    }
    public static void display(int [] arr){
        System.out.println(Arrays.toString(arr));
    }
}
