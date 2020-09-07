package controle;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;


import modelo.Video;

@ManagedBean(name="Videoupload")
public class Videoupload {
	private Video modelo;
	private VideoC controle;
	public Part video;
	public int id;
	public String titulo;
	public String texto;
	

	public String salvarVideo() throws Exception{
		try {
		String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
		InputStream img = video.getInputStream();
		String imgNome = video.getSubmittedFileName();
		int imgDiv = imgNome.lastIndexOf('.');
		String ext = imgNome.substring(imgDiv);
		imgNome = titulo + ext;
		Files.copy(img, new File(realPath+ "video", imgNome).toPath(),StandardCopyOption.REPLACE_EXISTING);
		Video modelo = new Video(this.getId(), this.getTitulo(), this.getTexto(),"video/"+imgNome);
		VideoC controle = new VideoC();
		modelo= controle.salvar(modelo);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			 
		}
		return "adicionarVideo";
		
	}
		public List<Video> listar(){
			controle = new VideoC();
			return controle.findAll();
		}
	
	public Part getVideo() {
		return video;
	}
	public void setVideo(Part video) {
		this.video = video;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
