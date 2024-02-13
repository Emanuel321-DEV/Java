package exercise1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Menu {

    public static void main(String[] args) {
        int matrix[][] = new int[5][5];
        insertMatrix(matrix);

        MatrixThread l0 = new MatrixThread("0", matrix[0]);
        MatrixThread l1 = new MatrixThread("1", matrix[1]);
        MatrixThread l2 = new MatrixThread("2", matrix[2]);
        MatrixThread l3 = new MatrixThread("3", matrix[3]);
        MatrixThread l4 = new MatrixThread("4", matrix[4]);

        System.out.println("Starting threads");
        ExecutorService threadExecutor = Executors.newFixedThreadPool(5);

        threadExecutor.execute(l0);
        threadExecutor.execute(l1);
        threadExecutor.execute(l2);
        threadExecutor.execute(l3);
        threadExecutor.execute(l4);

        threadExecutor.shutdown();

        try {
            threadExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            System.out.println("Threads Finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

    private static void insertMatrix(int[][] matriz) {
        int valor = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = valor++;
            }
        }
    }

}
