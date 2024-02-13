package multithreading2;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Multithreading2 {

    public static void main(String[] args) {

        ArrayList<Lebre> lebres = new ArrayList<>();
        
        VerificaLebre vl = new VerificaLebre();
        
        Lebre lebre1 = new Lebre("Lebre 1", vl);
        Lebre lebre2 = new Lebre("Lebre 2", vl);
        Lebre lebre3 = new Lebre("Lebre 3", vl);
        Lebre lebre4 = new Lebre("Lebre 4", vl);
        Lebre lebre5 = new Lebre("Lebre 5", vl);

        ExecutorService threadExecutor = Executors.newFixedThreadPool(5);

        threadExecutor.execute(lebre1);
        threadExecutor.execute(lebre2);
        threadExecutor.execute(lebre3);
        threadExecutor.execute(lebre4);
        threadExecutor.execute(lebre5);

        threadExecutor.shutdown();
    }

}
