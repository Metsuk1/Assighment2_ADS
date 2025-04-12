package tests;

import entity.MyLinkedList;
import java.util.Comparator;

public class MyLinkedListTest {
    public static void starter() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        System.out.println("*********************************************");
        System.out.println("MyLinkedList Test");
        System.out.println("**********************************************");

        // Testing basic operations
        list.add(100);
        list.add(200);
        list.add(300);
        System.out.println("\nAfter adding 100, 200, 300:");
        printList(list);

        // Testing add at index
        list.add(1, 150);
        System.out.println("\nAfter adding 150 at index 1:");
        printList(list);

        // Testing getFirst and getLast
        System.out.println("\nFirst element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        // Testing remove operations
        list.remove(2);
        System.out.println("\nAfter removing index 2:");
        printList(list);

        // Testing index operations
        System.out.println("\nIndex of 200: " + list.indexOf(200));
        System.out.println("Exists 150? " + list.exists(150));

        // Testing sort
        list.sort(Comparator.reverseOrder());
        System.out.println("\nAfter reverse sort:");
        printList(list);

        // Testing clear
        list.clear();
        System.out.println("\nAfter clear(), size: " + list.size());
    }

    private static void printList(MyLinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + ": " + list.get(i));
        }
    }
}