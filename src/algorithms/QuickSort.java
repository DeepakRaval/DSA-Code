package algorithms;

public class QuickSort {

    public static void main(String[] args) {
        System.out.println("Quick sort Demo");
        int [] array = {5,4,7,3,1,2,6};
        print(array);
        QuickSort qs = new QuickSort();
        qs.quickSort(array, 0, array.length);
        print(array);
    }

    // print array
    public static void print(int [] array){
        for( int i : array){
            System.out.print(i + ", ");
        }
        System.out.println("\n");
    }
    // swap
    public void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // pivot
    public int pivot(int [] array, int pivotIndex, int lastIndex){
        int swapIndex = pivotIndex;
        for(int i = pivotIndex + 1; i < array.length; i ++){
            if(array[i] < array[pivotIndex]){
                swapIndex ++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, swapIndex, pivotIndex);
        return swapIndex;
    }

    // Quick sort
    public void quickSort(int [] array, int firstIndex, int lastIndex){
        if(firstIndex < lastIndex){
            int pivotIndex = pivot(array, firstIndex, lastIndex);
            quickSort(array, 0, pivotIndex -1 );
            quickSort(array, pivotIndex + 1, lastIndex );
        }
    }

}
