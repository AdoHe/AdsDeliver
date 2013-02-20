package edu.tongji.se.model;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Account account;
	private Userinfo userinfo;
	private String usName;
	private String usPassword;
	private String usRand;
	private String usSessionId;
	private Set advertisements = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Account account, Userinfo userinfo, String usName,
			String usPassword, String usRand) {
		this.account = account;
		this.userinfo = userinfo;
		this.usName = usName;
		this.usPassword = usPassword;
		this.usRand = usRand;
	}

	/** full constructor */
	public User(Account account, Userinfo userinfo, String usName,
			String usPassword, String usRand, Set advertisements) {
		this.account = account;
		this.userinfo = userinfo;
		this.usName = usName;
		this.usPassword = usPassword;
		this.usRand = usRand;
		this.advertisements = advertisements;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getUsName() {
		return this.usName;
	}

	public void setUsName(String usName) {
		this.usName = usName;
	}

	public String getUsPassword() {
		return this.usPassword;
	}

	public void setUsPassword(String usPassword) {
		this.usPassword = usPassword;
	}

	public String getUsRand() {
		return this.usRand;
	}

	public void setUsRand(String usRand) {
		this.usRand = usRand;
	}

	public Set getAdvertisements() {
		return this.advertisements;
	}

	public void setAdvertisements(Set advertisements) {
		this.advertisements = advertisements;
	}

	public String getUsSessionId() {
		return usSessionId;
	}

	public void setUsSessionId(String usSessionId) {
		this.usSessionId = usSessionId;
	}

}