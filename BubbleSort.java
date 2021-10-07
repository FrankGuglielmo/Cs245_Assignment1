public class BubbleSort extends Main{

    public static void sort(double [] arr){
        boolean swapped = true;

        for (int i = 0; swapped && i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
        }
    }

}
