package quicksortthread;

public class Menu {

    public static void main(String args[]) {

        Double[] list = {2.23, 2.00, 10.00, -1.00, -3.00, -4.75, -3.75};
        QuickSortThread<Double> qST = new QuickSortThread<>(list);
        qST.printList("Before Sorting", list);
        qST.start();
        try {
            qST.join();
            qST.printList("After Sorting", list);
        } catch(Exception ex){
            System.out.println("Error");
        }

    }

}
