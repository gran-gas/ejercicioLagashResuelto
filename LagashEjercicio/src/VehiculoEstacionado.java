

public class VehiculoEstacionado implements IControladorParquimetro  {

	String Patente;
	
	int MinutosEstacionado;
	
	int CentavosPorHora;
	
	public void AutoDetectado (String PatenteRegistrada) {
		
			// La patente que reciba del componente externo sera asignada a la variable Patente de nuestra interfaz.
		Patente = PatenteRegistrada;
		
			// Si el componente externo no nos envía ninguna Patente es que no hay vehículo estacionado por lo tanto el valor de la variable sería null
		if ((PatenteRegistrada.length()) < 1) {
			
			Patente = null;
		}
			// Establecemos el precio por hora de estacionamiento
		CentavosPorHora = 50;
		
			// Este contador almacenará un número aleatorio, cuando este contador sea 4 se detendrá el loop while que veremos a continuación
		long simuladorDeTiempo = 0;
					
			try {
				
					/* Mientras la patente no sea null, es decir mientras haya un auto estacionado, y el número aleatorio no sea 4: se invocará el método AvanzarMinuto() 
					cada 3 segundos (simulando el tiempo que un auto permanecería estacionado y se marcharía*/
				
				while (Patente != null && simuladorDeTiempo != 4) {
					
				AvanzarMinuto ();
				
					//A través del método random generamos un numero aleatorio entre 0 y 4 cada 3 segundos
				simuladorDeTiempo =  Math.round(Math.random()*4);
				
					// (Cada 3 segundos)
				Thread.sleep(3*1000);
								
				}
				
					// Una vez que el While loop termina, se invoca el método EstacionamientoFinalizado() indicando que el vehículo se ha marchado.
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
		
		String asunto = ("Notificación de transito - BA \n");
		
		String cuerpo = ("Usted se estacionó durante " + MinutosEstacionadoFinal + " Minutos" +"\n"+
						 "Deberá Pagar " + montoAPagar + " Centavos en valor de " + horas + " hora/s \n");
		
		
		ServicioExterno.EnviarEmail(asunto, cuerpo, destinatario);
				
		
		
	}
	
	
	
	
	
	
	
}
