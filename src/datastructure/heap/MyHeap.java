package datastructure.heap;

import java.util.ArrayList;
import java.util.List;

public class MyHeap {

    // Heap --> stored in form of array list
    List<Integer> heap = new ArrayList<>();

    // Helper methods
    // parent index
    public int parentIndex(int index){
        return (index - 1) / 2;
    }

    // left child index
    public int leftChild(int index){
        return 2 * index + 1;
    }

    // right child index
    public int rightChild(int index){
        return 2 * index + 2;
    }

    // swapping
    public void swap(int curentIndex, int parentIndex){
        int temp = heap.get(curentIndex);
        heap.set(curentIndex, heap.get(parentIndex));
        heap.set(parentIndex, temp);
    }

    // Insert -- > adding element to array list and bring it to top if it is greater
    public void insert(int value){
        heap.add(value);
        int currentIndex = heap.size() -1;
        while(currentIndex > 0 && heap.get(currentIndex) > heap.get(parentIndex(currentIndex))){
            swap(currentIndex, parentIndex(currentIndex));
            currentIndex = parentIndex(currentIndex);
        }
    }

    public void sinkDown(int index){
        int maxIndex = index;
        while (true){
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if(leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)){
                maxIndex = leftIndex;
            }

            if(rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)){
                maxIndex = rightIndex;
            }

            if(maxIndex != index){
                swap(maxIndex, index);
                index = maxIndex;
            }else{
                return;
            }
        }

    }

    // remove --> remove the top element
    public Integer remove(){
        if(heap.size() == 0){
            return  null;
        }

        if(heap.size() == 1){
            return  heap.remove(0);
        }

        int maxIndex = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);
        return  maxIndex;
    }

}
