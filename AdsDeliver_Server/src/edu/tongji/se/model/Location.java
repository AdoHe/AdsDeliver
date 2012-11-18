package edu.tongji.se.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Location entity. @author MyEclipse Persistence Tools
 */

public class Location implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Float lcLongitude;
	private Float lcLatitude;
	private Set advertisements = new HashSet(0);

	// Constructors

	/** default constructor */
	public Location() {
	}

	/** minimal constructor */
	public Location(Float lcLongitude, Float lcLatitude) {
		this.lcLongitude = lcLongitude;
		this.lcLatitude = lcLatitude;
	}

	/** full constructor */
	public Location(Float lcLongitude, Float lcLatitude, Set advertisements) {
		this.lcLongitude = lcLongitude;
		this.lcLatitude = lcLatitude;
		this.advertisements = advertisements;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getLcLongitude() {
		return this.lcLongitude;
	}

	public void setLcLongitude(Float lcLongitude) {
		this.lcLongitude = lcLongitude;
	}

	public Float getLcLatitude() {
		return this.lcLatitude;
	}

	public void setLcLatitude(Float lcLatitude) {
		this.lcLatitude = lcLatitude;
	}

	public Set getAdvertisements() {
		return this.advertisements;
	}

	public void setAdvertisements(Set advertisements) {
		this.advertisements = advertisements;
	}

}