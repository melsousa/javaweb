package controle;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import modelo.TabelaUm;
@ManagedBean(name="Atualizar")
public class Atualizar {
	private TabelaUm modeloUm;
	private TabelaUmC controleUm;
	private int id;
	private String tituloUm, paragrafoUm;
	@PostConstruct
	public void init() {
		modeloUm = new TabelaUm();
		controleUm = new TabelaUmC();
	}
	
	public ArrayList<TabelaUm> listar(){
		return(ArrayList<TabelaUm>) controleUm.ListarTabelaUm();
	}
	public void salvar() {
		try {
			modeloUm = controleUm.tabelaUm(modeloUm);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void consultaId(int id) {
		modeloUm = controleUm.consultarUm(id);
		this.setId(modeloUm.getId());
		this.setTituloUm(modeloUm.getTituloUm());
		this.setParagrafoUm(modeloUm.getParagrafoUm());
		
	
	}
	public String excluirUm(int id){
		try {
			System.out.println("excluindo itens da tabela um");
			controleUm.excluirTabelaUm(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTituloUm() {
		return tituloUm;
	}

	public void setTituloUm(String tituloUm) {
		this.tituloUm = tituloUm;
	}
	
	public String getParagrafoUm() {
		return paragrafoUm;
	}

	public void setParagrafoUm(String paragrafoUm) {
		this.paragrafoUm = paragrafoUm;
	}

	public TabelaUm getModeloUm() {
		return modeloUm;
	}
	public void setModeloUm(TabelaUm modeloUm) {
		this.modeloUm = modeloUm;
	}
	public TabelaUmC getControleUm() {
		return controleUm;
	}
	public void setControleUm(TabelaUmC controleUm) {
		this.controleUm = controleUm;
	}
		
}
