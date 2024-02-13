package exercise1;

public class MatrixThread implements Runnable {
    private final int[] vector;
    private final String lineNumber;
    
    public MatrixThread(String lineNumber, int[] vector) {
        this.lineNumber = lineNumber;
        this.vector = vector;
    }
    
    @Override
    public void run() {
        
        int sum = 0;
        for (int index = 0; index < vector.length; index++) {
            sum += vector[index];
        }
        System.out.println("Sum Of Line " + lineNumber + " = " + sum);
    }

}
