package PrecioProducto;

public class PrecioProducto {
	
	
	private String proveedor;
		
	private float precio;
		
	public PrecioProducto(String proveedor, float precio) {
		
		this.proveedor = proveedor;
		
		this.precio = precio;
		
	}
	
	//M�todos getter y setter
	
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
		
		//M�todo que cestablece el proveedor y el precio
		
		public void setDatos(String proveedor, float precio) {
			
			this.proveedor = proveedor;
			
			this.precio = precio;
			
		}
		
		//Sobreescribo em m�todo toString para mostrar los datos que contendr� el array
		
		public String toString() {
			
			return "Proveedor: " + proveedor + " -> Precio: " + precio;	
			
		}
		
}
