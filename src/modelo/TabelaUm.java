package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tabelaUm")
public class TabelaUm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="tituloUm")
	private String tituloUm;
	@Column(name="paragrafoUm")
	private String paragrafoUm;
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
		
}
