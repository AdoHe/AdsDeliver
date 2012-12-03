package edu.tongji.se.model;

import java.sql.Timestamp;

import org.apache.struts2.json.annotations.JSON;


/**
 * Record entity. @author MyEclipse Persistence Tools
 */

public class Record  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
     private Account account;
     private Timestamp reDate;
     private Integer reIncome;
     private Integer reOutcome;
     private Integer reBalance;
     private String reCategory;


    // Constructors

    /** default constructor */
    public Record() {
    }

    
    /** full constructor */
    public Record(Account account, Timestamp reDate, Integer reIncome, Integer reOutcome, Integer reBalance, String reCategory) {
        this.account = account;
        this.reDate = reDate;
        this.reIncome = reIncome;
        this.reOutcome = reOutcome;
        this.reBalance = reBalance;
        this.reCategory = reCategory;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @JSON(deserialize=true)
    public Account getAccount() {
        return this.account;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }

    public Timestamp getReDate() {
        return this.reDate;
    }
    
    public void setReDate(Timestamp reDate) {
        this.reDate = reDate;
    }

    public Integer getReIncome() {
        return this.reIncome;
    }
    
    public void setReIncome(Integer reIncome) {
        this.reIncome = reIncome;
    }

    public Integer getReOutcome() {
        return this.reOutcome;
    }
    
    public void setReOutcome(Integer reOutcome) {
        this.reOutcome = reOutcome;
    }

    public Integer getReBalance() {
        return this.reBalance;
    }
    
    public void setReBalance(Integer reBalance) {
        this.reBalance = reBalance;
    }

    public String getReCategory() {
        return this.reCategory;
    }
    
    public void setReCategory(String reCategory) {
        this.reCategory = reCategory;
    }
   








}