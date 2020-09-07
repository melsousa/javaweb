/*classe controle referente a tabela dois
 * @author Melissa de Sousa Felipe
 * @version 1.0
 * */

package controle;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.TabelaDois;


public class TabelaDoisC {
	/*Criando um dado persitente da tabela tabelaDois
	 * */
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
	 /*metodo para inseir campo de titulo e paragrafo
	  * @param tituloDois
	  * @param paragrafoDois
	  * */
	 public TabelaDois tabelaDois(TabelaDois modelo) throws Exception {
		 EntityManager entityManager = this.getEntityManager();
		 try {
			 entityManager.getTransaction().begin();
			 System.out.println("Adicionando na tabela Dois");
			 entityManager.persist(modelo);
			 entityManager.getTransaction().commit();
		 }finally {
			 entityManager.close();
		 }
		 return modelo;
	 }
	 /*método para lista esse tituloUm e paragrafo
	  * @return tituloUm e paragrafo
	  * */
	 @SuppressWarnings("unchecked")
	public List<TabelaDois> ListarTabelaDois(){
		 EntityManager entityManager = this.getEntityManager();
		 List<TabelaDois> modelo = null;
		 try {
			 modelo = entityManager.createQuery("from TabelaDois c").getResultList();
		 }catch(Exception e) {
			 System.out.println(e);
		 }finally {
			 entityManager.close();
		 }
		 return modelo;		 
		 
	 }
	 /*metodo para atualizar os dados da tabeladois
	  * @return os dados da tabela
	  * @param tituloDois
	  * @param paragrafoDois
	  * */
	 public TabelaDois atualizarDois(TabelaDois modelo) throws Exception{
		 EntityManager entityManager = this.getEntityManager();
		 try {
			 entityManager.getTransaction().begin();
			 System.out.println("editando tabela dois");
			 int b = entityManager.createQuery("update TabelaDois set tituloDois=:tituloDois, paragrafoDois=:paragrafoDois where id=:id")
					 .setParameter("id", modelo.getId())
					 .setParameter("tituloDois", modelo.getTituloDois())
					 .setParameter("paragrafoDois", modelo.getParagrafoDois())
					 .executeUpdate();
			 entityManager.getTransaction().commit();
		 }finally {
			 entityManager.close();
		 }
		 return modelo;
	 }
	 /*método para excluir dados da tabela
	  * @param id
	  * */
	 public void excluirTabelaDois(int id) {
		 EntityManager entityManager = this.getEntityManager();
		 try {
			 System.out.println("excluindo tabela dois");
			 entityManager.getTransaction().begin();
			 entityManager.createQuery("delete from TabelaDois where id=:id").setParameter("id", id).executeUpdate();
			 entityManager.getTransaction().commit();
		 }finally {
			 entityManager.close();
		 }
	 }
	 public TabelaDois consultarId(int id) {
		 EntityManager entityManager = getEntityManager();
		 TabelaDois modelo = null;
		 try {
			 modelo = entityManager.find(TabelaDois.class, id);
		 }finally {
			 entityManager.close();
		 }
		 return modelo;
	 }
	

}
