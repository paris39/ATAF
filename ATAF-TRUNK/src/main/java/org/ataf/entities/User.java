/**
 * 
 */
package org.ataf.entities;

import java.util.HashSet;
import java.util.Set;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;

/**
 * @author javier.paris
 */
//@Entity
//@Table(name = "LOGIN_USER")
public class User {
	
	private Long id;
	private String alias;
	private String password;
	private String email;
	private String name;
	private String surname;
	private Boolean active;
	
	private Set<Role> roles = new HashSet<Role>(0);
	
	/**
	 * Constructor
	 */
	public User() {
	}
	
	/**
	 * @param id
	 * @param email
	 * @param alias
	 * @param password
	 * @param name
	 * @param surname
	 * @param active
	 */
	public User(Long id, String email, String alias, String password, String name, String surname, Boolean active) {
		this.id = id;
		this.email = email;
		this.alias = alias;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.active = active;
	}

	/**
	 * @return the email
	 */
//	@Column (name = "EMAIL")
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the alias
	 */
//	@Column (name = "ALIAS")
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the password
	 */
//	@Column (name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the id
	 */
//	@Id
//    @GeneratedValue
//    @Column(name = "ID")
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
//	@Column (name = "NAME")
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
//	@Column (name = "SURNAME")
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
	 * @return the active
	 */
//	@Column (name = "ACTIVE")
	public Boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


}