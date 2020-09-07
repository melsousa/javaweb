package controle;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;



import modelo.Video;
@ManagedBean(name="EditVideo")
public class EditVideo {
	private Video modelo;
	private VideoC controle;
	public Part upload;
	public int id;
	public String video,titulo,texto;
	
	public String atualizarVideo() {
		try {
			String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
			InputStream img = upload.getInputStream();
			String imgNome = upload.getSubmittedFileName();
			int imgDiv = imgNome.lastIndexOf('.');
			String ext = imgNome.substring(imgDiv);
			imgNome = titulo + ext;
			Files.copy(img, new File(realPath+ "video", imgNome).toPath(),StandardCopyOption.REPLACE_EXISTING);
			Video modelo = new Video(this.getId(), this.getTitulo(), this.getTexto(),"video/"+imgNome);
			VideoC controle = new VideoC();
			modelo= controle.atualizarVideo(modelo);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		return "EditarVideo";
	}
	public void consultaId(int id) {
		Video modelo = new Video();
		VideoC controle = new VideoC();
		modelo = controle.consultaId(id);
		this.setId(modelo.getId());
		this.setVideo(modelo.getVideo());
		this.setTexto(modelo.getTexto());
		this.setTitulo(modelo.getTitulo());
	}
	public String excluirVideo(int id) {
		try {
			VideoC controle = new VideoC();
			controle.excluirVideo(id);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "index";
	}
	public Video getModelo() {
		return modelo;
	}

	public void setModelo(Video modelo) {
		this.modelo = modelo;
	}

	public VideoC getControle() {
		return controle;
	}

	public void setControle(VideoC controle) {
		this.controle = controle;
	}

	public Part getUpload() {
		return upload;
	}

	public void setUpload(Part upload) {
		this.upload = upload;
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
