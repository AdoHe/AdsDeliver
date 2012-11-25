package edu.tongji.se.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String ufName;
	private String ufCorperation;
	private String ufMobilePhone;
	private String ufTelephone;
	private String ufAddress;
	private Short ufStatus;
	private User user;

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String ufName, String ufCorperation, String ufAddress,
			Short ufStatus) {
		this.ufName = ufName;
		this.ufCorperation = ufCorperation;
		this.ufAddress = ufAddress;
		this.ufStatus = ufStatus;
	}

	/** full constructor */
	public Userinfo(String ufName, String ufCorperation, String ufMobilePhone,
			String ufTelephone, String ufAddress, Short ufStatus, User users) {
		this.ufName = ufName;
		this.ufCorperation = ufCorperation;
		this.ufMobilePhone = ufMobilePhone;
		this.ufTelephone = ufTelephone;
		this.ufAddress = ufAddress;
		this.ufStatus = ufStatus;
		this.user = users;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUfName() {
		return this.ufName;
	}

	public void setUfName(String ufName) {
		this.ufName = ufName;
	}

	public String getUfCorperation() {
		return this.ufCorperation;
	}

	public void setUfCorperation(String ufCorperation) {
		this.ufCorperation = ufCorperation;
	}

	public String getUfMobilePhone() {
		return this.ufMobilePhone;
	}

	public void setUfMobilePhone(String ufMobilePhone) {
		this.ufMobilePhone = ufMobilePhone;
	}

	public String getUfTelephone() {
		return this.ufTelephone;
	}

	public void setUfTelephone(String ufTelephone) {
		this.ufTelephone = ufTelephone;
	}

	public String getUfAddress() {
		return this.ufAddress;
	}

	public void setUfAddress(String ufAddress) {
		this.ufAddress = ufAddress;
	}

	public Short getUfStatus() {
		return this.ufStatus;
	}

	public void setUfStatus(Short ufStatus) {
		this.ufStatus = ufStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}