// Diseñamos la clase ServicioExterno que luego interactúa con nuestra interfaz

public class ServicioExterno {        
	
	// Este método obtendrá un email a partir de un string, este string será provisto por nuestra interfaz
	
	public static String ObtenerEmailPorPatente(String Patente) {		
		
		// Se simula en la siguiente linea una petición a una base de datos
		//SELECT FROM base WHERE EMAIL == Patente;
		
		// Email de muestra (Nombre de patente + mail.com)
		String resultado = (Patente + "@mail.com");
		
		System.out.println("Mail Obtenido: " + resultado);
		
		return resultado;
	}
	
	
	// El siguiente método a partir de 3 String provistos por la interfaz genera un Email, con asunto, cuerpo, destinatario.
	// Se va a printear en la consola un resumen de lo logrado por el Método.
	
	public static String EnviarEmail(String asunto, String cuerpo, String destinatario) {
		
		System.out.println("------------------------------");
		System.out.println("Email Enviado: ");		
		String email = (asunto + cuerpo + destinatario);
		System.out.println(email);
		
		return email;
	}

}
