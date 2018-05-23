/**
 * 
 */
package org.ataf.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author javier.paris
 *
 */
public class Util {

	/**
	 * Constructor
	 */
	public Util() {
	}
	
	// Est�ticos
	public static final String CLASS_CAN_WRITE = "personalDataDiv";
	public static final String CLASS_READ_ONLY = "personalDataDivReadOnly";
	
	/**
	 * @param text
	 * @return Encrpyt text
	 */
	public static String cryptMD5(String text) {
		try {
			final char[] HEXADECIMALES = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	 
			MessageDigest msgdgt = MessageDigest.getInstance("MD5");
			byte[] bytes = msgdgt.digest(text.getBytes());
			StringBuilder strCryptMD5 = new StringBuilder(2 * bytes.length);
			for (int i = 0; i < bytes.length; i++) {
				int low = (int)(bytes[i] & 0x0f);
				int high = (int)((bytes[i] & 0xf0) >> 4);
				strCryptMD5.append(HEXADECIMALES[high]);
				strCryptMD5.append(HEXADECIMALES[low]);
			}
	   		return strCryptMD5.toString();
	    } catch (NoSuchAlgorithmException e) {
    		return null;
	    }
	}
	
	/**
	 * @throws Exception
	 */
	public static void cleanSessionVariables() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		try {
			session.put("messageFlag", false); // Interruptor de mensajes a Index
			session.remove("messageBody");
			session.put("refereeReadOnly", true); // Valor para controlar los campos de s�lo lectura y que puedan ser desbloqueados al Modificar el �rbitro
			session.put("refereeModifyFlag", false); // Interruptor de modificaci�n de �rbitro
			session.put("refereeCssClassTextField", CLASS_READ_ONLY); // Clase de estilos para visualizar campos de s�lo lectura
			session.remove("newUserErrorMessages"); // Mensajes de errores al crear un nuevo usuario. Modo Administrador
		} catch (Exception e) {
			
		}
	}
	
}