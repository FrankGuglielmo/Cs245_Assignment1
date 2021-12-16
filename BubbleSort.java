public class BubbleSort extends Main{

    public static void sort(double [] arr){
        boolean swapped = true;

        for (int i = 0; swapped && i < arr.length - 1; i++) {
            //Assume we don't have to swap initially, so if we go the entire
            // array without doing a swap just break
            swapped = false;
            //Starting at the beginning, check to see if the index
            //we're at is larger than the next one. If it is, set swapped
            //to true and keep swapping as long as the condition is true.
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
        }
    }

}
