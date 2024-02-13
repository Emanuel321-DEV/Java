package multithreading2;

public class VerificaLebre {
    private int nroThreads = 5;
    private int nroSaltosAtual = 0;

    // Se a lebre venceu então -1 thread
    synchronized public void decThreads() {
        nroSaltosAtual--; // Se a lebre venceu, seu salto nao entra na contagem
        nroThreads--; 
    }
    
    synchronized public void verifica() {
        nroSaltosAtual++;
        
        if (nroSaltosAtual == nroThreads) {
            nroSaltosAtual = 0;
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
