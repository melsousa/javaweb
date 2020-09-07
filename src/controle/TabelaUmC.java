/*classe controle referente a tabela um
 * @author Melissa de Sousa Felipe
 * @version 1.0
 * */

package controle;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.TabelaUm;
public class TabelaUmC {
	/*Criando um dado persitente da tabela tabelaUm
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
	  * @param tituloUm
	  * @param paragrafoUm
	  * */
	 public TabelaUm tabelaUm(TabelaUm modelo) throws Exception {
		 EntityManager entityManager = this.getEntityManager();
		 try {
			 entityManager.getTransaction().begin();
			 System.out.println("Adicionando na tabela Um");
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
	public List<TabelaUm> ListarTabelaUm(){
		 EntityManager entityManager = this.getEntityManager();
		 List<TabelaUm> modelo = null;
		 try {
			 modelo = entityManager.createQuery("from TabelaUm c").getResultList();
		 }catch(Exception e) {
			 System.out.println(e);
		 }finally {
			 entityManager.close();
		 }
		 return modelo;		 
		 
	 }
	 public TabelaUm consultarUm(int id) {
		 EntityManager entityManager = this.getEntityManager();
		 TabelaUm modelo = null;
		 try {
			 System.out.println("consultando o id");
			 modelo = entityManager.find(TabelaUm.class, id);
		 }finally {
			 entityManager.close();
		 }
		 return modelo;
	 }
	 public TabelaUm atualizarUm(TabelaUm modelo) throws Exception{
		 EntityManager entityManager = this.getEntityManager();
		 try {
			 entityManager.getTransaction().begin();
			 System.out.println("editando tabela Um");
			 int a = entityManager.createQuery("update TabelaUm set tituloUm=:tituloum, paragrafoUm=:paragrafoum where id=:id")
					 .setParameter("id", modelo.getId())
					 .setParameter("tituloum", modelo.getTituloUm())
					 .setParameter("paragrafoum", modelo.getParagrafoUm())
					 .executeUpdate();
			 entityManager.getTransaction().commit();
		 }finally {
			 entityManager.close();
		 }
		 return modelo;
	 }
	 /*método para excluir dados da tabela
	  * */
	 public void excluirTabelaUm(int id) {
		 EntityManager entityManager = this.getEntityManager();
		 try {
			 entityManager.getTransaction().begin();
			 entityManager.createQuery("delete from TabelaUm where id=:id").setParameter("id", id).executeUpdate();
			 entityManager.getTransaction().commit();
		 }finally {
			 entityManager.close();
		 }
		 
	 }
	
}
