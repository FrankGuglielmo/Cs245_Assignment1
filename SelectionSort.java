 public class SelectionSort extends Main{

    //returns smallest item in a given array
    public static int findSmallest(double [] arr, int start){
        int smallest = start; //Assume first item is smallest
        for (int i = start + 1; i < arr.length; i++) {
            if(arr[i] < arr[smallest])
                smallest = i;
            }
            return smallest;
        }


    public static void sort(double [] arr){
        for (int i = 0; i < arr.length; i++) {
            //Swap the smallest value in the array with the current index,
            //then increment the index and repeat process for the length of arr
            swap(arr, i, findSmallest(arr, i));
        }
    }

    }

