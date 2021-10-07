public class MergeSort {


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


    public static void sort(double [] arr){
        if(arr.length > 1){
            double [] left = get_left(arr);
            double [] right = get_right(arr);

            sort(left);
            sort(right);
            merge(arr, left, right);
        }
    }

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

    public static double [] get_left(double [] arr){
        int size = arr.length/2;
        double [] left = new double[(int) size];
        for (int i = 0; i < size; i++) {
            left[i] = arr[i];
        }
        return left;
    }


}
