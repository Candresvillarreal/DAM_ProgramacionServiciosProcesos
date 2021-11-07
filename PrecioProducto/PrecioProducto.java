package PrecioProducto;

public class PrecioProducto {
	
	
	private String proveedor;
		
	private float precio;
		
	public PrecioProducto(String proveedor, float precio) {
		
		this.proveedor = proveedor;
		
		this.precio = precio;
		
	}
	
	//Métodos getter y setter
	
		public float getPrecio() {
					
			return precio;
					
		}
		
		public String getProveedor() {
			
			return proveedor;
			
		}
		
		public void getDatos() {
			
			System.out.println("Proveedor: " + proveedor + "Precio: " + precio);
			
		}
		
		public void setPrecio(float precio) {
			
			this.precio = precio;
			
		}
		
		public void setProveedor(String proveedor) {
			
			this.proveedor = proveedor;
			
		}
		
		//Método que cestablece el proveedor y el precio
		
		public void setDatos(String proveedor, float precio) {
			
			this.proveedor = proveedor;
			
			this.precio = precio;
			
		}
		
		//Sobreescribo em método toString para mostrar los datos que contendrá el array
		
		public String toString() {
			
			return "Proveedor: " + proveedor + " -> Precio: " + precio;	
			
		}
		
}
