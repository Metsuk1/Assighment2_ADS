package tests;

import entity.MyMinHeap;
import entity.MyArrayList;

public class MyMinHeapTest {
    public static void starter() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        MyMinHeap<Integer> heap = new MyMinHeap<>(arrayList);
        System.out.println("*********************************************");
        System.out.println("MyMinHeap Test");
        System.out.println("*********************************************");

        // Testing insert and getMin
        heap.insert(30);
        heap.insert(10);
        heap.insert(20);
        System.out.println("\nAfter inserting 30, 10, 20:");
        System.out.println("Current min: " + heap.getMin());
        System.out.println("Size: " + heap.size());

        // Testing extractMin
        System.out.println("\nExtracted min: " + heap.extractMin());
        System.out.println("New min: " + heap.getMin());

        // Testing empty
        System.out.println("\nIs empty? " + heap.empty());
        heap.extractMin();
        heap.extractMin();
        System.out.println("After extracting all, is empty? " + heap.empty());
    }
}