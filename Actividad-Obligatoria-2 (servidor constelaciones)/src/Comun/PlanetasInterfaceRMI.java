package Comun;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

// Se usa tanto en el cliente como en el servidor
public interface PlanetasInterfaceRMI extends Remote {
    String buscarPlaneta(String nombre) throws RemoteException;
    List<String> obtenerListaPlanetas() throws RemoteException;
}