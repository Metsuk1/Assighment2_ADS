import lists.MyArrayList;
import lists.MyLinkedList;
import lists.interfaces.MyList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        print(list);


        System.out.println("----------------------------------");

        list2.add(1);
        list2.add(2);
        list2.add(3);

        print(list2);

        print(list2);
        System.out.println(list2.exists(7));

    }

    public static <T> void print(MyList<T> list) {
        for(int i = 0;i < list.size();i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

}