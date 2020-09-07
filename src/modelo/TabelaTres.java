package modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tabelaTres")

public class TabelaTres {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="tituloTres")
	private String tituloTres;
	@Column(name="paragrafoTres")
	private String paragrafoTres;
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
