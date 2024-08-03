package datastructure.linkedlist;

public class MyLinkedList {

    Node head;
    Node tail;
    int lenght;

    public MyLinkedList(){}

    class Node {
        int value;
        Node nextNode;

        public Node(){};

        public Node(int value){
            this.value = value;
        }

    }

    // constructor to initialize the linked list
    public MyLinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.lenght = 1;
    }

    // method to print the linked list
    public void printMyLinkedList (){
        Node currentNode = head;

        while(currentNode != null){
            System.out.print(currentNode.value + " ,");
            currentNode = currentNode.nextNode;
        }
        System.out.println("lenght : "+lenght);

    }

    // append element at the end
    public void append(int value){
        Node newNodeToAdd = new Node(value);
        if(lenght == 0){
            head = tail = newNodeToAdd;
            lenght = 1;
        }else{
            tail.nextNode = newNodeToAdd;
            tail = newNodeToAdd;
            lenght ++;
        }
    }

    // prepend element at first
    public void prepend(int value){
        Node newNodeToAdd = new Node(value);
        newNodeToAdd.nextNode = head;
        head = newNodeToAdd;
        lenght ++;
    }

    // remove last element, return removed element
    public Node removeLast(){
        if(lenght == 0) return null;
        Node pre = head;
        Node temp = head;

        while(temp.nextNode != null){
            pre = temp;
            temp = temp.nextNode;
        }
        tail = pre;
        tail.nextNode = null;
        lenght --;

        if(lenght == 0){
            head = tail = null;
        }

        return temp;
    }

// remove first element, return removed element
    public Node removeFirst(){
        if(lenght == 0 ) return null;
        Node temp = head;
        head = head.nextNode;
        temp.nextNode = null;
        lenght --;
        if(lenght == 0 ){
            tail = null;
        }
        return temp;
    }

// get element by index, considering index starts from 0
public int get(int index) {
    if (lenght == 0 || index > lenght && index < 0) return -1;
    Node currentNode = head;
    int count = 0;
    while (currentNode != null) {
        if (count == index) {
            return currentNode.value;
        }
        count++;
        currentNode = currentNode.nextNode;
    }
    return 0;
}

// set element by index
    public void set(int index, int value){
        Node currentNode = head;
        int count = 0;
        while (currentNode != null) {
            if (count == index) {
                 currentNode.value = value;
            }
            count++;
            currentNode = currentNode.nextNode;
        }

    }

    // insert element at given index
    public void insert(int index, int value) {
        Node newNodeToAdd = new Node(value);
        if (lenght ==0){
            head = tail = newNodeToAdd;
            lenght ++;
        }
        if(index > lenght-1 || index < 0 ){
            return;
        }
        Node currentNode = head;
        Node temp;
        int count = 0;
        while (currentNode != null) {
            if (count == index) {
                temp = currentNode.nextNode;
                currentNode.nextNode = newNodeToAdd;
                newNodeToAdd.nextNode = temp;
                lenght++;
                return;
            }
            count++;
            currentNode = currentNode.nextNode;
        }

    }

    // remove element from given index
    public Node remove(int index){
        int count = 0;
        Node currentNode = head;
        Node temp;
        Node pre = null;
        Node next;
        while(currentNode != null){
            if(index-1 == count) pre = currentNode;
            if(index == count){
                temp = currentNode;
                next = currentNode.nextNode;
                if(pre!=null) pre.nextNode = next;
                lenght --;
                return temp;
            }
            count++;
            currentNode = currentNode.nextNode;
        }

        return null;
    }


    // reverse
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node before = null;
        Node after = temp.nextNode;
        for (int i = 0 ; i < lenght; i++){
            after = temp.nextNode;
            temp.nextNode = before;
            before = temp;
            temp = after;
        }
    }

// find midle of linked list -- > two pointer algorithm
    public Node findMidle(){

        Node temp = head;
        Node p1 = head; //slow - 1 step
        Node p2 = head; //fast - 2 step

        while(p2 != null && p2.nextNode != null){
            p1 = p1.nextNode;
            p2 = p2.nextNode.nextNode;
            temp = temp.nextNode;
        }

        return p1;
    }

    public Node findKthFromEnd(int k){
        Node slow = head;
        Node fast = head;

        for(int i = 0; i < k; i++){
            if(fast == null){
                return null;
            }
            fast = fast.nextNode;
        }

        while(fast != null){
            slow = slow.nextNode;
            fast = fast.nextNode;
        }
        return slow;
    }


    public void partitionList(int x){

        if(head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        Node prev1 = dummy1;
        Node prev2 = dummy2;

        Node current = head;

        while(current != null){
            if(current.value < x ){
                prev1.nextNode = current;
                prev1 = current;
            }else{
                prev2.nextNode = current;
                prev2 = current;
            }
            current = current.nextNode;
        }

        prev2.nextNode = null;
        prev1.nextNode = dummy2.nextNode;

        head = dummy1.nextNode;

        return;
    }


    public void partitionListMy(int x){

        if(head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        Node before = dummy1;
        Node after = dummy2;

        Node current = head;

        while(current != null){
            if(current.value < x ){
                before.nextNode = current;
                before = current;
            }else{
                after.nextNode = current;
                after = current;
            }
            current = current.nextNode;
        }
        after.nextNode = null;

        before.nextNode = dummy2.nextNode;

        head = dummy1.nextNode;

        return;
    }


}
