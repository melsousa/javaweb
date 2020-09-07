package Hibernate;
import javax.faces.bean.ManagedBean;
import modelo.UsuarioM;
import controle.UsuarioC;

@ManagedBean (name="UsuarioH")
public class UsuarioH {
	UsuarioM modelo = new UsuarioM();
	public void Inserir() throws Exception{
		new UsuarioC().salvar(modelo);
	}
	
}
