package exercise2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Menu {
    
    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        insertMatrix(matrix);
        
        System.out.println("Matriz Original: ");
        printMatrix(matrix);

        MatrixThread l0 = new MatrixThread("0", matrix[0]);
        MatrixThread l1 = new MatrixThread("1", matrix[1]);
        MatrixThread l2 = new MatrixThread("2", matrix[2]);
        
        ExecutorService threadExecutor = Executors.newFixedThreadPool(3);
        
        threadExecutor.execute(l0);
        threadExecutor.execute(l1);
        threadExecutor.execute(l2);

        threadExecutor.shutdown();

        System.out.println("Matriz Invertida: ");
        printMatrix(matrix);
        
    }

    private static void insertMatrix(int[][] matrix) {
        int valor = 1;
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = valor++;
            }
        }
    }
    
    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println("");
    }
    
}
