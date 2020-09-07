package controle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import modelo.ImageUm;

@ManagedBean(name="Fileupload")

public class Fileupload {
	private ImageUm modelo;
	private ImageC controle;
	public Part foto;
	public int id;
	public String titulo;
	public String texto;
	 
	
	public String salvarImagem() throws Exception{
		try {
		String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
		InputStream img = foto.getInputStream();
		String imgNome = foto.getSubmittedFileName();
		int imgDiv = imgNome.lastIndexOf('.');
		String ext = imgNome.substring(imgDiv);
		imgNome = titulo + ext;
		Files.copy(img, new File(realPath+ "img", imgNome).toPath(),StandardCopyOption.REPLACE_EXISTING);
		ImageUm modelo = new ImageUm(this.getId(), this.getTitulo(), this.getTexto(),"img/"+imgNome);
		ImageC controle = new ImageC();
		modelo= controle.salvar(modelo);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			 
		}
		return "imgEdit";
		
	}
	public List<ImageUm> listar(){
		controle = new ImageC();
		return controle.findAll();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Part getFoto() {
		return foto;
	}
	public void setFoto(Part foto) {
		this.foto = foto;
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
