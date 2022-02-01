package CentralRecaudacion;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorRecaudador {
	
	private ServerSocket servidor;
	
	private Socket cliente;
	
	private DataInputStream entrada;
	
	private DataOutputStream salida;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Instancio el servidor central
		
		ServidorRecaudador servidor = new ServidorRecaudador(9999);

	}
	
	/*Constructor*/
	
	public ServidorRecaudador(int puerto) {
		
		try {
			
			servidor = new ServerSocket(puerto);
			
			cliente = servidor.accept();
			
			System.out.println("Servidor Central -> Se ha establecido conexión con el servidor");
			
			/*Abro los flujos de entrada y salida*/
			
			/*Leo el mensaje enviado por el cliente y la guardo en la variable recaudacion*/
			
			entrada = new DataInputStream(cliente.getInputStream());
			
			String recaudacion = entrada.readUTF();
			
			/*Escribo un mensaje de confirmacion al cliente*/
			
			salida = new DataOutputStream(cliente.getOutputStream());
			
			salida.writeUTF("Servidor Central -> Se ha recibido la recaudacion de "+ recaudacion );
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

	

}
