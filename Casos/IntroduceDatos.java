package Casos;

public class IntroduceDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrecioProveedor lapiz = new PrecioProveedor("P1", 0.50f);
		
		Producto prod = new Producto("lapiz", lapiz);
		
		prod.anadePrecio();
		
		prod.imprimePrecios();
		
		
		

	}

}
