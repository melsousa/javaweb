package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="video")
public class Video {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="video")
	private String video;
	@Column(name="titulo")
	private String titulo;
	@Column(name="texto")
	private String texto;
	public Video() {
		
	}
	public Video(int id, String video,String titulo,String texto) {
		this.setId(id);
		this.setVideo(video);
		this.setTitulo(titulo);
		this.setTexto(texto);
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	

}
