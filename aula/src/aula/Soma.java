package aula;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Soma extends Thread {

    private int a, b;
    private Ler l;
    private boolean flag;

    public Soma() {

    }

    public void setFlag(boolean value) {
        flag = value;
    }

    public void setL(Ler l) {
        this.l = l;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public void run() {
        try {
            sleep(3000);
            l.stopThread();
        } catch (InterruptedException ex) {
            Logger.getLogger(Soma.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
