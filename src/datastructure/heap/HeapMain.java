package datastructure.heap;

public class HeapMain {
    public static void main(String[] args) {
        System.out.println("This is Heap Demo");
        MyHeap mh = new MyHeap();
        mh.insert(45);
        mh.insert(23);
        mh.insert(45);
        mh.insert(78);
        mh.insert(92);
        mh.insert(11);

        System.out.println(mh.heap);
        mh.remove();
        System.out.println(mh.heap);
    }
}
