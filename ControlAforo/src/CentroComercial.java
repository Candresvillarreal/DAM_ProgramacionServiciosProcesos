
public class CentroComercial {
	
	/*Esta clase implementa el sem�foro, que ser� �nico.  Mientras se est� utilizando para contabilizar la entrada o la salida
	 * no podr� ser utilizado para contabilizar otra entrada o salida.  Implementa los m�todos para cambiar la disponibilidad del
	 * sem�foro y tambi�n los m�todos que controlan el acceso y la salida del centro comercial.
	 */
	
	//------------------------------------------- VARIABLES SEM�FORO----------------------------------------------------------------------------
	
	//Declaro una variable privada del sem�foro
	
	private static CentroComercial cc = null;
	
	//Declaro la variable que controla el sem�foro (1 -> disponible y distinto de 1 -> no disponible)
	
	private static int semaforo = 1;
	
	//------------------------------------------- VARIABLES QUE CONTROLAN EL AFORO O INFORMAN SOBRE EL AFORO------------------------------------
	
	//Variable que controlar� el aforo y que inicialmente es 0
	
	private static int aforo = 0;
	
	//Variable que contendr� el total de adultos que est�n dentro del centro comercial
	
	private static int numAdultosTotales = 0;
	
	//Variable que contendr� el total de ni�os que est�n dentro del centro comercial
	
	private static int numNinyosTotales = 0;
	
	//Variables que acumular�n el total de clientes, adultos y ni�os que han entrado
	
	private static int totalClientesAcceso = 0;
	
	private static int totalAdultosAcceso = 0;
	
	private static int totalNinyosAcceso = 0;
	
	//Variables que acumular�n el total de clientes, adultos y ni�o que han salido
	
	private static int totalClientesSalida = 0;
	
	private static int totalAdultosSalida = 0;
	
	private static int totalNinyosSalida = 0;
	
	//-------------------------------------------- OTRAS VARIABLES --------------------------------------------------------------------------------------
	
	Cliente cliente;
	
	int limiteAfluenciaTotal = 40;		//Marca el aforo m�ximo.  En este caso 40.  Nadie podr� entrar si con su entrada se supera este valor.
	
	int minimoAfluencia = 0;			//Marca el aforo m�nimo.  Nadie puede salir si el aforo es igual o ingerior a 0.
	
	//Constructor por defecto -> privado para que no puede ser instanciado.  As� se asegura que cc ser� el �nico objeto utilizado
	
	private CentroComercial() {
		
	}
	
	//-----------------------------------------------------------SEMAFORO---------------------------------------------------------------------------------
	
	
	//M�todo para obtener el sem�foro -> finaliza la instanciaci�n del objeto cc y lo devuelve para ser utilizado
	
	public final static CentroComercial getInstance() {
		
		if(cc==null) {
			
			cc = new CentroComercial();
			
		}
		
		return cc;
		
	}
	
	//M�todo que decrementa el valor del sem�foro
	
		public synchronized void rojo() {
			
			semaforo = 0;
			
		}
		
		//M�todo que incrementa el valor del sem�for
		
		public synchronized void verde() {
			
			semaforo= 1;
			
		}
		
		//M�todo que devuelve si el sem�foro est� disponible (vale 1) o no disponible (otro valor)
		
		public synchronized final static boolean disponible() {
			
			return semaforo == 1 ? true : false;
			
		}
		
	//--------------------------------------------------------------FIN SEMAFORO----------------------------------------------------------------------------
		
		
	//-----------------------------------------------------CONTADOR AFORO CENTRO COMERCIAL------------------------------------------------------------------
		
	//------------------------------------------------M�TODOS QUE OBTIENEN DATOS SOBRE EL AFORO-------------------------------------------------------------
	
	//M�todo que obtiene el valor del aforo
		
	public int getAforo() {
		
		return aforo;
		
	}
	
	//M�todo que obtiene el n�mero total de adultos dentro del centro comercial
	
	public int getNumAdultos() {
		return numAdultosTotales;
		
	}
	
	//M�todo que obtiene el n�mero total de ni�os dentro del centro comercial
	
	public int getNumNinos() {
		
		return numNinyosTotales;
		
	}
	
	//M�todo que obtiene el n�mero total de clientes que han accedido al centro comercial
	
	public int getTotalClientesAcceso() {
		
		return totalClientesAcceso;
		
	}
	
	//M�todo que obtiene el n�mero total de adultos que han accedido al centro comercial
	
	public int getTotalAdultosAcceso() {
		
		return totalAdultosAcceso;
		
	}
	
	//M�todo que obtiene el n�mero total de ni�os que han accedido al centro comercial
	
	public int getTotalNinyosAcceso() {
		
		return totalNinyosAcceso;
		
	}
	
	//*M�todo que obtiene el n�mero total de clientes que han salido del centro comercial
	
	public int getTotalClientesSalida() {
		
		return totalClientesSalida;
		
	}
	
	//M�todo que obtiene el n�mero total de adultos que han salido del centro comercial
	
	public int getTotalAdultosSalida() {
		
		return totalAdultosSalida;
		
	}
	
	//M�todo que obtiene el n�mero total de ni�os que han salido del centro comercial
	
	public int getTotalNinyosSalida() {
		
		return totalNinyosSalida;
		
	}
	
	//------------------------------------------- ACCESO AL CENTRO COMERCIAL --------------------------------------------------------------------------
	
	//M�todo que controla el acceso al centro comercial. Recibe por par�metro el nombre del thread y el cliente
	
	public synchronized void entrar(String hilo, Cliente cliente) {
		
		int adultos = cliente.getAdultos();
		
		int ninos = cliente.getNinos();
		
		int entran = adultos + ninos;
		
		//Si el sem�foro no est� disponible (distinto de 1), el hilo se queda a la espera
		
		try {
			
			while(!disponible()) {
				
				this.wait();
				
			}
		
		}catch(InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		/*Si el sem�foro est� disponible, entro en la secci�n cr�tica y cambio el valor del sem�foro para que no est� disponible y no pueda
		 *ser utilizado por otro hilo
		 */
		
		rojo();
		
		//Mientras la entrada de un nuevo cliente suponga superar el aforo establecido se quedar� a la espera hasta que haya aforo disponible
		
		while((aforo+entran)>limiteAfluenciaTotal)  {
			
			//Calculo el exceso de aforo e imprimo un mensaje informativo
			
			int exceso = ((aforo+entran) - limiteAfluenciaTotal);
			
			System.out.println(hilo + " -> Acceso no permitido.  Se supera el aforo m�ximo permitido en " + exceso + " clientes.");
			
			try {
				
				//Salgo de la secci�n cr�tica
				
				verde();
				
				//Dejo el hilo a la espera
				
				wait();
				
			}catch(InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		//Si no se supera el aforo, entra el cliente, se incrementa el aforo y las variables que recogen el total de adultos y ni�os
		
		if((aforo+entran) <= limiteAfluenciaTotal) {
			
			aforo = aforo + entran;
			
			numAdultosTotales = numAdultosTotales + adultos;
			
			numNinyosTotales = numNinyosTotales + ninos;
			
			totalClientesAcceso = totalClientesAcceso + entran;
			
			totalAdultosAcceso = totalAdultosAcceso + adultos;
			
			totalNinyosAcceso = totalNinyosAcceso + ninos;
			
			System.out.println(hilo + " -> Acceso Permitido. Nuevo aforo " + aforo + " . Total Adultos: " + numAdultosTotales + " . Total ni�os: " + numNinyosTotales);
		
		}
		
		//Salgo de la secci�n cr�tica y dejo el sem�foro disponible 
		
		verde();
		
		this.notifyAll();
		
	}
	
	//---------------------------------------------------- FIN ACCESO AL CENTRO COMERCIAL --------------------------------------------------------------------
	
	//---------------------------------------------------- SALIDA DEL CENTRO COMERCIAL -----------------------------------------------------------------------
	
	//M�todo que controla la salida del centro comercial. Recibe por par�metro el nombre del thread y el cliente
	
	public synchronized void salir(String hilo, Cliente cliente) {
		
		int adultos = cliente.getAdultos();
		
		int ninos = cliente.getNinos();
		
		int salen = adultos + ninos;
		
		//Mientras el sem�foro no est� disponible, el hilo se queda a la espera
		
		try {
			
			while(!disponible()) {
				
				this.wait();
				
			}
			
		}catch(InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		//Si est� disponible, entro en la secci�n cr�tica.  Cambio el sem�foro a no disponible
		
		rojo();
		
		/*Si al salir un cliente el aforo es menor que cero, nadie puede salir.  Tampoco podr�n salir  si quieren salir m�s adultos de los que hay dentro
		 * o m�s ni�os de los que hay dentro
		 */
		
		while(((aforo-salen) < 0) || ((numAdultosTotales - adultos) < 0) || ((numNinyosTotales - ninos) < 0))  {
			
			if((aforo-salen) < 0) {
			
				System.out.println(hilo + " -> No pueden salir m�s clientes de los que hay dentro.  Quieren salir " + salen + " y hay " + aforo + " clientes dentro");
			
			}
			
			if((numAdultosTotales - adultos) < 0) {
				
				System.out.println(hilo + " -> No pueden salir m�s adultos de los que hay dentro.  Quieren salir " + adultos + " adultos y hay " + numAdultosTotales + " adultos dentro");
			}
			
			if((numNinyosTotales - ninos) < 0){
				
				System.out.println(hilo + " -> No pueden salir m�s ni�os de los que hay dentro.  Quieren salir " + ninos + " ni�os y hay " + numNinyosTotales + " ni�os dentro");
				
			}
			
			try {
				
				//Salgo de la secci�n cr�tica y dejo el hilo a la espera
				
					verde();
				
					this.wait();
					
			}catch(InterruptedException e) {
					
					e.printStackTrace();
					
			}
			
		}
		
		//Tras las comprobaciones anteriores, un cliente podr� salir siempre que el aforo resultante sea mayor cero
		
		if((aforo-salen) > 0) {
			
			aforo = aforo - salen;
			
			numAdultosTotales = numAdultosTotales - adultos;
			
			numNinyosTotales = numNinyosTotales - ninos;
			
			totalClientesSalida = totalClientesSalida + salen;
			
			totalAdultosSalida = totalAdultosSalida + adultos;
			
			totalNinyosSalida = totalNinyosSalida + ninos;
			
			System.out.println(hilo + " -> Han salido " + salen + " clientes: " + adultos + " adultos y " + ninos + " ni�os. Nuevo aforo es: " + aforo + " . Total Adultos: " + numAdultosTotales + " . Total Ni�os: " + numNinyosTotales);
		
		}
		
		//Salgo de la secci�n cr�tica.  Dejo el sem�foro en disponible
		
		verde();
		
		this.notifyAll();
		
	}

}
