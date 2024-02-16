package exerc11;

public class BubbleSort {

    static int[] sort(int[] arr) {
        int n = arr.length;
        int temp = 0;
            for(int i=0; i < n; i++){
                for(int x=1; x < (n-i); x++){
                    if(arr[x-1] > arr[x]){
                        temp = arr[x-1];
                        arr[x-1] = arr[x];
                        arr[x] = temp;
                    }
                }
            }
        return arr;
    }
}
