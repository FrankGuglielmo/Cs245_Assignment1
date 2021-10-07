import java.util.ArrayList;
import java.util.Arrays;

public class BetterMerge2 extends Main{


    public static void merge(double[] arr, double[] left, double[] right) {
        int ai = 0, li = 0, ri = 0;
        while (ai < ((left.length) + (right.length))) {
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

    public static ArrayList<Integer> findSortedRegions(double [] arr){
        ArrayList<Integer> sortedIndexes = new ArrayList<>();

        int startRegion = 0;
        int endRegion = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] < arr[i + 1]){
                endRegion++;
            }
            else{
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


    public static void sort(double [] arr){
        ArrayList<Integer> sortedRegions = findSortedRegions(arr);

        while(sortedRegions.size() > 2) {
            double [] left;
            double [] right;

            left = Arrays.copyOfRange(arr, sortedRegions.get(0), (sortedRegions.get(1) + 1));
            right = Arrays.copyOfRange(arr, sortedRegions.get(2), (sortedRegions.get(3) + 1));
            /*
            if(sortedRegions.get(0) != sortedRegions.get(1)) {
                left = Arrays.copyOfRange(arr, sortedRegions.get(0), sortedRegions.get(1));
            }
            else{
                left = Arrays.copyOfRange(arr, sortedRegions.get(0), (sortedRegions.get(1) + 1));
            }
            if(sortedRegions.get(2) != sortedRegions.get(3)) {
                right = Arrays.copyOfRange(arr, sortedRegions.get(2), sortedRegions.get(3));
            }
            else{
                right = Arrays.copyOfRange(arr, sortedRegions.get(2), (sortedRegions.get(3) + 1));
            }
*/
            merge(arr, left, right);

            sortedRegions.remove(2);
            sortedRegions.remove(1);
        }
    }
}
