package edu.tongji.se.model;

/**
 * Price entity. @author MyEclipse Persistence Tools
 */

public class Price implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short id;
	private Float pcBanner;
	private Float pcContent;

	// Constructors

	/** default constructor */
	public Price() {
	}

	/** full constructor */
	public Price(Float pcBanner, Float pcContent) {
		this.pcBanner = pcBanner;
		this.pcContent = pcContent;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Float getPcBanner() {
		return this.pcBanner;
	}

	public void setPcBanner(Float pcBanner) {
		this.pcBanner = pcBanner;
	}

	public Float getPcContent() {
		return this.pcContent;
	}

	public void setPcContent(Float pcContent) {
		this.pcContent = pcContent;
	}

}