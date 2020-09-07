/*classe de video
 * @author Melissa de Sousa Felipe
 * @versio 1.0
 * */
package controle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Video;

public class VideoC {
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
	 /*Classe de salvar o caminho do video
	  * @param video
	  * @param titulo
	  * @param texto
	  * 
	  * */
	public Video salvar(Video modelo)throws Exception{
		EntityManager entityManager = this.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(modelo);
			entityManager.getTransaction().commit();
		}finally {
			entityManager.close();
		}
		return modelo;
	}
	/*metodo para listar os videos
	 * @return os dados da tabela
	 * */
	@SuppressWarnings("unchecked")
	public List<Video> findAll(){
		EntityManager entityManager = this.getEntityManager();
		List<Video> modelo = null;
		try {
			modelo = entityManager.createQuery("from Video video").getResultList();
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			entityManager.close();
		}
		return modelo;
	}
	/*metodo para atualizar a tabela video
	 * @param video
	 * @param titulo
	 * @oaram texto
	 * */
	public Video atualizarVideo(Video modelo) throws Exception{
		EntityManager entityManager = this.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			System.out.println("editando tabela do video");
			int u = entityManager.createQuery("update Video set video=:video,titulo=:titulo,texto=:texto where id=:id")
					.setParameter("id", modelo.getId())
					.setParameter("video", modelo.getVideo())
					.setParameter("titulo", modelo.getTitulo())
					.setParameter("texto", modelo.getTexto())
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
	public void excluirVideo(int id) {
		EntityManager entityManager = this.getEntityManager();
		try {
			System.out.println("excluindo dados da tabela video");
			entityManager.getTransaction().begin();
			entityManager.createQuery("delete from Video where id=:id").setParameter("id", id).executeUpdate();
			entityManager.getTransaction().commit();
		}finally {
			entityManager.close();
		}
	}
	/*metodo para consultar o id
	 * @param id
	 * */
	public Video consultaId(int id) {
		EntityManager entityManager = getEntityManager();
		Video modelo= null;
		try {
			modelo = entityManager.find(Video.class, id);
		}finally {
			entityManager.close();
		}
		return modelo;
	}
}
