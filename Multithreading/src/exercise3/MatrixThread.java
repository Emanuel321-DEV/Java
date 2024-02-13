package exercise3;

public class MatrixThread implements Runnable {
    private final int[] vector;
    private final int init;
    private final int end;
    private final int value;
    
    public MatrixThread(int[] vector, int init, int end, int value) {
        this.vector = vector;
        this.init = init;
        this.end = end;
        this.value = value;
    }

    @Override
    public void run() {
        for (int index = init; index < end; index++) {
            vector[index] *= value;
        }
    }
    
}
