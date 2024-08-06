package algorithms;

public class BasicSortMain {

    public static void main(String[] args) {
        System.out.println("Basic Sorts Algorithm");
        int[] arr = {2, 4, 3, 5, 1};
        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);
        print(arr);

    }

    public static void print(int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] +  ", ");
        }
        System.out.print("\n");
    }

    // Bubble Sort
    public static void bubbleSort(int[] array){
        for(int i = array.length-1 ; i > 0 ; i --){
            for(int j = 0; j < array.length-1; j ++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    // selection sort
    public static void selectionSort(int[] array){
        for(int i = 0; i < array.length ; i ++){
            int minIndex = i;
            for(int j = i +1; j < array.length; j ++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    // insertion sort
    public static void insertionSort(int[] array){
        for(int i = 1; i < array.length ; i ++){
            int temp = array[i];
            int j = i -1;
            while(j > -1 && array[j] > temp){
                array[j+1] = array[j];
                array[j] = temp;
                j --;
            }

        }
    }



}
