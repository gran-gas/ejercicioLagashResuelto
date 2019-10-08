

public class VehiculoEstacionado implements IControladorParquimetro  {

	String Patente;
	
	int MinutosEstacionado;
	
	int CentavosPorHora;
	
	public void AutoDetectado (String PatenteRegistrada) {
		
			// La patente que reciba del componente externo sera asignada a la variable Patente de nuestra interfaz.
		Patente = PatenteRegistrada;
		
			// Si el componente externo no nos env�a ninguna Patente es que no hay veh�culo estacionado por lo tanto el valor de la variable ser�a null
		if ((PatenteRegistrada.length()) < 1) {
			
			Patente = null;
		}
			// Establecemos el precio por hora de estacionamiento
		CentavosPorHora = 50;
		
			// Este contador almacenar� un n�mero aleatorio, cuando este contador sea 4 se detendr� el loop while que veremos a continuaci�n
		long simuladorDeTiempo = 0;
					
			try {
				
					/* Mientras la patente no sea null, es decir mientras haya un auto estacionado, y el n�mero aleatorio no sea 4: se invocar� el m�todo AvanzarMinuto() 
					cada 3 segundos (simulando el tiempo que un auto permanecer�a estacionado y se marchar�a*/
				
				while (Patente != null && simuladorDeTiempo != 4) {
					
				AvanzarMinuto ();
				
					//A trav�s del m�todo random generamos un numero aleatorio entre 0 y 4 cada 3 segundos
				simuladorDeTiempo =  Math.round(Math.random()*4);
				
					// (Cada 3 segundos)
				Thread.sleep(3*1000);
								
				}
				
					// Una vez que el While loop termina, se invoca el m�todo EstacionamientoFinalizado() indicando que el veh�culo se ha marchado.
				EstacionamientoFinalizado();
				
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	
	
	public void AvanzarMinuto() {
		
		
		System.out.println("Se ha avanzado un minuto");
		
		MinutosEstacionado++;
		
	}
	
	public void EstacionamientoFinalizado() {
		
		System.out.println("Estacionamiento finalizado");
		
		System.out.println("Usted estuvo estacionado " + MinutosEstacionado + " Minutos");
		
		 String destinatario = ServicioExterno.ObtenerEmailPorPatente(Patente);
		
		int horas = 0;
		
		int MinutosEstacionadoFinal = MinutosEstacionado;
		
		while (MinutosEstacionado > 0) {
			
			MinutosEstacionado = MinutosEstacionado - 60;
			horas++;
			
		}
		
		int montoAPagar = CentavosPorHora * horas;
		
		String asunto = ("Notificaci�n de transito - BA \n");
		
		String cuerpo = ("Usted se estacion� durante " + MinutosEstacionadoFinal + " Minutos" +"\n"+
						 "Deber� Pagar " + montoAPagar + " Centavos en valor de " + horas + " hora/s \n");
		
		
		ServicioExterno.EnviarEmail(asunto, cuerpo, destinatario);
				
		
		
	}
	
	
	
	
	
	
	
}
