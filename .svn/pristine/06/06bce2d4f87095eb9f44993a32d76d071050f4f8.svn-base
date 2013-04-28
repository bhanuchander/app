package com.schooltrix.hibernate;

import java.sql.Timestamp;

/**
 * SentSms entity. @author MyEclipse Persistence Tools
 */

public class SentSms implements java.io.Serializable {

	// Fields

	private Long sno;
	private String imId;
	private String bmId;
	private String smId;
	private String smsBody;
	private String noToSent;
	private String smsBalanceCredits;
	private String userListFileName;
	private String status;
	private Timestamp reqTime;
	private Timestamp processedTime;

	// Constructors

	/** default constructor */
	public SentSms() {
	}

	/** minimal constructor */
	public SentSms(String status, Timestamp reqTime, Timestamp processedTime) {
		this.status = status;
		this.reqTime = reqTime;
		this.processedTime = processedTime;
	}

	/** full constructor */
	public SentSms(String imId, String bmId, String smId, String smsBody,
			String noToSent, String smsBalanceCredits, String userListFileName,
			String status, Timestamp reqTime, Timestamp processedTime) {
		this.imId = imId;
		this.bmId = bmId;
		this.smId = smId;
		this.smsBody = smsBody;
		this.noToSent = noToSent;
		this.smsBalanceCredits = smsBalanceCredits;
		this.userListFileName = userListFileName;
		this.status = status;
		this.reqTime = reqTime;
		this.processedTime = processedTime;
	}

	// Property accessors

	public Long getSno() {
		return this.sno;
	}

	public void setSno(Long sno) {
		this.sno = sno;
	}

	public String getImId() {
		return this.imId;
	}

	public void setImId(String imId) {
		this.imId = imId;
	}

	public String getBmId() {
		return this.bmId;
	}

	public void setBmId(String bmId) {
		this.bmId = bmId;
	}

	public String getSmId() {
		return this.smId;
	}

	public void setSmId(String smId) {
		this.smId = smId;
	}

	public String getSmsBody() {
		return this.smsBody;
	}

	public void setSmsBody(String smsBody) {
		this.smsBody = smsBody;
	}

	public String getNoToSent() {
		return this.noToSent;
	}

	public void setNoToSent(String noToSent) {
		this.noToSent = noToSent;
	}

	public String getSmsBalanceCredits() {
		return this.smsBalanceCredits;
	}

	public void setSmsBalanceCredits(String smsBalanceCredits) {
		this.smsBalanceCredits = smsBalanceCredits;
	}

	public String getUserListFileName() {
		return this.userListFileName;
	}

	public void setUserListFileName(String userListFileName) {
		this.userListFileName = userListFileName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getReqTime() {
		return this.reqTime;
	}

	public void setReqTime(Timestamp reqTime) {
		this.reqTime = reqTime;
	}

	public Timestamp getProcessedTime() {
		return this.processedTime;
	}

	public void setProcessedTime(Timestamp processedTime) {
		this.processedTime = processedTime;
	}

}