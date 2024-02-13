package rmi;
import java.rmi.*;

public interface IHelloWorld extends Remote {
    /**
     *
     * @return
     * @throws RemoteException
    */
    public String hello() throws RemoteException;
}
