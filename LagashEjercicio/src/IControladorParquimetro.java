
public interface IControladorParquimetro {    
											
	String Patente = null;              
	
	int MinutosEstacionado = 0;
	
	int CentavosPorHora = 0;					// Dise�amos la interfaz solicitada en el ejercicio
	
	void AutoDetectado(String patente);
	
	void AvanzarMinuto();
	
	void EstacionamientoFinalizado();
		

}
