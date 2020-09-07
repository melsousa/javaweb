/*classe de imagem
 * @author Melissa de Sousa Felipe
 * @version 1.2
 * 
 * */
package controle;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import modelo.ImageUm;
public class ImageC {

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
	 /*Classe de salvar o caminho do imagem
	  * @param imagem
	  * @param titulo
	  * @param texto
	  * 
	  * */
	
	public ImageUm salvar(ImageUm modelo) throws Exception{
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
	/*metodo para listar as imagens
	 * @return os dados da tabela
	 * */
	@SuppressWarnings("unchecked")
	public List<ImageUm> findAll(){
		EntityManager entityManager = this.getEntityManager();
		List<ImageUm> modelo = null;
		try {
			modelo = entityManager.createQuery("from ImageUm imageum").getResultList();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			entityManager.close();
		}

		return modelo;
	}
	/*metodo atualização dos dados 
	 * @param imagem
	 * @param titulo
	 * @param texto
	 * */
	public ImageUm atualizarImg(ImageUm modelo) throws Exception{
		EntityManager entityManager = this.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			System.out.println("editando tabela de imagem");
			int u = entityManager.createQuery("update ImageUm set imagem=:imagem, titulo=:titulo, texto=:texto where id=:id")
					.setParameter("id", modelo.getId())
					.setParameter("imagem", modelo.getImagem())
					.setParameter("titulo", modelo.getTiulo())
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
	public void excluirImagem(int id) {
		EntityManager entityManager = this.getEntityManager();
		try {
			System.out.println("excluindo dados da tabela imagem");
			entityManager.getTransaction().begin();
			entityManager.createQuery("delete from ImageUm where id=:id").setParameter("id", id).executeUpdate();
			entityManager.getTransaction().commit();
		}finally {
			entityManager.close();
		}
	}
	/*metodo para consulta o Id
	 * @param id
	 * 
	 * */
	public ImageUm consultaId(int id) {
		EntityManager entityManager = getEntityManager();
		ImageUm modelo = null;
		try {
			modelo = entityManager.find(ImageUm.class, id);
		}finally {
			entityManager.close();
		}
		return modelo;
	}
	
}
