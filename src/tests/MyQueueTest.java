package tests;

import entity.MyQueue;
import entity.MyLinkedList;

public class MyQueueTest {
    public static void starter() {
        MyQueue<String> queue = new MyQueue<>(new MyLinkedList<>());
        System.out.println("*********************************************");
        System.out.println("MyQueue Test");
        System.out.println("*********************************************");

        // Testing enqueue
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        System.out.println("\nAfter enqueueing 3 elements:");
        System.out.println("Peek: " + queue.peek());
        System.out.println("Size: " + queue.size());

        // Testing dequeue
        System.out.println("\nDequeued: " + queue.dequeue());
        System.out.println("After dequeue, peek: " + queue.peek());

        // Testing empty
        System.out.println("\nIs empty? " + queue.empty());
        queue.dequeue();
        queue.dequeue();
        System.out.println("After dequeuing all, is empty? " + queue.empty());
    }
}