package edu.tongji.se.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer acBalance;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** minimal constructor */
	public Account(Integer acBalance) {
		this.acBalance = acBalance;
	}

	/** full constructor */
	public Account(Integer acBalance, Set users) {
		this.acBalance = acBalance;
		this.users = users;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAcBalance() {
		return this.acBalance;
	}

	public void setAcBalance(Integer acBalance) {
		this.acBalance = acBalance;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}