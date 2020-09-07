package criptografia;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;


public class MyCripty {
	public String cifrar(String texto) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		String resultado = null;
		 Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	     byte[] mensagem = texto.getBytes();

	     // Usando chave de 128-bits (16 bytes)
	     byte[] chave = "chave de 16bytes".getBytes();

	     // Encriptando...
	     try {
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"));
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     byte[] encrypted = cipher.doFinal(mensagem);
	     String resto = Base64.getEncoder().encodeToString(encrypted);
	     resultado = resto;
	return resultado;
	}
	public String decifrar(String texto) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String resultado = null;
		 Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	    String textoB = new String(Base64.getDecoder().decode(texto));
	    byte[] mensagem = textoB.getBytes();

	    // Usando chave de 128-bits (16 bytes)
	    byte[] chave = "chave de 16bytes".getBytes();
	    
	    // Decriptando...
	    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(chave, "AES"));
	    byte[] decrypted = cipher.doFinal(mensagem);
	    resultado = new String(decrypted);
	    return resultado;
	}
}

