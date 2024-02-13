package rmi;

import java.net.MalformedURLException;
import java.rmi.*;

public class Client {
    public static void main(String args[]) {
        int port = 3335;
        try {
            System.out.println("Iniciando conexao com RMI... ");
            IHelloWorld obj = (IHelloWorld) Naming.lookup("rmi://localhost/" + port + "/helloworld");
            String message = obj.hello();
            System.out.println(message);
            System.out.println("Deu certo");

        } catch(MalformedURLException | RemoteException | NotBoundException e){
            System.out.println("Deu errado " + e);
        }

    }
}
