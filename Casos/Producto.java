package Casos;

import java.util.Scanner;

public class Producto extends Thread{
	
	String nombre;
	
	PrecioProveedor proveedor;  //almacena el nombre del proveedor y el precio
	
	int precios[] = new int[10]; 	//almacenar� 10 precios de un producto.  Luego se calcular� el el mejor precio y se reiniciar� el array.  EN el nuevo array, el mejor precio ocupar� la primera posici�n
	
	//Constructor
	
	public Producto(String nombre, PrecioProveedor proveedor) {
		
		this.nombre = nombre;
		
		this.proveedor = proveedor;
		
	}
	
	//Variables
	
	int precio;		//Variable que guardar� cada precio introducido
	
	int contador=0;	//Variable que controlar� el lugar que ocupa el nuevo precio en el array
	
	boolean ocupado=false;   //Variable para garantizar la exclusi�n m�tua
	
	int menor;
	
	//M�todo para introducir precios en el array -> entrada en secci�n cr�tica
	
	public void anadePrecio() {
		
		ocupado = true; //Marco la variable como ocupado
			
		this.proveedor.setPrecio(precio);
			
		precios[contador] = precio;
		
		contador++;
		
		ocupado = false;  //Dejo de nuevo la variabe en false
		
		//Cuando el array contenga 10 precios, calculo el mejor precio y reinicio el array
		
		if(contador==10) {
			
			for(int i=0; i<precios.length; i++) {
				
				if(precios[i]<menor) {
					
					menor = precios[i];
					
				}
				
			}
			
			precios[0] = menor;
			
			contador = 0;
			
		}
		
		
	}
	
	public void esperaTurno() throws InterruptedException {
		
		if(ocupado==true) {
			
			wait();
			
		}else {
			
			anadePrecio();
			
		}
	}
	
	public void imprimePrecios() {
		
		for(int i=0; i<precios.length; i++) {
			
			System.out.println(precios[i]);
			
			System.out.println(menor);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		

	}
	
	

}
