package controle;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


import modelo.UsuarioM;

@ManagedBean(name="Mostrar")

public class Mostrar {
	private UsuarioM user;
	private UsuarioC userC;
	
	
	private int id;
	private String nome, senha;
	@PostConstruct
	public void init() {
		user = new UsuarioM();
		userC = new UsuarioC();
	}
	public ArrayList<UsuarioM> eu(){
		return (ArrayList<UsuarioM>) userC.findAll();
	}
	public void atualizar() {
		try {
			user = userC.atualizar(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void carregarId(int id) {
		user = userC.consultarPorId(id);
		this.setId(user.getId());
		this.setNome(user.getNome());
		this.setSenha(user.getSenha());
		
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
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
	
	
}
