package edu.tongji.se.model;

/**
 * Adverinfo entity. @author MyEclipse Persistence Tools
 */

public class Adverinfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String afBannerPic;
	private String afBannerWordOne;
	private String afBannerWordTwo;
	private String afContentPic;
	private String afContents;
	private Advertisement advertisement;

	// Constructors

	/** default constructor */
	public Adverinfo() {
	}

	/** minimal constructor */
	public Adverinfo(String afBannerPic, String afBannerWordOne,
			String afBannerWordTwo, String afContentPic, String afContents) {
		this.afBannerPic = afBannerPic;
		this.afBannerWordOne = afBannerWordOne;
		this.afBannerWordTwo = afBannerWordTwo;
		this.afContentPic = afContentPic;
		this.afContents = afContents;
	}

	/** full constructor */
	public Adverinfo(String afBannerPic, String afBannerWordOne,
			String afBannerWordTwo, String afContentPic, String afContents,
			Advertisement advertisement) {
		this.afBannerPic = afBannerPic;
		this.afBannerWordOne = afBannerWordOne;
		this.afBannerWordTwo = afBannerWordTwo;
		this.afContentPic = afContentPic;
		this.afContents = afContents;
		this.advertisement = advertisement;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAfBannerPic() {
		return this.afBannerPic;
	}

	public void setAfBannerPic(String afBannerPic) {
		this.afBannerPic = afBannerPic;
	}

	public String getAfBannerWordOne() {
		return this.afBannerWordOne;
	}

	public void setAfBannerWordOne(String afBannerWordOne) {
		this.afBannerWordOne = afBannerWordOne;
	}

	public String getAfBannerWordTwo() {
		return this.afBannerWordTwo;
	}

	public void setAfBannerWordTwo(String afBannerWordTwo) {
		this.afBannerWordTwo = afBannerWordTwo;
	}

	public String getAfContentPic() {
		return this.afContentPic;
	}

	public void setAfContentPic(String afContentPic) {
		this.afContentPic = afContentPic;
	}

	public String getAfContents() {
		return this.afContents;
	}

	public void setAfContents(String afContents) {
		this.afContents = afContents;
	}

	public Advertisement getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}

	

}