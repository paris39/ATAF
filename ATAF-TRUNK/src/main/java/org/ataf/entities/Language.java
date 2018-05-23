/**
 * 
 */
package org.ataf.entities;

/**
 * @author javier.paris
 *
 */
public class Language {
	
	private Long id;
	private String name;
	private String code;
	private boolean active;
	
	
	/**
	 * Constructor
	 */
	public Language() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param name
	 * @param code
	 * @param active
	 */
	public Language(Long id, String name, String code, boolean active) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.active = active;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
}