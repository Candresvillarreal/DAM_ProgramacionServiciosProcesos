package Casos;

public class PrecioProveedor {
	
	private String proveedor;
	
	private float precio;
	
	//Constructor
	
	public PrecioProveedor(String proveedor, float precio) {
		
		this.proveedor = proveedor;
		
		this.precio = precio;
		
	}
	
	//Getters y Setters generales
	
	public String  getProveedor() {
		
		return proveedor;
		
	}
	
	public float getPrecio() {
		
		return precio;
		
	}
	
	public void setProveedor(String proveedor) {
		
		this.proveedor = proveedor;
		
	}
	
	public void setPrecio(float precio) {
		
		this.precio = precio;
		
	}
	
	public void datosProducto(String proveedor, float precio) {
		
		this.proveedor = proveedor;
		
		this.precio = precio;
		
	}
	
}


