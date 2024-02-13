package Binary;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMI {
    public static void main(String args[]) {
        int port = 3336;
        try {
            
            System.out.println("Iniciando...");
            String objName = "rmi://localhost/" + port + "/complemento";
            LocateRegistry.createRegistry(port);
            
            Binary objComplemento2 = new Binary();
            

            
            Naming.rebind(objName, objComplemento2);

            System.out.println("Deu certo...");

        } catch (RemoteException | MalformedURLException e) {
            System.out.println(e);
        }
    }
}
