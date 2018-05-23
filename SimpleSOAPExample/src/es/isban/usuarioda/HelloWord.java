/**
 * 
 */
package es.isban.usuarioda;

/**
 * @author javier.paris
 */
public class HelloWord {

	/**
	 * 
	 */
	public HelloWord() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param name
	 * @return
	 */
	public UsuarioDA sayHelloWorld(String name) {
		return new UsuarioDA(name, "Hello World");
	}
	
}