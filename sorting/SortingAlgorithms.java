package ProgrammingI.sorting;
import ProgrammingI.mathutil.model.MathUtil;

public class SortingAlgorithms {
    private MathUtil math;
    public SortingAlgorithms(){
        this.math = new MathUtil();
    }

    public int[] bubbleSort(int[] arr){
        int[] sorted = arr;
        int limit = sorted.length -1;
        for(int i = 0; i < limit; i++){
            for(int j = 0; j < limit - i; j++){
                if( sorted[j] > sorted[j+1]){
                    int temp = sorted[j+1];
                    sorted[j+1] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
        return sorted;
    }

    public int[] countingSort1(int[] arr){
        int maxValue = this.math.biggestNumArray(arr);
        int[] countArr = this.math.fillArr(maxValue + 1, 0);
        int[] outputArr = new int[arr.length + 1];
        for(int i = 1; i < countArr.length; i++){
            countArr[i] = this.math.countElementArray(i, arr);
        }

        for (int i = 1; i < countArr.length; i++){
            if(i == 1){
                countArr[i] += countArr[i-1];
                continue;
            }
            countArr[i] = countArr[i-1] + countArr[i-2];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            outputArr[countArr[arr[i]] - 1] = arr[i];
            countArr[arr[i]]--;
        }

        return outputArr;
    }

    public int[] countingSort(int[] array){
        int size = array.length;
        int[] output = new int[size + 1];

        // Find the largest element of the array
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        // Initialize count array with all zeros.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            count[array[i]]++;
        }

        // Store the cummulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
        return array;
    }
}
