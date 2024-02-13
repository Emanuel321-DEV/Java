package Binary;
import java.rmi.*;

public interface ITwosComplement extends Remote {
    int[] decimalToBinary(int number) throws RemoteException;
    int[] binaryToTwosComplement(int[] binary) throws RemoteException;
    void printBinaryNumber(int[] number) throws RemoteException;
}
