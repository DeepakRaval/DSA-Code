package datastructure.linkedlist;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MyLinkedList ml = new MyLinkedList(111);
//        ml.printMyLinkedList();

        ml.append(1234);
        ml.append(234);
        ml.append(454);

//        ml.printMyLinkedList();

        ml.prepend(999);

//        ml.printMyLinkedList();

        MyLinkedList.Node returned = ml.removeLast();
        System.out.println("Last removed : "+ returned.value);
//        ml.printMyLinkedList();

//        ml.append(222);
//        ml.append(111);

        MyLinkedList.Node firstRemoved  = ml.removeFirst();
        System.out.println("First removed : " +firstRemoved.value);
//        ml.printMyLinkedList();

        ml.append(1234);
        ml.append(234);
        ml.append(454);
        ml.append(112);
        ml.append(100);

//        ml.printMyLinkedList();
        int valueReturned = ml.get(5);
//        System.out.println("value : "+valueReturned);

        ml.set(3, 1221);
//        ml.printMyLinkedList();

        ml.insert(3, 8055);
//        ml.printMyLinkedList();

        MyLinkedList.Node removedByIndex = ml.remove(5);
//        ml.printMyLinkedList();

//        ml.reverse();
//        ml.append(454);
//        ml.append(234);
//        ml.append(6443);
        ml.printMyLinkedList();
        int value = ml.findMidle().value;
        System.out.println("middle element : "+value);

        MyLinkedList.Node kthFromEnd = ml.findKthFromEnd(4);
        System.out.println("k th element : "+kthFromEnd.value);

//        ml.partitionList(234);
        ml.printMyLinkedList();

        ml.partitionListMy(234);
        ml.printMyLinkedList();
    }
}