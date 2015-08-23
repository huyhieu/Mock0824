package com.viettel.data.model.entity;

// Generated Aug 6, 2015 9:16:39 AM by Hibernate Tools 4.3.1

import globaldefine.Config;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


import com.viettel.data.query.MockUserQuery;

/**
 * 
 * @author hieuph
 *
 */

@Entity
@javax.persistence.NamedNativeQueries({
		@javax.persistence.NamedNativeQuery(name = MockUserQuery.GET_USER_BY_EMAIL_NAME, query = MockUserQuery.GET_USER_BY_EMAIL, resultClass = MockUser.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")),
		@javax.persistence.NamedNativeQuery(name = MockUserQuery.GET_USER_BY_ID_NAME, query = MockUserQuery.GET_USER_BY_ID, resultClass = MockUser.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")),
		@javax.persistence.NamedNativeQuery(name = MockUserQuery.LOGIN_USER_NAME, query = MockUserQuery.LOGIN_USER, resultClass = MockUser.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")),
		@javax.persistence.NamedNativeQuery(name = MockUserQuery.LOGIN_USER_NAME_NEW_PASS_NAME, query = MockUserQuery.LOGIN_USER_NAME_NEW_PASS_QUERY, resultClass = MockUser.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")),
		@javax.persistence.NamedNativeQuery(name = MockUserQuery.GET_ALL_USERS_NAME, query = MockUserQuery.GET_ALL_USERS, resultClass = MockUser.class, hints = @javax.persistence.QueryHint(name = Config.callable, value = "true")) })
@Table(name = "MOCK_USER", uniqueConstraints = @UniqueConstraint(columnNames = "USER_EMAIL"))
public class MockUser {

	private Long userId;
	private Long roleUserId;
	private String userEmail;
	private String userName;
	private String userAddress;
	private String userWebsite;
	private String userPhone;
	private String userPassword;
	private Date userBirthday;
	private Long userSex;
	private Long userIsactive;
	private String userActiveCode;
	private Date userRegistTime;
	private Long zoneId;
	private String userNewPassword;
	private Date userDateChangePass;

	public MockUser() {
	}

	public MockUser(Long userId) {
		this.userId = userId;
	}

	public MockUser(Long userId, Long roleUserId, String userEmail, String userName, String userAddress, String userWebsite, String userPhone, String userPassword, Date userBirthday, Long userSex, Long userIsactive, String userActiveCode, Date userRegistTime, Long zoneId, String userNewPassword, Date userDateChangePass) {
		this.userId = userId;
		this.roleUserId = roleUserId;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userWebsite = userWebsite;
		this.userPhone = userPhone;
		this.userPassword = userPassword;
		this.userBirthday = userBirthday;
		this.userSex = userSex;
		this.userIsactive = userIsactive;
		this.userActiveCode = userActiveCode;
		this.userRegistTime = userRegistTime;
		this.zoneId = zoneId;
		this.userNewPassword = userNewPassword;
		this.userDateChangePass = userDateChangePass;
	}

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "ROLE_USER_ID", precision = 22, scale = 0)
	public Long getRoleUserId() {
		return this.roleUserId;
	}

	public void setRoleUserId(Long roleUserId) {
		this.roleUserId = roleUserId;
	}

	@Column(name = "USER_EMAIL", length = 100)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "USER_NAME", length = 500)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "USER_ADDRESS", length = 500)
	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Column(name = "USER_WEBSITE", length = 500)
	public String getUserWebsite() {
		return this.userWebsite;
	}

	public void setUserWebsite(String userWebsite) {
		this.userWebsite = userWebsite;
	}

	@Column(name = "USER_PHONE", length = 500)
	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "USER_PASSWORD", length = 500)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "USER_BIRTHDAY", length = 7)
	public Date getUserBirthday() {
		return this.userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	@Column(name = "USER_SEX", precision = 22, scale = 0)
	public Long getUserSex() {
		return this.userSex;
	}

	public void setUserSex(Long userSex) {
		this.userSex = userSex;
	}

	@Column(name = "USER_ISACTIVE", precision = 22, scale = 0)
	public Long getUserIsactive() {
		return this.userIsactive;
	}

	public void setUserIsactive(Long userIsactive) {
		this.userIsactive = userIsactive;
	}

	@Column(name = "USER_ACTIVE_CODE", length = 1000)
	public String getUserActiveCode() {
		return this.userActiveCode;
	}

	public void setUserActiveCode(String userActiveCode) {
		this.userActiveCode = userActiveCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "USER_REGIST_TIME", length = 7)
	public Date getUserRegistTime() {
		return this.userRegistTime;
	}

	public void setUserRegistTime(Date userRegistTime) {
		this.userRegistTime = userRegistTime;
	}

	@Column(name = "ZONE_ID", precision = 22, scale = 0)
	public Long getZoneId() {
		return this.zoneId;
	}

	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}

	@Column(name = "USER_NEW_PASSWORD", length = 500)
	public String getUserNewPassword() {
		return this.userNewPassword;
	}

	public void setUserNewPassword(String userNewPassword) {
		this.userNewPassword = userNewPassword;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "USER_DATE_CHANGE_PASS", length = 7)
	public Date getUserDateChangePass() {
		return this.userDateChangePass;
	}

	public void setUserDateChangePass(Date userDateChangePass) {
		this.userDateChangePass = userDateChangePass;
	}

}
