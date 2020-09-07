package controle;

import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Table;

import modelo.UsuarioM;
@Table(name="usuario")
@SessionScoped
public class UsuarioC {
	
	 private EntityManager getEntityManager() {
		    EntityManagerFactory factory = null;
		    EntityManager entityManager = null;
		    try {
		    	factory = Persistence.createEntityManagerFactory("ExemplosJPAPU");
		    	entityManager = factory.createEntityManager();
		    	}finally{
		    		factory.close();
		    	}
		    return entityManager;
		    }
	  public UsuarioM salvar(UsuarioM modelo) throws Exception {
		    EntityManager entityManager = getEntityManager();
		    try {
		    	entityManager.getTransaction().begin();
		        System.out.println("Adicionando ");
		        
		          //Salva os dados da pessoa.
		          entityManager.persist(modelo);
		      // Finaliza a transação.
		        entityManager.getTransaction().commit();
		    }finally {
		    	 entityManager.close();
		    }
		    return modelo;
	  }
}
