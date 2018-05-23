/**
 * 
 */
package es.isban.usuarioda;

/**
 * @author javier.paris
 *
 */
public class UsuarioDA {

	private String name;
	private String activeDirectory;
	
	/**
	 * Constructor
	 */
	public UsuarioDA() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param name
	 * @param activeDirectory
	 */
	public UsuarioDA(String name, String activeDirectory) {
		this.name = name;
		this.activeDirectory = activeDirectory;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the activeDirectory
	 */
	public String getActiveDirectory() {
		return activeDirectory;
	}
	
	/**
	 * @param activeDirectory the activeDirectory to set
	 */
	public void setActiveDirectory(String activeDirectory) {
		this.activeDirectory = activeDirectory;
	}
}
