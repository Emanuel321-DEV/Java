package Binary;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String args[]) throws RemoteException, Exception {
        int port = 3336;
        try {
            System.out.println("Iniciando conexao com RMI... ");
            
            ITwosComplement obj = (ITwosComplement) Naming.lookup("rmi://localhost/" + port + "/complemento");
            int decimalNumber = 16;
            
            int[] binaryNumber = obj.decimalToBinary(decimalNumber);
            int[] twoComplement = obj.binaryToTwosComplement(binaryNumber);
            obj.printBinaryNumber(twoComplement);
            
            System.out.println("Deu certo");

        } catch(MalformedURLException | RemoteException | NotBoundException e){
            System.out.println("Deu errado " + e);
        }
        
    }
}
