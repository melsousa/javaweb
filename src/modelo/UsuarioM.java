package modelo;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import controle.UsuarioC;

@Entity
@Table(name="usuario")
 
@ManagedBean(name="UsuarioM")
public class UsuarioM {
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		@Column(name="nome", nullable=false)
		private String nome;
		@Column(name="senha", nullable = false)
		private String senha;
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
		
		public void Salvar() {
			try {
				new UsuarioC().salvar(this);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
