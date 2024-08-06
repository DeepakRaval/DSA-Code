package datastructure.tree;

import java.util.ArrayList;

public class TreeMain {
    public static void main(String[] args) {
        System.out.println("Tree DS Demo");
        Tree t = new Tree();
//        t.insert(34);
//        t.insert(33);
//        t.insert(35);
//        t.insert(30);
//        t.insert(37);
//        t.rInsert(34);
//        t.rInsert(33);
//        t.rInsert(34);
//        t.rInsert(34);
//        t.rInsert(34);
//        System.out.println("root value : "+t.root.value);
//        System.out.println("root left value : "+t.root.left.value);
//        System.out.println("root right value : "+t.root.right.value);
//        System.out.println(t.contains(40));
//        System.out.println(t.rContain(40));

        t.insert(95);
        t.insert(88);
        t.insert(98);
        t.insert(75);
        t.insert(90);
        t.insert(91);
        t.insert(99);

//        t.delete(88);

        ArrayList<Integer> tree = t.BFSTree();
        System.out.println(tree);
        ArrayList<Integer> tree1 = t.DFSPreOrder();
        System.out.println("PreOrder : "+tree1);
        ArrayList<Integer> tree2 = t.DFSPostOrder();
        System.out.println("PostOrder : "+tree2);
        ArrayList<Integer> tree3 = t.DFSInOrder();
        System.out.println("InOrder : "+tree3);


    }
}
