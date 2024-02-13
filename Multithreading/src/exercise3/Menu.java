package exercise3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Menu {
    public static void main(String[] args) {
        int vector[] = new int[1000];
        insertVetor(vector);
        int number = 3;
        
        MatrixThread t1 = new MatrixThread(vector,   0, 99, number);
        MatrixThread t2 = new MatrixThread(vector, 100, 199, number);
        MatrixThread t3 = new MatrixThread(vector, 200, 299, number);
        MatrixThread t4 = new MatrixThread(vector, 300, 399, number);
        MatrixThread t5 = new MatrixThread(vector, 400, 499, number);
        MatrixThread t6 = new MatrixThread(vector, 500, 599, number);
        MatrixThread t7 = new MatrixThread(vector, 600, 699, number);
        MatrixThread t8 = new MatrixThread(vector, 700, 799, number);
        MatrixThread t9 = new MatrixThread(vector, 800, 899, number);
        MatrixThread t10 = new MatrixThread(vector,900, 999, number);
        
        ExecutorService threadExecutor = Executors.newFixedThreadPool(10);
        
        threadExecutor.execute(t1);
        threadExecutor.execute(t2);
        threadExecutor.execute(t3);
        threadExecutor.execute(t4);
        threadExecutor.execute(t5);
        threadExecutor.execute(t6);
        threadExecutor.execute(t7);
        threadExecutor.execute(t8);
        threadExecutor.execute(t9);
        threadExecutor.execute(t10);
        
        threadExecutor.shutdown();
        
        printVetor(vector);
    }
    
    private static void printVetor(int[] vector){
        for (int index = 0; index < vector.length; index++) {
            System.out.println(vector[index]);
        }
    }
    
    private static void insertVetor(int[] vector){
        for (int index = 0; index < 1000; index++) {
            vector[index] = index;
        }
    }
}
