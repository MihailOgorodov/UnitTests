package org.example.HW6;

public class Main {
    public static void main(String[] args) {
        /*
        проверка работоспособности методов
        int[] array = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.stream(array).average());

        MyList myList = new MyList(new int[]{1, 2, 3, 4, 5});
        myList.averageArray(array);
        System.out.println(myList.averageArray(array));
        */

        Controller controller = new Controller();

        int[] array1 = controller.createArray();
        double averageArray1 = controller.averageArray(array1);

        int[] array2 = controller.createArray();
        double averageArray2 = controller.averageArray(array2);

        controller.compareArray(averageArray1, averageArray2);
    }
}