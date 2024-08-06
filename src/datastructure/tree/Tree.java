package datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    Node root;

    class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }

    public void insert(int value){
        Node newNode = new Node(value);

        if(root == null){
            root = newNode;
            return;
        }

        Node temp = root;
        while(true){
            if(value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return;
                }
                temp = temp.left;
            }else{
                if(temp.right == null){
                    temp.right = newNode;
                    return;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value){
        Node temp = root;

        while(true){
            if(value < temp.value){
                if(temp.left.value == value){
                    return true;
                }
                temp = temp.left;
            }else{
                if(temp.right.value == value){
                    return true;
                }
                temp = temp.right;
            }
            return false;
        }
    }

    // recursive contains
    public boolean rContain(int value){
        return rContain(root, value);
    }

    private boolean rContain(Node root, int value){
        Node temp = root;
        if(temp == null) return  false;
        if(temp.value == value) return true;
        if(value < temp.value){
            return rContain(temp.left, value);
        }else{
            return rContain(temp.right, value);
        }
    }

    // recursive insert
    public void rInsert(int value){
         rInsert(root, value);
    }

    private void rInsert(Node current, int value){
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return;
        }

        if(current == null){
            return;
        }

        if(value < current.value){
            if(current.left == null){
                current.left = newNode;
                return;
            }
             rInsert(current.left, value);
        }else{
            if(current.right == null){
                current.right = newNode;
                return;
            }
            rInsert(current.right, value);
        }
    }


    private Node rInsert1(Node currentNode, int value){

        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value) {
            currentNode.left = rInsert1(currentNode.left, value);
        } else if(value > currentNode.value){
            currentNode.right = rInsert1(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert1(int value) {
        if (root == null) root = new Node(value);
        rInsert1(root, value);
    }

    // delete using recursion
    public void delete(int value){
        delete(root, value);
    }

    public Node delete(Node currentNode, int value){
        System.out.println("current node value : "+currentNode.value +" value to delete : "+value);
        if(currentNode == null) return  null;

        if(value < currentNode.value){
            currentNode.left = delete(currentNode.left, value);
        }else if(value > currentNode.value){
            currentNode.right = delete(currentNode.right, value);
        }else{
            if(currentNode.left == null && currentNode.right == null){
                return null;
            }else if(currentNode.left == null){
                currentNode =  currentNode.right;
            }else if(currentNode.right == null){
                currentNode = currentNode.left;
            }else{
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = delete(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }


    public int minValue(Node left){
        Node temp = left;
        while (temp.left != null){
            temp = temp.left;
        }
        return temp.value;
    }

    // Tree Traversing -- visiting each node
    // 1. Breath first tree -- > queue and arrayList
    public ArrayList<Integer> BFSTree(){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Node current = root;
        queue.add(root);
        while(queue.size() > 0){
            current = queue.remove();
            result.add(current.value);
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
        return result;
    }

    // Depth First Search -- method in method
    // Pre order
    public ArrayList<Integer> DFSPreOrder(){
        ArrayList<Integer> result = new ArrayList<>();
        class Traversal{
            public Traversal(Node currentNode){
                result.add(currentNode.value); // pre order
                if(currentNode.left != null){
                    new Traversal(currentNode.left);
                }
                if(currentNode.right != null){
                    new Traversal(currentNode.right);
                }
            }
        }
        new Traversal(root);
        return result;
    }

    // Post order
    public ArrayList<Integer> DFSPostOrder(){
        ArrayList<Integer> result = new ArrayList<>();
        class Traversal{
            public Traversal(Node currentNode){
                if(currentNode.left != null){
                    new Traversal(currentNode.left);
                }
                if(currentNode.right != null){
                    new Traversal(currentNode.right);
                }
                result.add(currentNode.value); // post order
            }
        }
        new Traversal(root);
        return result;
    }

    // In order
    public ArrayList<Integer> DFSInOrder(){
        ArrayList<Integer> result = new ArrayList<>();
        class Traversal{
            public Traversal(Node currentNode){
                if(currentNode.left != null){
                    new Traversal(currentNode.left);
                }
                result.add(currentNode.value); // In order
                if(currentNode.right != null){
                    new Traversal(currentNode.right);
                }
            }
        }
        new Traversal(root);
        return result;
    }



}
