package CentralRecaudacion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClienteRecaudacion {
	
	//Esta clase se encarga en el cliente de conectarse con el servidor

	//Antes de ejecutar la clase hay que arrancar el servidor 

	//Comprobar también que la ip es la correcta
	
	private Socket ClienteRecaudacion;
	
	private DataOutputStream salida;
	
	private DataInputStream entrada;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClienteRecaudacion clienteRecaudacion = new ClienteRecaudacion("192.168.1.103", 9999);
		
		//Envío la recaudación
		
		clienteRecaudacion.EnviaRecaudacion("1500");
		
		//Cierro la conexión
		
		clienteRecaudacion.CierraConexion();

	}
	
	
	/*Constructor*/
	
	public ClienteRecaudacion(String ip, int puerto) {
		
		String direccion= ip;
		
		int port = puerto;
		
		try {
			
			System.out.println("Conectando a " + direccion + " en el puerto " + port);
			
			ClienteRecaudacion = new Socket(direccion, port);
			
			System.out.println("Conexion establecida con " + this.ClienteRecaudacion.getRemoteSocketAddress());
			
			/*Creo los flujos de entrada y salida*/
			
			salida = new DataOutputStream(ClienteRecaudacion.getOutputStream());
			
			//entrada = new DataInputStream(ClienteRecaudacion.getInputStream());
			
			entrada = new DataInputStream(ClienteRecaudacion.getInputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	/*Método que envía la recaudación y espera confirmación del servidor*/
	
	public void EnviaRecaudacion(String recaudacion) {
		
		try {
			
		//Envío la recaudación
		
		salida.writeUTF(recaudacion);
		
		System.out.println("Cliente Recaudación -> Recaudación enviada. Esperando confirmación...");
		
		//Espero la respuesta del servidor
		
		String confirmacion = entrada.readUTF();
		
		System.out.println(confirmacion);
		
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

	/*Método que cierra los flujos de datos y la conexión con el servidor*/
	
	public void CierraConexion() {
		
		try {
			
			/*Cierro los flujos de entrada y salida*/
			
			salida.close();
			
			entrada.close();
			
			System.out.println("Se han cerrado los flujos de entrada y salida");
			
			/*Cierro la conexion*/
			
			ClienteRecaudacion.close();
			
			System.out.println("Se ha cerrado la conexión con el servidor");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}
