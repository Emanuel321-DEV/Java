package rmi;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class RMI {
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando...");

            HelloWorldImpl objHelloWorld = new HelloWorldImpl();
            int port = 3335;

            String objName = "rmi://localhost/" + port + "/helloworld";
            LocateRegistry.createRegistry(port);
            Naming.rebind(objName, objHelloWorld);

            System.out.println("Deu certo...");

        } catch (RemoteException | MalformedURLException e) {
            System.out.println(e);
        }
    }
}
