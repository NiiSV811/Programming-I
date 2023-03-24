package ProgrammingI.sorting;

public class BubbleSort {
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

    public int[] reversedBubbleSort(int[] arr){
        int[] sorted = arr;
        int limit = sorted.length -1;
        for(int i = 0; i < limit; i++){
            for(int j = 0; j < limit - i; j++){
                if( sorted[j] < sorted[j+1]){
                    int temp = sorted[j+1];
                    sorted[j+1] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
        return sorted;
    }

    public int[] enhancedBubbleSort(int[] arr){
        boolean flag = false;
        int[] sorted = arr;
        int limit = sorted.length -1;
        for(int i = 0; i < limit; i++){
            flag = false;
            for(int j = 0; j < limit - i; j++){
                if( sorted[j] > sorted[j+1]){
                    flag = true;
                    int temp = sorted[j+1];
                    sorted[j+1] = sorted[j];
                    sorted[j] = temp;
                }
            }

            if(!flag) return sorted;
        }
        return sorted;
    }

    public int[] enhancedReversedBubbleSort(int[] arr){
        boolean flag = false;
        int[] sorted = arr;
        int limit = sorted.length -1;
        for(int i = 0; i < limit; i++){
            flag = false;
            for(int j = 0; j < limit - i; j++){
                if( sorted[j] < sorted[j+1]){
                    flag = true;
                    int temp = sorted[j+1];
                    sorted[j+1] = sorted[j];
                    sorted[j] = temp;
                }
            }

            if(!flag) return sorted;
        }
        return sorted;
    }
}
