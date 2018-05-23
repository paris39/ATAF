/**
 * 
 */
package org.ataf.entities;

/**
 * @author javier.paris
 */
public class Competition {
	
	private Long id;
	private String name;
	private Long idCategory;
	private Long idSeason;
	
	/**
	 * Constructor
	 */
	public Competition() {
	}

	/**
	 * @param id
	 * @param name
	 * @param idCategory
	 * @param idSeason
	 */
	public Competition(Long id, String name, Long idCategory, Long idSeason) {
		this.id = id;
		this.name = name;
		this.idCategory = idCategory;
		this.idSeason = idSeason;
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
	 * @return the idCategory
	 */
	public Long getIdCategory() {
		return idCategory;
	}

	/**
	 * @param idCategory the idCategory to set
	 */
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	/**
	 * @return the idSeason
	 */
	public Long getIdSeason() {
		return idSeason;
	}

	/**
	 * @param idSeason the idSeason to set
	 */
	public void setIdSeason(Long idSeason) {
		this.idSeason = idSeason;
	}
	
}