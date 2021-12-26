
public class Cliente {
	
	/*Clase que crea un cliente.  Se le pasa por par�metro el n�mero de adultos y de ni�os que lo forman.
	 *Consta de dos atributos (adultos y ninos), su m�todo constructor con los dos par�metros y 
	 *sus getter y setter
	 */
	 
	int adultos;
	
	int ninos;
	
	public Cliente(int adultos, int ninos) {
		
		this.adultos = adultos;
		
		this.ninos = ninos;
		
	}
	
	public int getAdultos() {
		
		return adultos;
		
	}
	
	public void setAdultos(int adultos) {
		
		this.adultos = adultos;
		
	}
	
	public int getNinos() {
		
		return ninos;
		
	}
	
	public void setNinos(int ninos) {
		
		this.ninos = ninos;
	}

}
