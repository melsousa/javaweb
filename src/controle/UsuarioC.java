/*classe usuario 
 * @author Melissa de Sousa Felipe
 * version 1.6
 * */
package controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import modelo.UsuarioM;

public class UsuarioC {
	
	
	 private EntityManager getEntityManager() {
		    EntityManagerFactory factory = null;
		    EntityManager entityManager = null;
		    try {
		    	factory = Persistence.createEntityManagerFactory("JPA");
		    	entityManager = factory.createEntityManager();
		    	}finally{
		    		//factory.close();
		    	}
		    return entityManager;
		    }
	 /*Salvar os dados da pessoa
	  * @param nome
	  * @param senha
	  * */
	  public UsuarioM salvar(UsuarioM modelo) throws Exception {
		    EntityManager entityManager = this.getEntityManager();
		    try {
		    	entityManager.getTransaction().begin();
		        System.out.println("Adicionando..");
		          //Salva os dados da pessoa.
		          entityManager.persist(modelo);
		      // Finaliza a transação.
		        entityManager.getTransaction().commit();
		    }finally {
		    	 entityManager.close();
		    }
		    return modelo;
	  }
	  /*Consulta todos
	   * @return o objeto do usuário
	   * */
	  @SuppressWarnings("unchecked")
	  public List <UsuarioM> findAll(){
		  EntityManager entityManager = this.getEntityManager();
		  List<UsuarioM> modelo = null;
		  try {
			  modelo = entityManager.createQuery("from UsuarioM c").getResultList();
		  }catch(Exception e) {
			  System.out.println(e);
		  }finally {
			  entityManager.close();
		  }
		  return modelo;
	  }
	 // @SuppressWarnings("unchecked")
	//  public SelecionarId() {
		//  EntityManager entityManager = this.getEntityManager();
		  //try {
			//  modelo = entityManager.createQuery("from UsuarioM where id=:id");
		  //}catch(Exception e) {
			  
		  //}
	  //}
	  /*Método para atualização dos dados
	   * @return os dados da tabela
	   * */
	  public UsuarioM atualizar(UsuarioM modelo) throws Exception {
		    EntityManager entityManager = this.getEntityManager();
		    try {
		    	entityManager.getTransaction().begin();
		        System.out.println("editando..");
		          int u =  entityManager.createQuery("update UsuarioM set nome=:nome, senha=:se where id=:d")
		        		  .setParameter("d", modelo.getId())
		        		  .setParameter("nome", modelo.getNome())
		        		  .setParameter("se", modelo.getSenha())
		        		  .executeUpdate();
		         
		      
		        entityManager.getTransaction().commit();
		    }finally {
		    	 entityManager.close();
		    }
		    return modelo;
	  }
	  /*metodo para excluir os dados da tabela 
	   * @param id
	   * */
	  public void excluirPorId(int id){
		  System.out.println("dudu2");
		    EntityManager entityManager = this.getEntityManager();
		    try {
		    	System.out.println("dudu3");
		    	entityManager.getTransaction().begin();
		    	entityManager.createQuery("delete from UsuarioM where id=:id").setParameter("id", id).executeUpdate();
		    	entityManager.getTransaction().commit();
		    }finally {
		    	entityManager.close();
		    }
			
	  }
	  /*metodo consulta por id
	   * @param id
	   * return a classe modelo
	   * */
	  public UsuarioM consultarPorId(int id) {
		  EntityManager entityManager = getEntityManager();
		  UsuarioM modelo = null;
		  try {
			  modelo = entityManager.find(UsuarioM.class,id);
		  }finally {
			  entityManager.close();
		  }
		  return modelo;
	  
	  }
}

