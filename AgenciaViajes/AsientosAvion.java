package AgenciaViajes;

public class AsientosAvion {
	
	//comenzamos con un numero de 5 asientos
		private int asientosLibres = 5;
		 
		public AsientosAvion() {
			// TODO Auto-generated constructor stub
		}
		
		public int getAsientosLibres(){
			return asientosLibres;
		}
		 
		public boolean getAsientosLibres(int numAsientosSolicitados){
			if (numAsientosSolicitados<=asientosLibres)
				return true;
			else
				return false;
		}
		 
		public void reservarAsientos(int numAsientosReservados){
			asientosLibres = asientosLibres - numAsientosReservados;
		}

}
