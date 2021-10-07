import java.util.ArrayList;
import java.util.Arrays;

public class BetterMerge extends Main{

    public static Double[] merge(Double[] left, Double[] right) {

        Double [] arr = new Double[left.length + right.length];
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
        return arr;
    }


    public static ArrayList<Double[]> findSortedRegions(double [] arr){
        ArrayList<Double[]> arrList = new ArrayList<>();

        int startRegion = 0;
        int endRegion = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] < arr[i + 1]){
                endRegion++;
            }
            else{
                //tempArr = Arrays.copyOfRange(arr, startRegion, endRegion);
                Double [] tempArr = new Double[endRegion - startRegion + 1];
                int tempIndex = 0;
                for (int j = startRegion; j <= endRegion; j++) {
                    tempArr[tempIndex] = arr[j];
                    tempIndex++;
                }
                arrList.add(tempArr);
                startRegion = i + 1;
                endRegion = startRegion;
            }
        }
        Double [] tempArr2 = new Double[endRegion - startRegion + 1];
        int tempIndex2 = 0;
        for (int i = startRegion; i <= endRegion; i++) {
            tempArr2[tempIndex2] = arr[i];
            tempIndex2++;
        }
        arrList.add(tempArr2);
        return arrList;
    }


    public static Double[] sort(double [] arr){
        ArrayList<Double[]> sortedRegions = findSortedRegions(arr);

        while(sortedRegions.size() > 1){
            Double [] left = sortedRegions.get(0);
            Double [] right = sortedRegions.get(1);

            Double [] sorted = merge(left, right);

            sortedRegions.remove(1);
            sortedRegions.remove(0);

            sortedRegions.add(0, sorted);
        }
        return sortedRegions.get(0);
    }

}
