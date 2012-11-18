package edu.tongji.se.model;

/**
 * Administrator entity. @author MyEclipse Persistence Tools
 */

public class Administrator implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short id;
	private String adName;
	private String adPassword;
	private Short adLevel;
	private String adRand;

	// Constructors

	/** default constructor */
	public Administrator() {
	}

	/** full constructor */
	public Administrator(String adName, String adPassword, Short adLevel,
			String adRand) {
		this.adName = adName;
		this.adPassword = adPassword;
		this.adLevel = adLevel;
		this.adRand = adRand;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getAdName() {
		return this.adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getAdPassword() {
		return this.adPassword;
	}

	public void setAdPassword(String adPassword) {
		this.adPassword = adPassword;
	}

	public Short getAdLevel() {
		return this.adLevel;
	}

	public void setAdLevel(Short adLevel) {
		this.adLevel = adLevel;
	}

	public String getAdRand() {
		return this.adRand;
	}

	public void setAdRand(String adRand) {
		this.adRand = adRand;
	}

}