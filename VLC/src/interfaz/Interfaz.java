package interfaz;


import java.rmi.Remote;
import java.rmi.RemoteException;

/*
	Declarar firma de métodos que serán sobrescritos
*/
public interface Interfaz extends Remote {
    
	String[] listarPeliculas() throws RemoteException;
	String seleccionPelicula(int indice) throws RemoteException;
	boolean confirmacionPelicula() throws RemoteException;

}