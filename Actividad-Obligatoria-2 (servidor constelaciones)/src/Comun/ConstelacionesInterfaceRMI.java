package Comun;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ConstelacionesInterfaceRMI extends Remote {
    String buscarConstelacion(String nombre) throws RemoteException;
    String buscarConstelacionesCercanas(String nombre) throws RemoteException;
    List<String> obtenerListaConstelaciones() throws RemoteException;
}