/**
 * 
 */
package org.ataf.entities;

import java.sql.Date;

/**
 * @author javier.paris
 */
public class Referee {
	
	private Long id;
	private String name;
	private String surname;
	private String dni;
	private Date birthdate;
	private String address;
	private String city;
	private String country;
	private String alias;	

	/**
	 * Constructor
	 */
	public Referee() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param surname
	 * @param dni
	 * @param birthdate
	 * @param address
	 * @param city
	 * @param country
	 * @param alias
	 */
	public Referee(Long id, String name, String surname, String dni, Date birthdate, String address, String city,
			String country, String alias) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.birthdate = birthdate;
		this.address = address;
		this.city = city;
		this.country = country;
		this.alias = alias;
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}	
	
}