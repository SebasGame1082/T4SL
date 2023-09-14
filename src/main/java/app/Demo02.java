package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	// Actualizar los datos de un Usuario
	public static void main(String[] args) {
		// Llamar a la conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// Crear un manejador de las entidades
		EntityManager manager = fabrica.createEntityManager();
		
		// Objeto a modificar
		Usuario u = new Usuario();
		u.setCod_usua(3);
		u.setNom_usua("Zoila");
		u.setApe_usua("Toro");
		u.setUsr_usua("jperez");
		u.setCla_usua("2121212");
		u.setFna_usua("2008/03/07");
		u.setIdtipo(1);
		u.setEst_usua(1);
		// Si queremos registrar, actualizar o eliminar -> transa..
		try {
			manager.getTransaction().begin();
			manager.merge(u);
			manager.getTransaction().commit();
			System.out.println("Actualización Ok");
		} catch (Exception e) {
			System.out.println("Error: " + e.getCause().getMessage());
		}
		manager.close();
		
	}

}
