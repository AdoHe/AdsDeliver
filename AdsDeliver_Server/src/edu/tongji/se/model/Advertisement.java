package edu.tongji.se.model;

import java.sql.Timestamp;

/**
 * Advertisement entity. @author MyEclipse Persistence Tools
 */

public class Advertisement implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Adverinfo adverinfo;
	private Location location;
	private User user;
	private String avName;
	private String avAddress;
	private Short avStatus;
	private Integer avClickTimes;
	private Integer avShowTimes;
	private Timestamp avPublishTime;
	private String avDesc;
	
	// Constructors

	/** default constructor */
	public Advertisement() {
	}

	/** full constructor */
	public Advertisement(Adverinfo adverinfo, Location location, User user,
			String avName, String avAddress, Short avStatus,
			Integer avClickTimes, Integer avShowTimes, Timestamp avPublishTime, String avDesc) {
		this.adverinfo = adverinfo;
		this.location = location;
		this.user = user;
		this.avName = avName;
		this.avAddress = avAddress;
		this.avStatus = avStatus;
		this.avClickTimes = avClickTimes;
		this.avShowTimes = avShowTimes;
		this.avPublishTime = avPublishTime;
		this.avDesc = avDesc;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Adverinfo getAdverinfo() {
		return this.adverinfo;
	}

	public void setAdverinfo(Adverinfo adverinfo) {
		this.adverinfo = adverinfo;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAvName() {
		return this.avName;
	}

	public void setAvName(String avName) {
		this.avName = avName;
	}

	public String getAvAddress() {
		return this.avAddress;
	}

	public void setAvAddress(String avAddress) {
		this.avAddress = avAddress;
	}

	public Short getAvStatus() {
		return this.avStatus;
	}

	public void setAvStatus(Short avStatus) {
		this.avStatus = avStatus;
	}

	public Integer getAvClickTimes() {
		return this.avClickTimes;
	}

	public void setAvClickTimes(Integer avClickTimes) {
		this.avClickTimes = avClickTimes;
	}

	public Integer getAvShowTimes() {
		return this.avShowTimes;
	}

	public void setAvShowTimes(Integer avShowTimes) {
		this.avShowTimes = avShowTimes;
	}

	public Timestamp getAvPublishTime() {
		return this.avPublishTime;
	}

	public void setAvPublishTime(Timestamp avPublishTime) {
		this.avPublishTime = avPublishTime;
	}

	public String getAvDesc() {
		return avDesc;
	}

	public void setAvDesc(String avDesc) {
		this.avDesc = avDesc;
	}

}