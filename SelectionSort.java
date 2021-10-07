 public class SelectionSort extends Main{

    public static int findSmallest(double [] arr, int start){
        int smallest = start;
        for (int i = start + 1; i < arr.length; i++) {
            if(arr[i] < arr[smallest])
                smallest = i;
            }
            return smallest;
        }


    public static void sort(double [] arr){
        for (int i = 0; i < arr.length; i++) {
            swap(arr, i, findSmallest(arr, i));
        }
    }

    }

