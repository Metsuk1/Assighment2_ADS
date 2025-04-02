import lists.MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();

        myList.add(1);
        myList.add(2);
        myList.add(3);

        print(myList);


        System.out.println("----------------------------------");

        myList.remove(1);

        print(myList);

    }

    public static void print(MyArrayList<Integer> myList) {
        for(int i = 0;i < myList.getSize();i++){
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();
    }

}