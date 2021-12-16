public class MergeSort {


    //Compare the current index for each of the left and right arrays,
    //and add the lower of the two to our sorted array and increment the index
    //of the array you took from (left or right)
    public static void merge(double[] arr, double[] left, double[] right) {
        int ai = 0, li = 0, ri = 0;
        while (ai < arr.length) {
            if (li == left.length)
                arr[ai++] = right[ri++];
            else if (ri == right.length)
                arr[ai++] = left[li++];
            else if (left[li] < right[ri])
                arr[ai++] = left[li++];
            else
                arr[ai++] = right[ri++];
        }
    }


    //Recursively sort the left and right arrays and then merge them together
    //
    public static void sort(double [] arr){
        //Base case, if array is of size 1, it only has one element, so it has to be sorted
        if(arr.length > 1){
            double [] left = get_left(arr);
            double [] right = get_right(arr);

            sort(left);
            sort(right);
            merge(arr, left, right);
        }
    }

    //Helper function to find the right side of an array to prep sorting
    public static double [] get_right(double [] arr){
        int size = arr.length - arr.length/2;
        double [] right = new double[size];
        if(arr.length % 2 == 0) {
            for (int i = size; i < arr.length; i++) {
                right[i - size] = arr[i];
            }
        }
        else{
            for (int i = size - 1; i < arr.length; i++) {
                right[i - size + 1] = arr[i];
            }
        }
        return right;
    }

    //Helper function to find the left side of an array to prep sorting
    public static double [] get_left(double [] arr){
        int size = arr.length/2;
        double [] left = new double[(int) size];
        for (int i = 0; i < size; i++) {
            left[i] = arr[i];
        }
        return left;
    }


}
