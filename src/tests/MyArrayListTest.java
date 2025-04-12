package tests;

import entity.MyArrayList;
import java.util.Comparator;

public class MyArrayListTest {
    public static void starter() {
        MyArrayList<Integer> list = new MyArrayList<>();
        System.out.println("**********************************************");
        System.out.println("MyArrayList Test");
        System.out.println("**********************************************");

        // Testing basic add and get
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("\nAfter adding 10, 20, 30:");
        printList(list);

        // Testing add at index
        list.add(1, 15);
        System.out.println("\nAfter adding 15 at index 1:");
        printList(list);

        // Testing set
        list.set(2, 25);
        System.out.println("\nAfter setting index 2 to 25:");
        printList(list);

        // Testing addFirst and addLast
        list.addFirst(5);
        list.addLast(35);
        System.out.println("\nAfter addFirst(5) and addLast(35):");
        printList(list);

        // Testing remove (middle element)
        list.remove(2);
        System.out.println("\nAfter removing index 2:");
        printList(list);

        // Testing removeFirst and removeLast
        list.removeFirst();
        System.out.println("\nAfter removeFirst():");
        printList(list);

        list.removeLast();
        System.out.println("\nAfter removeLast():");
        printList(list);

        // Testing index operations
        list.add(20);
        System.out.println("\nAfter adding another 20:");
        System.out.println("First index of 20: " + list.indexOf(20));
        System.out.println("Last index of 20: " + list.lastIndexOf(20));
        System.out.println("Exists 25? " + list.exists(25));
        System.out.println("Exists 99? " + list.exists(99));

        // Testing sort
        list.sort(Comparator.naturalOrder());
        System.out.println("\nAfter sorting:");
        printList(list);

        // Testing clear
        list.clear();
        System.out.println("\nAfter clear(), size: " + list.size());
        System.out.println("Is empty? " + list.isEmpty());
    }

    private static void printList(MyArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + ": " + list.get(i));
        }
    }
}