public class InsertionSort extends Main{

    public static void sort(double [] arr){


        for (int i = 1; i < arr.length; i++) {
            double temp = arr[i]; //start with second item in arr, because it's the first "unsorted" element in arr
            int j = i -1; //first item in arr, "sorted" element
            while (j >= 0 && arr[j] > temp){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;

        }
    }
}
