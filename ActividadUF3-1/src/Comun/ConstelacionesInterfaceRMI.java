package Comun;

import java.rmi.Remote;
import java.rmi.RemoteException;

//se usa tanto en el cliente como en el servidor
public interface ConstelacionesInterfaceRMI extends Remote {
    String buscarConstelacion(String nombre) throws RemoteException;
}
