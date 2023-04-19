package ProgrammingI.co.edu.uptc.finding;

public class SearchingAlgortihms {

    public SearchingAlgortihms(){}

    public int linearSearch(int[] arr, int element) throws IllegalArgumentException{
        if((arr == null)){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == element) return i;
        }
        return -1;
    }

    public int binarySearch(int[] arr, int element, int top, int bot){
        if((arr == null)){
            throw new IllegalArgumentException();
        }
        int result = 0;
        int mid = 0;
        if(top >= bot){
            mid = ((top - bot)/2) + bot;
            if(arr[mid] == element){
                result = mid;
                return result;
            }
            if(element < arr[mid]) result = binarySearch(arr, element, mid-1, bot);
            if(element > arr[mid]) result = binarySearch(arr, element, top, mid+1);
        }else result = -1;

        return result;
    }
}
