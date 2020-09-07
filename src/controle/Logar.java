package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import modelo.UsuarioM;

@ManagedBean(name="Logar")
@SessionScoped
public class Logar {
	private UsuarioM modelo;
	
	public Logar() {
		modelo = new UsuarioM();
	}
	public String LogarNoSistema() {
		if(modelo.getNome().equals("admin") && modelo.getSenha().equals("admin")) {
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("usuario",modelo);
			return "/app/admin?faces-redirect=true";
		}else {
			return "/seguranca/user?faces-redirect=true";
		}
	}
	
	public UsuarioM getModelo() {
		return modelo;
	}

	public void setModelo(UsuarioM modelo) {
		this.modelo = modelo;
	}
	
	
	
}
