package modelo;

import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



//import controle.UsuarioC;
import criptografia.MyCripty;
@Entity
@Table(name="usuario")
 
public class UsuarioM {
		
		public UsuarioM() {
			
		}
		public UsuarioM(String nome, String senha) {
			this.nome= nome;
			this.senha = senha;
		}
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		@Column(name="nome")
		private String nome;
		@Column(name="senha")
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
		public void setSenha(String senha) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
			MyCripty cript = new MyCripty();
			this.senha = cript.cifrar(senha);
		}
		
}
