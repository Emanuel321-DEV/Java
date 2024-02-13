package multithreading2;

import java.util.Random;

public class Lebre implements Runnable {

    private final String nome;
    private int nroDeSaltos = 0;
    private double distanciaPercorrida = 0;
    private VerificaLebre vl;

    public Lebre(String nome, VerificaLebre vl) {
        this.nome = nome;
        this.vl = vl;
    }

    @Override
    public void run() {
        while (distanciaPercorrida < 20) {
            nroDeSaltos++;
            Random aleatorio = new Random();
            int valor = aleatorio.nextInt(3) + 1;

            synchronized (vl) {
                distanciaPercorrida += valor;
                System.out.println("Lebre " + nome + " saltou " + valor + " metros \n"
                        + "     Distancia Percorrida " + distanciaPercorrida + " \n"
                        + "     Nro de Saltos " + nroDeSaltos);
                
                // 3 threads
                if (distanciaPercorrida >= 20) {
                    System.out.println("*********** " + nome + " Chegou ao destino! ***************");
                    vl.decThreads(); 
                }
                
                vl.verifica();
            
            }
        }

    }

}
