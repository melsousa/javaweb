package controle;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import modelo.TabelaTres;

public class TabelaTresC {
	/*Criando um dado persitente da tabela tabelaTres
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
	 public TabelaTres tabelaTres(TabelaTres modelo) throws Exception {
		 EntityManager entityManager = this.getEntityManager();
		 try {
			 entityManager.getTransaction().begin();
			 System.out.println("Adicionando na tabela Tres");
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
	public List<TabelaTres> ListarTabelaTres(){
		 EntityManager entityManager = this.getEntityManager();
		 List<TabelaTres> modelo = null;
		 try {
			 modelo = entityManager.createQuery("from TabelaTres c").getResultList();
		 }catch(Exception e) {
			 System.out.println(e);
		 }finally {
			 entityManager.close();
		 }
		 return modelo;		 	 
	 }
	 /*metodo para atualizar a tabelaTres
	  * @return os dados da tabela
	  * @param tituloTres
	  * @param paragrafoTres
	  * */
	 public TabelaTres atualizarTres(TabelaTres modelo) throws Exception{
		 EntityManager entityManager = this.getEntityManager();
		 try {
			 entityManager.getTransaction().begin();
			 System.out.println("editando tabelaTres");
			 int a = entityManager.createQuery("update TabelaTres set tituloTres=:tituloTres, paragrafoTres=:paragrafoTres where id=:id")
					 .setParameter("id", modelo.getId())
					 .setParameter("tituloTres", modelo.getTituloTres())
					 .setParameter("paragrafoTres", modelo.getParagrafoTres())
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
	 public void excluirTabelaTres(int id) {
		 EntityManager entityManager = this.getEntityManager();
		 try {
			 entityManager.getTransaction().begin();
			 entityManager.createQuery("delete from TabelaTres where id=:id").setParameter("id", id).executeUpdate();
			 entityManager.getTransaction().commit();
		 }finally {
			 entityManager.close();
		 }
	 }
	 /*metodo para consultar pelo o id
	  * @param id
	  * */
	 public TabelaTres consultarId(int id) {
		 EntityManager entityManager = getEntityManager();
		 TabelaTres modelo = null;
		 try {
			 modelo = entityManager.find(TabelaTres.class, id);
		 }finally {
			 entityManager.close();
		 }
		 return modelo;
	 }
}