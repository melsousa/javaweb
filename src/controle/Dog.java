package controle;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import modelo.TabelaDois;
@ManagedBean(name="Dog")
public class Dog {
	private TabelaDois modeloDois;
	private TabelaDoisC controleDois;
	private int id;
	private String tituloDois, paragrafoDois;
	
	@PostConstruct
	public void init() {
		modeloDois = new TabelaDois();
		controleDois = new TabelaDoisC();
	}
	
	public void salvar() {
		try {
			modeloDois = controleDois.tabelaDois(modeloDois);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void atualizarDois() {
		try {
			modeloDois = controleDois.atualizarDois(modeloDois);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void consultaId(int id) {
		modeloDois = controleDois.consultarId(id);
		this.setId(modeloDois.getId());
		this.setTituloDois(modeloDois.getTituloDois());
		this.setParagrafoDois(modeloDois.getParagrafoDois());
	}
	public ArrayList<TabelaDois> listar(){
		return(ArrayList<TabelaDois>) controleDois.ListarTabelaDois();
	}
	public String excluirDois(int id) {
		try {
			System.out.println("excluindo itens da tabela dois");
			controleDois.excluirTabelaDois(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "index";
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTituloDois() {
		return tituloDois;
	}

	public void setTituloDois(String tituloDois) {
		this.tituloDois = tituloDois;
	}

	public String getParagrafoDois() {
		return paragrafoDois;
	}

	public void setParagrafoDois(String paragrafoDois) {
		this.paragrafoDois = paragrafoDois;
	}
	

}
