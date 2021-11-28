package SimCityJava;

public class AlmacenComida implements Runnable {
	
	int totalComida=500;

	public AlmacenComida() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		
		try {
			
			Thread.sleep(1000); //Esperamos 1 segundo para generar 10 unidades de comida
			
			totalComida=totalComida+10;
			
			System.out.println("[ALMACEN] Se han producido "+10+" uds de comida");
			
		}catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	//Procedimiento que devuelve cuanta comida hay en el Almacen
	
	public int comidaDisponible(){
		
		return this.totalComida;
		
	}
	
	public synchronized boolean solicitarComida(int cantidadComida,String ciudad) throws InterruptedException {
		
		if(cantidadComida<=this.totalComida) {
			
			//AQU� FALTA C�DIGO //simulamos la preparaci�n de la comida multiplicando la cantidad solicitada por 10 milisegundos
			
			sleep((int)(cantidadComida*10));
			
			//AQU� FALTA C�DIGO //restamos del total de comida la comidasolicitada
			
			totalComida=totalComida-cantidadComida;
			
			System.out.println("[ALMACEN] La ciudad "+ciudad+" ha recibido "+cantidadComida+" uds de comida");
			
			return true;
			
		}else {
			
			System.out.println("[ALMACEN] no hay suficiente comida para abastecer a la ciudad "+ciudad);
			
			return false;
			
		}
	}
	
	private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}
	

}
