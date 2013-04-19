package com.schooltrix.hibernate;

import java.sql.Timestamp;

/**
 * UploadDocuments entity. @author MyEclipse Persistence Tools
 */

public class UploadDocuments implements java.io.Serializable {

	// Fields

	private Long sno;
	private String imId;
	private String bmId;
	private String smId;
	private String toWhich;
	private String toWhome;
	private String uploadType;
	private String assignType;
	private String subject;
	private String fileName;
	private String notifyPaEmail;
	private String notifyPaEmailFlag;
	private String notifyPaSms;
	private String notifyPaSmsFlag;
	private Timestamp uploadDate;

	// Constructors

	/** default constructor */
	public UploadDocuments() {
	}

	/** minimal constructor */
	public UploadDocuments(String toWhich, String toWhome, String uploadType,
			String fileName, String notifyPaEmail, String notifyPaSms) {
		this.toWhich = toWhich;
		this.toWhome = toWhome;
		this.uploadType = uploadType;
		this.fileName = fileName;
		this.notifyPaEmail = notifyPaEmail;
		this.notifyPaSms = notifyPaSms;
	}

	/** full constructor */
	public UploadDocuments(String imId, String bmId, String smId,
			String toWhich, String toWhome, String uploadType,
			String assignType, String subject, String fileName,
			String notifyPaEmail, String notifyPaEmailFlag, String notifyPaSms,
			String notifyPaSmsFlag, Timestamp uploadDate) {
		this.imId = imId;
		this.bmId = bmId;
		this.smId = smId;
		this.toWhich = toWhich;
		this.toWhome = toWhome;
		this.uploadType = uploadType;
		this.assignType = assignType;
		this.subject = subject;
		this.fileName = fileName;
		this.notifyPaEmail = notifyPaEmail;
		this.notifyPaEmailFlag = notifyPaEmailFlag;
		this.notifyPaSms = notifyPaSms;
		this.notifyPaSmsFlag = notifyPaSmsFlag;
		this.uploadDate = uploadDate;
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

	public String getToWhich() {
		return this.toWhich;
	}

	public void setToWhich(String toWhich) {
		this.toWhich = toWhich;
	}

	public String getToWhome() {
		return this.toWhome;
	}

	public void setToWhome(String toWhome) {
		this.toWhome = toWhome;
	}

	public String getUploadType() {
		return this.uploadType;
	}

	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}

	public String getAssignType() {
		return this.assignType;
	}

	public void setAssignType(String assignType) {
		this.assignType = assignType;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getNotifyPaEmail() {
		return this.notifyPaEmail;
	}

	public void setNotifyPaEmail(String notifyPaEmail) {
		this.notifyPaEmail = notifyPaEmail;
	}

	public String getNotifyPaEmailFlag() {
		return this.notifyPaEmailFlag;
	}

	public void setNotifyPaEmailFlag(String notifyPaEmailFlag) {
		this.notifyPaEmailFlag = notifyPaEmailFlag;
	}

	public String getNotifyPaSms() {
		return this.notifyPaSms;
	}

	public void setNotifyPaSms(String notifyPaSms) {
		this.notifyPaSms = notifyPaSms;
	}

	public String getNotifyPaSmsFlag() {
		return this.notifyPaSmsFlag;
	}

	public void setNotifyPaSmsFlag(String notifyPaSmsFlag) {
		this.notifyPaSmsFlag = notifyPaSmsFlag;
	}

	public Timestamp getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Timestamp uploadDate) {
		this.uploadDate = uploadDate;
	}

}