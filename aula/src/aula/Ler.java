package aula;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ler extends Thread{
    private Soma s;
    
    public Ler(Soma s){
        this.s = s;
    }
    
    public void stopThread(){
        try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run(){
        while(true){
            System.out.println("Hello World! ");
        }
    }
    
}
