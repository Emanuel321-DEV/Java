package exercise4;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Menu {

    public static void main(String args[]) {

        ExecutorService threadExecutor = Executors.newFixedThreadPool(12);
        
        Equations equation = new Equations();
        
        ArrayList<double[]> equations = new ArrayList<>();
        equations.add(new double[]{-1, 4, -3});
        equations.add(new double[]{-1, 50, 15000});
        equations.add(new double[]{6, -4, 5});
        equations.add(new double[]{1, 0, -9});
        equations.add(new double[]{3, 3, 0});
        equations.add(new double[]{2, 3, 5});
        equations.add(new double[]{-1, 2, -4});
        equations.add(new double[]{1, -5, 6});
        equations.add(new double[]{1, -4, 3});
        equations.add(new double[]{-1, 2, 4});
        equations.add(new double[]{-3, 0, 0});
        equations.add(new double[]{4, -10, 0});

        for (double[] eq : equations) {
            Equations.root(eq[0], eq[1], eq[2]);
            threadExecutor.execute(equation);
        }

        threadExecutor.shutdown();
    }
}
