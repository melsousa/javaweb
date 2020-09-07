package modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tabelaDois")

public class TabelaDois {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="tituloDois")
	private String tituloDois;
	@Column(name="paragrafoDois")
	private String paragrafoDois;
	
	
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
