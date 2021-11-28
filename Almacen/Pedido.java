package Almacen;

public class Pedido {
	
	private String id;
	
	private int[] productos;
	
	//Constructor con dos parámetros
	
	public Pedido(String id, int[] productos) {
		
		this.id=id;
		
		this.productos=productos;
		
	}
	
	//getter que devuelve el id del pedido
	
	public String getId() {
		
		return this.id;
	}
	
	//getter que devuelve los productos de un pedido
	
	public int[] getProductos() {
		
		return this.productos;
	}

}
