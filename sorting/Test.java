package ProgrammingI.sorting;

public class Test {
    public static void main(String[] args) {
        SortingAlgorithms myOrderStack = new SortingAlgorithms();
        int[] arr = {2,3,5,7,6,8,1,4};
        int[] duplicateArr = {2,2,4,6,5,5,1,3,2,5,4};
        System.out.println("Bubble Sort: ");
        System.out.println("Unordered -> " + printArrs(arr));
        System.out.println("  Ordered -> " + printArrs(myOrderStack.bubbleSort(arr)));
        System.out.println("Duplicates-> " + printArrs(myOrderStack.bubbleSort(duplicateArr)) );

        System.out.println("Counting Sort");
        System.out.println("   Ordered -> " + printArrs(myOrderStack.countingSort1(arr)));
        System.out.println("Duplicates -> " + printArrs(myOrderStack.countingSort1(duplicateArr)));

        System.out.println("Insertion Sort");
        System.out.println("   Ordered -> " + printArrs(myOrderStack.insertionSort(arr)));
        System.out.println("Duplicates -> " + printArrs(myOrderStack.insertionSort(duplicateArr)));

        BubbleSort sorter = new BubbleSort();
        int[] array = {1,7,3,2,4,9,5,1};
        int[] arr2 = {1,2,4,5,2,3};

        System.out.println("bubble Sort");
        System.out.println(printArrs(sorter.bubbleSort(arr)));

        System.out.println("Reversed bubble sort");
        System.out.println(printArrs(sorter.reversedBubbleSort(arr)));

        System.out.println("Enhanced Bubble Sort");
        System.out.println(printArrs(sorter.enhancedBubbleSort(arr2)));

        System.out.println("Enhanced reversed Bubble Sort");
        System.out.println(printArrs(sorter.enhancedReversedBubbleSort(arr2)));

        
    }

    public static String printArrs(int[] arr){
        String arrToShow = "[";
        for(int n : arr){
            arrToShow +=  " , " + n ;
        }
        arrToShow = arrToShow.replaceFirst(",", "") + " ]";

        return arrToShow;
    }
}
