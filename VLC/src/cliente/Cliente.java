package cliente;

import interfaz.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Scanner;
public class Cliente {
	private static final String IP = "localhost"; // Puedes cambiar a localhost
	private static final int PUERTO = 5000; //Si cambias aquí el puerto, recuerda cambiarlo en el servidor
	
    public static void main(String[] args) throws RemoteException, NotBoundException {
    	
    	String[] peliculas;
    	int filmSeleccionada;
    	String film = "";
    	int eleccion;
    	
    	Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        Interfaz interfaz = (Interfaz) registry.lookup("Sistema de Video"); //Buscar en el registro...
    	
        Scanner sc = new Scanner(System.in);

        peliculas = interfaz.listarPeliculas();
        
    	
        System.out.println(Arrays.toString(peliculas));
        
        filmSeleccionada = Integer.parseInt(sc.nextLine()); 
        film = interfaz.seleccionPelicula(filmSeleccionada);
        System.out.println("Se esta viendo "+film);
        
        eleccion = Integer.parseInt(sc.nextLine());
        if(eleccion == -1) {
        	System.out.println("Gracias por Visitarnos");
        }
    	
   
    }
}