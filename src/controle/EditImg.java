package controle;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import modelo.ImageUm;
@ManagedBean(name="EditImg")
public class EditImg {
	private ImageUm modeloImg;
	private ImageC controleImg;
	public Part foto;
	public int id;
	public String imagem,titulo,texto;
	
	
	
	public String atualizarImg() {
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
			modelo= controle.atualizarImg(modelo);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return "editarImg";
	}
	public void consultaId(int id) {
		ImageUm modeloImg = new ImageUm();
		ImageC controleImg = new ImageC();
		modeloImg = controleImg.consultaId(id);
		System.out.println(modeloImg);
		this.setId(modeloImg.getId());
		this.setImagem(modeloImg.getImagem());
		this.setTexto(modeloImg.getTexto());
		this.setTitulo(modeloImg.getTiulo());
	}
	public String excluirImg(int id) {
		try {
			ImageC controleImg = new ImageC();
			controleImg.excluirImagem(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "imgEdit";
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
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
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
	public ImageUm getModeloImg() {
		return modeloImg;
	}
	public void setModeloImg(ImageUm modeloImg) {
		this.modeloImg = modeloImg;
	}
	public ImageC getControleImg() {
		return controleImg;
	}
	public void setControleImg(ImageC controleImg) {
		this.controleImg = controleImg;
	}
	
	
	
}
