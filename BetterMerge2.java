import java.util.ArrayList;
import java.util.Arrays;

public class BetterMerge2 extends Main{


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
