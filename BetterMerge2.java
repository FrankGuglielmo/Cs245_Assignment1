import java.util.ArrayList;
import java.util.Arrays;

public class BetterMerge2 extends Main{


    //Similar to MergeSort, but faster since we don't always have to assume left and right arrays
    //are only one element big. Still is possible, but shaves a lot of time off since the program
    //doesn't split every single element up like the regular MergeSort
    public static void merge(double[] arr, double[] left, double[] right, int startingIndex) {
        int ai = 0, li = 0, ri = 0;
        while (ai < ((left.length) + (right.length))) {
            if (li == left.length) {
                arr[ai + startingIndex] = right[ri++];
                ai++;
            }
            else if (ri == right.length) {
                arr[ai + startingIndex] = left[li++];
                ai++;
            }
            else if (left[li] < right[ri]) {
                arr[ai + startingIndex] = left[li++];
                ai++;
            }
            else {
                arr[ai + startingIndex] = right[ri++];
                ai++;
            }
        }
    }

    //Given an array, mark down the indexes of where each sorted region starts and ends.
    //For example, an array like
    // double [] arr = {0, 1, 2, 3, 1, 7, 10, 2, 5}
    //would return an ArrayList of Integers such as
    // [0, 3, 4, 6, 7, 8]
    public static ArrayList<Integer> findSortedRegions(double [] arr){
        ArrayList<Integer> sortedIndexes = new ArrayList<>();

        //Initialize start and end regions as 0, the index of the first element in arr
        int startRegion = 0;
        int endRegion = 0;

        //As long as the value next to the current index is greater, increment endRegion
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] < arr[i + 1]){
                endRegion++;
            }
            else{
                //Marks the end of the sorted region, add the values to the ArrayList
                //and update the start and end regions
                sortedIndexes.add(startRegion);
                sortedIndexes.add(endRegion);

                startRegion = i + 1;
                endRegion = startRegion;
            }
        }
        sortedIndexes.add(startRegion);
        sortedIndexes.add(endRegion);
        return sortedIndexes;
    }

    //Same principle as MergeSort, get the left and right arrays using Arrays.copyOfRange()
    //function with the indexes stored in sortedRegions and apply a merge function on them.
    public static void sort(double [] arr){
        ArrayList<Integer> sortedRegions = findSortedRegions(arr);

        double [] left;
        double [] right;
        while(sortedRegions.size() > 2) {
            int i = 0;
            while (sortedRegions.size() > 2) {
                int indexes = sortedRegions.size();
                if (i + 2 > sortedRegions.size() - 1)
                    break;
                else {
                    left = Arrays.copyOfRange(arr, sortedRegions.get(i), (sortedRegions.get(i + 1) + 1));
                    right = Arrays.copyOfRange(arr, sortedRegions.get(i + 2), (sortedRegions.get(i + 3) + 1));


                    merge(arr, left, right, sortedRegions.get(i));
                    sortedRegions.remove(i + 2);
                    sortedRegions.remove(i + 1);

                    i += 2;
                }

            }
        }
    }


}
