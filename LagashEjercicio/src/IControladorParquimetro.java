
public interface IControladorParquimetro {    
											
	String Patente = null;              
	
	int MinutosEstacionado = 0;
	
	int CentavosPorHora = 0;					// Diseñamos la interfaz solicitada en el ejercicio
	
	void AutoDetectado(String patente);
	
	void AvanzarMinuto();
	
	void EstacionamientoFinalizado();
		

}
