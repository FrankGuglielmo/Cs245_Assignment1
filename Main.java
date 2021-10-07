public class Main{

    public static void swap(double [] arr, int i, int j){
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isSorted(double [] arr){
        boolean sorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i +1]){
                sorted = false;
            }
        }
        return sorted;
    }

    public static boolean betterMergeIsSorted(Double [] arr){
        boolean sorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i +1]){
                sorted = false;
            }
        }
        return sorted;
    }


    public static void main(String [] args){
        double[] arr = new double[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() * 100;
        }

        double [] insertionArray = new double [arr.length];
        double [] selectionArray = new double [arr.length];
        double [] bubbleArray = new double[arr.length];
        double [] mergeArray = new double[arr.length];
        double [] quickArray = new double[arr.length];
        Double [] betterMergeArray = new Double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            insertionArray[i] = arr[i];
            selectionArray[i] = arr[i];
            bubbleArray[i] = arr[i];
            mergeArray[i] = arr[i];
            quickArray[i] = arr[i];
            betterMergeArray[i] = arr[i];
        }


        long startTime = System.currentTimeMillis();
        InsertionSort.sort(insertionArray);
        long insertionSortEndTime = System.currentTimeMillis() - startTime;
        if(isSorted(insertionArray))
            System.out.println("Insertion Sort took " + insertionSortEndTime + " milliseconds for " + insertionArray.length + " values");
        else {
            System.out.println("Array was not fully insertion sorted");
            System.exit(0);
        }
        startTime = System.currentTimeMillis();
        SelectionSort.sort(selectionArray);
        long selectionSortEndTime = System.currentTimeMillis() - startTime;
        if(isSorted(selectionArray))
            System.out.println("Selection Sort took " + selectionSortEndTime + " milliseconds for " + selectionArray.length + " values");
        else {
            System.out.println("Array was not fully selection sorted");
            System.exit(0);
        }
        startTime = System.currentTimeMillis();
        BubbleSort.sort(bubbleArray);
        long bubbleSortEndTime = System.currentTimeMillis() - startTime;
        if(isSorted(bubbleArray))
            System.out.println("Bubble Sort took " + bubbleSortEndTime + " milliseconds for " + bubbleArray.length + " values");
        else {
            System.out.println("Array was not fully bubble sorted");
            System.exit(0);
        }
      startTime = System.currentTimeMillis();
        MergeSort.sort(mergeArray);
        long mergeSortEndTime = System.currentTimeMillis() - startTime;
        if(isSorted(mergeArray))
            System.out.println("Merge Sort took " + mergeSortEndTime + " milliseconds for " + mergeArray.length + " values");
        else {
            System.out.println("Array was not fully merge sorted");
            System.exit(0);
        }
      startTime = System.currentTimeMillis();
        QuickSort.sort(quickArray, 0, arr.length - 1);
        long quickSortEndTime = System.currentTimeMillis() - startTime;
        if(isSorted(quickArray))
            System.out.println("Quick Sort Sort took " + quickSortEndTime + " milliseconds for " + quickArray.length + " values");
        else {
            System.out.println("Array was not fully quick sorted");
            System.exit(0);
        }

      startTime = System.currentTimeMillis();
        betterMergeArray = BetterMerge.sort(arr);
        long betterMergeSortEndTime = System.currentTimeMillis() - startTime;
        if(betterMergeIsSorted(betterMergeArray))
            System.out.println("Better Merge Sort Sort took " + betterMergeSortEndTime + " milliseconds for " + betterMergeArray.length + " values");
        else {
            System.out.println("Array was not fully quick sorted");
            System.exit(0);
        }

    }
}
