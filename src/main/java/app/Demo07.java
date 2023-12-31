package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo07 {
	// Listado de Usuarios según un tipo.
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager manager = fabrica.createEntityManager();
		
		// select * from tb_xxxx
		String sql = "select u from Usuario u where u.idtipo = :xtipo";
		List<Usuario> lstUsuarios =
				manager.createQuery(sql, Usuario.class).setParameter("xtipo", 1).getResultList();
		
		// Recorre el listado y lo muestra
		for (Usuario u : lstUsuarios) {
			System.out.println("Código : " + u.getCod_usua());
			System.out.println("Nombre : " + u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo   : " + u.getIdtipo() + " - " + u.getObjTipo().getDescripcion());
			System.out.println("-------------------------");
			
		}
		
		manager.close();
		
	}

}
