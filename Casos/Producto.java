package Casos;

import java.util.Scanner;

public class Producto extends Thread{
	
	String nombre;
	
	PrecioProveedor proveedor;  //almacena el nombre del proveedor y el precio
	
	int precios[] = new int[10]; 	//almacenará 10 precios de un producto.  Luego se calculará el el mejor precio y se reiniciará el array.  EN el nuevo array, el mejor precio ocupará la primera posición
	
	//Constructor
	
	public Producto(String nombre, PrecioProveedor proveedor) {
		
		this.nombre = nombre;
		
		this.proveedor = proveedor;
		
	}
	
	//Variables
	
	int precio;		//Variable que guardará cada precio introducido
	
	int contador=0;	//Variable que controlará el lugar que ocupa el nuevo precio en el array
	
	boolean ocupado=false;   //Variable para garantizar la exclusión mútua
	
	int menor;
	
	//Método para introducir precios en el array -> entrada en sección crítica
	
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
