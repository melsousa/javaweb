package controle;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import modelo.TabelaTres;

@ManagedBean(name="Ong")

public class Ong {
	private TabelaTres modeloTres;
	private TabelaTresC controleTres;
	private int id;
	private String tituloTres, paragrafoTres;
	@PostConstruct
	public void init() {
		modeloTres = new TabelaTres();
		controleTres = new TabelaTresC();
	}
	public void atualizarTres() {
		try {
			modeloTres = controleTres.atualizarTres(modeloTres);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void consultaId(int id) {
		modeloTres = controleTres.consultarId(id);
		this.setId(modeloTres.getId());
		this.setTituloTres(modeloTres.getTituloTres());
		this.setParagrafoTres(modeloTres.getParagrafoTres());
	}
	
	public ArrayList<TabelaTres> listarTres(){
		return(ArrayList<TabelaTres>) controleTres.ListarTabelaTres();
	}
	
	public String excluir(int id) {
		try {
			System.out.println("excluindo tabela tres");
			controleTres.excluirTabelaTres(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "index";
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTituloTres() {
		return tituloTres;
	}
	public void setTituloTres(String tituloTres) {
		this.tituloTres = tituloTres;
	}
	public String getParagrafoTres() {
		return paragrafoTres;
	}
	public void setParagrafoTres(String paragrafoTres) {
		this.paragrafoTres = paragrafoTres;
	}
	
}
