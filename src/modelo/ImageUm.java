package modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="imageum")
public class ImageUm{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	@Column(name="imagem")
	public String imagem;
	@Column(name="titulo")
	public String tiulo;
	@Column(name="texto")
	public String texto;
	
	public ImageUm() {
	}
	public ImageUm(int id,String imagem,String tiulo,String texto){
		this.setId(id);
		this.setImagem(imagem);
		this.setTexto(texto);
		this.setTiulo(tiulo);
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getTiulo() {
		return tiulo;
	}

	public void setTiulo(String tiulo) {
		this.tiulo = tiulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	

		
}
