package edu.tongji.se.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

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
	
	private User user;

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** minimal constructor */
	public Account(Integer acBalance) {
		this.acBalance = acBalance;
	}

	/** full constructor */
	public Account(Integer acBalance, User users) {
		this.acBalance = acBalance;
		this.user = users;
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

	@JSON(serialize=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	

}