package ProgrammingI.co.edu.uptc.sortingworkshop.model;

import ProgrammingI.co.edu.uptc.workshop.vehicles.model.Vehicle;

public class VehicleSort {

    public VehicleSort(){}

    public boolean comparator(Vehicle firstVehicle, Vehicle secondVehicle,String compareMode){
        boolean comparison = false;
        switch (compareMode){
            case "placas" -> { comparison = firstVehicle.getPlate().compareToIgnoreCase(secondVehicle.getPlate()) > 0; }
            case "modelo" -> { comparison = firstVehicle.getModel().compareToIgnoreCase(secondVehicle.getModel()) > 0; }
            case "puertas" -> { comparison = firstVehicle.getDoors() > secondVehicle.getDoors(); }
            case "ruedas" -> { comparison = firstVehicle.getWheels() > secondVehicle.getWheels(); }
            case "combustible" -> { comparison = firstVehicle.getFullFuel() > secondVehicle.getFullFuel(); }
        }
        return comparison;
    }

    public void vehicleBubbleSort(Vehicle[] vehiclesSorted, String comparatorMode){
        int size = vehiclesSorted.length - 1;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size - i; j++){
                if( comparator(vehiclesSorted[j],vehiclesSorted[j+1],comparatorMode )){
                    Vehicle temp = vehiclesSorted[j+1];
                    vehiclesSorted[j+1] = vehiclesSorted[j];
                    vehiclesSorted[j] = temp;
                }
            }
        }
    }

    public void vehicleSelectionSort(Vehicle[] vehiclesSorted, String comparatorMode){
        int size = vehiclesSorted.length - 1;
        int minValue = 0;
        for(int i = 0; i < size; i++){
            minValue = i;
            for (int j = i+1; j <= size; j++ ){
                if( comparator(vehiclesSorted[minValue],vehiclesSorted[j], comparatorMode )){
                    minValue = j;
                }
            }
            Vehicle temp = vehiclesSorted[i];
            vehiclesSorted[i] = vehiclesSorted[minValue];
            vehiclesSorted[minValue] = temp;

        }
    }

    public void vehicleInsertionSort(Vehicle[] vehiclesSorted, String comparatorMode){
        int size = vehiclesSorted.length;
        int j = 0;
        for(int i = 1; i < size; i++){
            Vehicle keyVehicle = vehiclesSorted[i];
            j = i - 1;
            while (j >= 0 && comparator(vehiclesSorted[j],keyVehicle, comparatorMode)){
                vehiclesSorted[j+1] = vehiclesSorted[j];
                j--;
            }

            vehiclesSorted[j+1] = keyVehicle;
        }
    }

    public void vehicleMergeSort(Vehicle[] vehicles,int leftLimit, int rightLimit, String comparatorMode){

        if(leftLimit < rightLimit){
            int mid = (leftLimit + rightLimit)/2;

            vehicleMergeSort(vehicles, leftLimit, mid, comparatorMode);
            vehicleMergeSort(vehicles, mid + 1, rightLimit, comparatorMode);

            merge(vehicles, leftLimit, mid, rightLimit, comparatorMode);
        }
    }

    public void merge(Vehicle[] vehicleArr, int leftLimit, int mid,int rightLimit, String comparatorMode){

        int sizeLeft = mid - leftLimit + 1;
        int sizeRight = rightLimit - mid;

        Vehicle[] leftArr = new Vehicle[sizeLeft];
        Vehicle[] rightArr = new Vehicle[sizeRight];

        //Filling Left Arr
        for (int i = 0; i < sizeLeft; i++){
            leftArr[i] = vehicleArr[leftLimit + i];
        }

        //Filling Right Arr
        for (int j = 0; j < sizeRight; j++){
            rightArr[j] = vehicleArr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = leftLimit;

        while (i < sizeLeft && j < sizeRight){
            if(comparator(rightArr[j],leftArr[i],comparatorMode)){
                vehicleArr[k] = leftArr[i];
                i++;
            }else {
                vehicleArr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < sizeLeft) {
            vehicleArr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < sizeRight) {
            vehicleArr[k] = rightArr[j];
            j++;
            k++;
        }
    }


    public int partition(Vehicle[] arr, int low, int high, String compareMode) {
        Vehicle pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (comparator(pivot, arr[j],compareMode )) {
                i++;
                Vehicle temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Vehicle temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return (i + 1);
    }

    public void vehicleQuickSort(Vehicle[] vehicles, int low, int high, String comparatorMode){
        if (low < high) {

            int pi = partition(vehicles, low, high, comparatorMode);

            vehicleQuickSort(vehicles, low, pi - 1, comparatorMode);
            vehicleQuickSort(vehicles, pi + 1, high, comparatorMode);
        }
    }

    public void vehicleShellSort(Vehicle[] arr, String compareMode)
    {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                Vehicle temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found  arr[j - gap] > temp
                int j;
                for (j = i; j >= gap && comparator(arr[j-gap],temp, compareMode); j -= gap)
                    arr[j] = arr[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
    }


}
