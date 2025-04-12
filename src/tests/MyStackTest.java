package tests;

import entity.MyStack;
import entity.MyArrayList;

public class MyStackTest {
    public static void starter() {
        MyStack<Integer> stack = new MyStack<>(new MyArrayList<>());
        System.out.println("*********************************************");
        System.out.println("MyStack Test");
        System.out.println("*********************************************");

        // Testing push
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("\nAfter pushing 10, 20, 30:");
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());

        // Testing pop
        System.out.println("\nPopped: " + stack.pop());
        System.out.println("After pop, peek: " + stack.peek());

        // Testing isEmpty
        System.out.println("\nIs empty? " + stack.isEmpty());
        stack.pop();
        stack.pop();
        System.out.println("After popping all, is empty? " + stack.isEmpty());
    }
}