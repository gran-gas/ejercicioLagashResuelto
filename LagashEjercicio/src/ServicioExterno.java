// Dise�amos la clase ServicioExterno que luego interact�a con nuestra interfaz

public class ServicioExterno {        
	
	// Este m�todo obtendr� un email a partir de un string, este string ser� provisto por nuestra interfaz
	
	public static String ObtenerEmailPorPatente(String Patente) {		
		
		// Se simula en la siguiente linea una petici�n a una base de datos
		//SELECT FROM base WHERE EMAIL == Patente;
		
		// Email de muestra (Nombre de patente + mail.com)
		String resultado = (Patente + "@mail.com");
		
		System.out.println("Mail Obtenido: " + resultado);
		
		return resultado;
	}
	
	
	// El siguiente m�todo a partir de 3 String provistos por la interfaz genera un Email, con asunto, cuerpo, destinatario.
	// Se va a printear en la consola un resumen de lo logrado por el M�todo.
	
	public static String EnviarEmail(String asunto, String cuerpo, String destinatario) {
		
		System.out.println("------------------------------");
		System.out.println("Email Enviado: ");		
		String email = (asunto + cuerpo + destinatario);
		System.out.println(email);
		
		return email;
	}

}
