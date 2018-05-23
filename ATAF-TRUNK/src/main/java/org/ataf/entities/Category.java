/**
 * 
 */
package org.ataf.entities;

/**
 * @author javier.paris
 *
 */
public class Category {
	
	private Long id;
	private String name;
	private Integer duration;

	/**
	 * Constructor
	 */
	public Category() {
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param duration
	 */
	public Category(Long id, String name, Integer duration) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
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
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
}