import tests.*;

import java.util.Scanner;

/**
 * you can test all data structure
 */
public class MyApp {
    public static void main(String[] args) {
        startInterface(new Scanner(System.in));
    }


    public static void startInterface(Scanner sc) {
        while(true) {
            System.out.println("*****************\n");
            System.out.println("\nChoose data structure to test:");
            System.out.println("[1] MyArrayList");
            System.out.println("[2] MyLinkedList");
            System.out.println("[3] MyStack");
            System.out.println("[4] MyQueue");
            System.out.println("[5] MyMinHeap");
            System.out.println("[0] Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            System.out.println();

            switch(choice) {
                case 1: MyArrayListTest.starter(); break;
                case 2: MyLinkedListTest.starter(); break;
                case 3: MyStackTest.starter(); break;
                case 4: MyQueueTest.starter(); break;
                case 5: MyMinHeapTest.starter(); break;
                case 0:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        }


    }

