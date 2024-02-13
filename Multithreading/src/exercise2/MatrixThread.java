package exercise2;

public class MatrixThread implements Runnable {
    private final int[] vector;
    private final String lineNumber;

    public MatrixThread(String lineNumber, int[] vector) {
        this.lineNumber = lineNumber;
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int index = 0; index < vector.length / 2; index++) {
            int temp = vector[index];
            vector[index] = vector[vector.length - 1 - index];
            vector[vector.length - 1 - index] = temp;
        }
    }

}
