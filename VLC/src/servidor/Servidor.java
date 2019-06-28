package servidor;

import interfaz.*;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Servidor {
	private static final int PUERTO = 5000; //Si cambias aquí el puerto, recuerda cambiarlo en el cliente
	private static final String [] peliculas = {"La chica de Alado","Rapidos Y Furiosos","Matrix3"};
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		
		
		

        Remote remote = UnicastRemoteObject.exportObject(new Interfaz(){
        	/*
				Sobrescribir opcionalmente los métodos que escribimos en la interfaz
        	*/
        	
        	      	
                                  
            @Override
            public String[] listarPeliculas() throws RemoteException{
            	return peliculas;
            };
            
            @Override
            public String seleccionPelicula(int indice) throws RemoteException{
            	String film = peliculas[indice];
            	System.out.println(film);
            	return  film;
            };
            
            
            
            @Override
            public boolean confirmacionPelicula() throws RemoteException{
            	return false;
            };
            
            
            
        }, 0);
        
        
        
        Registry registry = LocateRegistry.createRegistry(PUERTO);
       	System.out.println("Servidor escuchando en el puerto " + String.valueOf(PUERTO));
        registry.bind("Sistema de Video", remote); // Registrar Peliculas
    }
}