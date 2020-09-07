package controle;



//import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import modelo.TabelaDois;
import modelo.TabelaTres;
import modelo.UsuarioM;


@ManagedBean(name="Teste")
@SessionScoped
public class Teste {
	private UsuarioM user;
	private UsuarioC userC;
	private TabelaDois modeloDois;
	private TabelaDoisC controleDois;
	private TabelaTres modeloTres;
	private TabelaTresC controleTres;
	@PostConstruct
	public void init() {
		user = new UsuarioM();
		userC = new UsuarioC();
		modeloDois = new TabelaDois();
		controleDois = new TabelaDoisC();
		modeloTres = new TabelaTres();
		controleTres = new TabelaTresC();
		
	}
	
	public String salvar() {
		if(user.getNome().equals("admin")) {
			
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("usuario",user);
			return "/index?faces-redirect=true";
			
		}else {
			return"/user?faces-redirect=true";
		}
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/user?faces-redirect=true";
	}

	public String excluir(int id) {
		try {
			System.out.println("dudu");
			userC.excluirPorId(id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	public void salvarDois() {
		try {
			modeloDois = controleDois.tabelaDois(modeloDois);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void salvarTres() {
		try {
			modeloTres = controleTres.tabelaTres(modeloTres);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//public ArrayList<UsuarioM> eu(){
		//return (ArrayList<UsuarioM>) userC.findAll();
//}
	
	public UsuarioC getUserC() {
		return userC;
	}
		public void setUserC(UsuarioC userC) {
		this.userC = userC;
	}
	public UsuarioM getUser() {
		return user;
	}

	public void setUser(UsuarioM user) {
		this.user = user;
	}

	public TabelaDois getModeloDois() {
		return modeloDois;
	}

	public void setModeloDois(TabelaDois modeloDois) {
		this.modeloDois = modeloDois;
	}

	public TabelaDoisC getControleDois() {
		return controleDois;
	}
	
	
	public void setControleDois(TabelaDoisC controleDois) {
		this.controleDois = controleDois;
	}

	public TabelaTres getModeloTres() {
		return modeloTres;
	}

	public void setModeloTres(TabelaTres modeloTres) {
		this.modeloTres = modeloTres;
	}

	public TabelaTresC getControleTres() {
		return controleTres;
	}

	public void setControleTres(TabelaTresC controleTres) {
		this.controleTres = controleTres;
	}
	
	
}
