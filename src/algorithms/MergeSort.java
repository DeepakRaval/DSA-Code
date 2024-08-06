package algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println("Merge sort demo");
        int [] array1 = {2,1,3};
        int [] array2 = {6,4,5};
//        printArray(array1);
        int [] combined = merge(array2, array1);
        printArray(combined);

        int[] results = mergeSort(combined);
        printArray(results);
    }


    public static void printArray(int [] input){
        for(int a : input){
            System.out.print(a+", ");
        }
        System.out.println("\n");
    }

    public static int [] mergeSort(int [] array){
        // base condition
        if(array.length == 1) return array;
        int mid = array.length / 2;
        printArray(array);
        int [] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
        System.out.println("---------------------");
        int [] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));

        return merge(left, right);
    }

    public static int[] merge(int [] array1, int [] array2){
        // create new array with length of two given array
        int [] combined = new int[array1.length + array2.length];
        int index = 0; // index for combined
        int i = 0; // index for array1
        int j = 0; // index for array2

        // insert element in array in such way that
        while(i < array1.length && j < array2.length){
            // smaller elements get inserted first
            if(array1[i] < array2[j]){
                combined[index] = array1[i];
                index ++;
                i++;
            }else{
                combined[index] = array2[j];
                index ++;
                j++;
            }
        }

        // adding remaining element to combined array
        while(i < array1.length){
            combined[index] = array1[i];
            index ++;
            i ++;
        }

        while(j < array2.length){
            combined[index] = array2[j];
            index ++;
            j ++;
        }

        return  combined;
    }

}
