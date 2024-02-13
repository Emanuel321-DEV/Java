package rmi;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class HelloWorldImpl extends UnicastRemoteObject implements IHelloWorld {
    
    public HelloWorldImpl() throws RemoteException {
        super();
    };
    
    public String hello(){
        return "===== Hello World! =====";
    }
}

