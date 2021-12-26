
public class CentroComercial {
	
	/*Esta clase implementa el semáforo, que será único.  Mientras se esté utilizando para contabilizar la entrada o la salida
	 * no podrá ser utilizado para contabilizar otra entrada o salida.  Implementa los métodos para cambiar la disponibilidad del
	 * semáforo y también los métodos que controlan el acceso y la salida del centro comercial.
	 */
	
	//------------------------------------------- VARIABLES SEMÁFORO----------------------------------------------------------------------------
	
	//Declaro una variable privada del semáforo
	
	private static CentroComercial cc = null;
	
	//Declaro la variable que controla el semáforo (1 -> disponible y distinto de 1 -> no disponible)
	
	private static int semaforo = 1;
	
	//------------------------------------------- VARIABLES QUE CONTROLAN EL AFORO O INFORMAN SOBRE EL AFORO------------------------------------
	
	//Variable que controlará el aforo y que inicialmente es 0
	
	private static int aforo = 0;
	
	//Variable que contendrá el total de adultos que están dentro del centro comercial
	
	private static int numAdultosTotales = 0;
	
	//Variable que contendrá el total de niños que están dentro del centro comercial
	
	private static int numNinyosTotales = 0;
	
	//Variables que acumularán el total de clientes, adultos y niños que han entrado
	
	private static int totalClientesAcceso = 0;
	
	private static int totalAdultosAcceso = 0;
	
	private static int totalNinyosAcceso = 0;
	
	//Variables que acumularán el total de clientes, adultos y niño que han salido
	
	private static int totalClientesSalida = 0;
	
	private static int totalAdultosSalida = 0;
	
	private static int totalNinyosSalida = 0;
	
	//-------------------------------------------- OTRAS VARIABLES --------------------------------------------------------------------------------------
	
	Cliente cliente;
	
	int limiteAfluenciaTotal = 40;		//Marca el aforo máximo.  En este caso 40.  Nadie podrá entrar si con su entrada se supera este valor.
	
	int minimoAfluencia = 0;			//Marca el aforo mínimo.  Nadie puede salir si el aforo es igual o ingerior a 0.
	
	//Constructor por defecto -> privado para que no puede ser instanciado.  Así se asegura que cc será el único objeto utilizado
	
	private CentroComercial() {
		
	}
	
	//-----------------------------------------------------------SEMAFORO---------------------------------------------------------------------------------
	
	
	//Método para obtener el semáforo -> finaliza la instanciación del objeto cc y lo devuelve para ser utilizado
	
	public final static CentroComercial getInstance() {
		
		if(cc==null) {
			
			cc = new CentroComercial();
			
		}
		
		return cc;
		
	}
	
	//Método que decrementa el valor del semáforo
	
		public synchronized void rojo() {
			
			semaforo = 0;
			
		}
		
		//Método que incrementa el valor del semáfor
		
		public synchronized void verde() {
			
			semaforo= 1;
			
		}
		
		//Método que devuelve si el semáforo está disponible (vale 1) o no disponible (otro valor)
		
		public synchronized final static boolean disponible() {
			
			return semaforo == 1 ? true : false;
			
		}
		
	//--------------------------------------------------------------FIN SEMAFORO----------------------------------------------------------------------------
		
		
	//-----------------------------------------------------CONTADOR AFORO CENTRO COMERCIAL------------------------------------------------------------------
		
	//------------------------------------------------MÉTODOS QUE OBTIENEN DATOS SOBRE EL AFORO-------------------------------------------------------------
	
	//Método que obtiene el valor del aforo
		
	public int getAforo() {
		
		return aforo;
		
	}
	
	//Método que obtiene el número total de adultos dentro del centro comercial
	
	public int getNumAdultos() {
		return numAdultosTotales;
		
	}
	
	//Método que obtiene el número total de niños dentro del centro comercial
	
	public int getNumNinos() {
		
		return numNinyosTotales;
		
	}
	
	//Método que obtiene el número total de clientes que han accedido al centro comercial
	
	public int getTotalClientesAcceso() {
		
		return totalClientesAcceso;
		
	}
	
	//Método que obtiene el número total de adultos que han accedido al centro comercial
	
	public int getTotalAdultosAcceso() {
		
		return totalAdultosAcceso;
		
	}
	
	//Método que obtiene el número total de niños que han accedido al centro comercial
	
	public int getTotalNinyosAcceso() {
		
		return totalNinyosAcceso;
		
	}
	
	//*Método que obtiene el número total de clientes que han salido del centro comercial
	
	public int getTotalClientesSalida() {
		
		return totalClientesSalida;
		
	}
	
	//Método que obtiene el número total de adultos que han salido del centro comercial
	
	public int getTotalAdultosSalida() {
		
		return totalAdultosSalida;
		
	}
	
	//Método que obtiene el número total de niños que han salido del centro comercial
	
	public int getTotalNinyosSalida() {
		
		return totalNinyosSalida;
		
	}
	
	//------------------------------------------- ACCESO AL CENTRO COMERCIAL --------------------------------------------------------------------------
	
	//Método que controla el acceso al centro comercial. Recibe por parámetro el nombre del thread y el cliente
	
	public synchronized void entrar(String hilo, Cliente cliente) {
		
		int adultos = cliente.getAdultos();
		
		int ninos = cliente.getNinos();
		
		int entran = adultos + ninos;
		
		//Si el semáforo no está disponible (distinto de 1), el hilo se queda a la espera
		
		try {
			
			while(!disponible()) {
				
				this.wait();
				
			}
		
		}catch(InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		/*Si el semáforo está disponible, entro en la sección crítica y cambio el valor del semáforo para que no esté disponible y no pueda
		 *ser utilizado por otro hilo
		 */
		
		rojo();
		
		//Mientras la entrada de un nuevo cliente suponga superar el aforo establecido se quedará a la espera hasta que haya aforo disponible
		
		while((aforo+entran)>limiteAfluenciaTotal)  {
			
			//Calculo el exceso de aforo e imprimo un mensaje informativo
			
			int exceso = ((aforo+entran) - limiteAfluenciaTotal);
			
			System.out.println(hilo + " -> Acceso no permitido.  Se supera el aforo máximo permitido en " + exceso + " clientes.");
			
			try {
				
				//Salgo de la sección crítica
				
				verde();
				
				//Dejo el hilo a la espera
				
				wait();
				
			}catch(InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		//Si no se supera el aforo, entra el cliente, se incrementa el aforo y las variables que recogen el total de adultos y niños
		
		if((aforo+entran) <= limiteAfluenciaTotal) {
			
			aforo = aforo + entran;
			
			numAdultosTotales = numAdultosTotales + adultos;
			
			numNinyosTotales = numNinyosTotales + ninos;
			
			totalClientesAcceso = totalClientesAcceso + entran;
			
			totalAdultosAcceso = totalAdultosAcceso + adultos;
			
			totalNinyosAcceso = totalNinyosAcceso + ninos;
			
			System.out.println(hilo + " -> Acceso Permitido. Nuevo aforo " + aforo + " . Total Adultos: " + numAdultosTotales + " . Total niños: " + numNinyosTotales);
		
		}
		
		//Salgo de la sección crítica y dejo el semáforo disponible 
		
		verde();
		
		this.notifyAll();
		
	}
	
	//---------------------------------------------------- FIN ACCESO AL CENTRO COMERCIAL --------------------------------------------------------------------
	
	//---------------------------------------------------- SALIDA DEL CENTRO COMERCIAL -----------------------------------------------------------------------
	
	//Método que controla la salida del centro comercial. Recibe por parámetro el nombre del thread y el cliente
	
	public synchronized void salir(String hilo, Cliente cliente) {
		
		int adultos = cliente.getAdultos();
		
		int ninos = cliente.getNinos();
		
		int salen = adultos + ninos;
		
		//Mientras el semáforo no esté disponible, el hilo se queda a la espera
		
		try {
			
			while(!disponible()) {
				
				this.wait();
				
			}
			
		}catch(InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		//Si está disponible, entro en la sección crítica.  Cambio el semáforo a no disponible
		
		rojo();
		
		/*Si al salir un cliente el aforo es menor que cero, nadie puede salir.  Tampoco podrán salir  si quieren salir más adultos de los que hay dentro
		 * o más niños de los que hay dentro
		 */
		
		while(((aforo-salen) < 0) || ((numAdultosTotales - adultos) < 0) || ((numNinyosTotales - ninos) < 0))  {
			
			if((aforo-salen) < 0) {
			
				System.out.println(hilo + " -> No pueden salir más clientes de los que hay dentro.  Quieren salir " + salen + " y hay " + aforo + " clientes dentro");
			
			}
			
			if((numAdultosTotales - adultos) < 0) {
				
				System.out.println(hilo + " -> No pueden salir más adultos de los que hay dentro.  Quieren salir " + adultos + " adultos y hay " + numAdultosTotales + " adultos dentro");
			}
			
			if((numNinyosTotales - ninos) < 0){
				
				System.out.println(hilo + " -> No pueden salir más niños de los que hay dentro.  Quieren salir " + ninos + " niños y hay " + numNinyosTotales + " niños dentro");
				
			}
			
			try {
				
				//Salgo de la sección crítica y dejo el hilo a la espera
				
					verde();
				
					this.wait();
					
			}catch(InterruptedException e) {
					
					e.printStackTrace();
					
			}
			
		}
		
		//Tras las comprobaciones anteriores, un cliente podrá salir siempre que el aforo resultante sea mayor cero
		
		if((aforo-salen) > 0) {
			
			aforo = aforo - salen;
			
			numAdultosTotales = numAdultosTotales - adultos;
			
			numNinyosTotales = numNinyosTotales - ninos;
			
			totalClientesSalida = totalClientesSalida + salen;
			
			totalAdultosSalida = totalAdultosSalida + adultos;
			
			totalNinyosSalida = totalNinyosSalida + ninos;
			
			System.out.println(hilo + " -> Han salido " + salen + " clientes: " + adultos + " adultos y " + ninos + " niños. Nuevo aforo es: " + aforo + " . Total Adultos: " + numAdultosTotales + " . Total Niños: " + numNinyosTotales);
		
		}
		
		//Salgo de la sección crítica.  Dejo el semáforo en disponible
		
		verde();
		
		this.notifyAll();
		
	}

}
