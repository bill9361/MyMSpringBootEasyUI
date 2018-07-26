package com.bill.msbeui.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

/**
 * Description: 用户表<br/>
 * Date:2018年7月20日 上午10:43:26 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@SuppressWarnings("serial")
public class User extends BaseEntity
{
	@NotNull(message="用户名不能为空")
	@Pattern(regexp="\\w{3,16}",message="用户名必须为3-16位数字、字母、下划线组合")
    private String username;		//登录名

	@NotNull(message="用户名不能为空")
	@Pattern(regexp="\\w{3,16}",message="用户名必须为3-16位数字、字母、下划线组合")
    private String password;		//密码

	@NotNull(message = "姓名不能为空")
	@Pattern(regexp = "[[\u4e00-\u9fa5]\\w]{4,32}", message = "姓名必须为4-32位数字、字母、下划线汉字组合")
    private String fullname;		//姓名
    private String idNumber;		//身份证号
    private String dateOfBirth;		//出生日期
    private Integer isLock;			//是否锁定
    private Integer workingStatus;	//在职状态
    private String picture;			//头像
    private String validityStartDate;	//有效期开始日期
    private String validityEndDate;		//有效期结束日期
    private String companyId;	//公司Id
    private String postId;			//职位Id

	@Pattern(regexp = "1[35789]\\d{9}", message = "手机号格式不正确")
    private String tel;				//电话号码
    
    @Email(message="邮箱格式不正确")
    private String email;			//邮箱
    private String qq;
    private String wechat;
    private String roleId;
    private String userGroupId;
    
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Integer getIsLock() {
		return isLock;
	}


	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}


	public Integer getWorkingStatus() {
		return workingStatus;
	}


	public void setWorkingStatus(Integer workingStatus) {
		this.workingStatus = workingStatus;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getValidityStartDate() {
		return validityStartDate;
	}


	public void setValidityStartDate(String validityStartDate) {
		this.validityStartDate = validityStartDate;
	}


	public String getValidityEndDate() {
		return validityEndDate;
	}


	public void setValidityEndDate(String validityEndDate) {
		this.validityEndDate = validityEndDate;
	}

	public String getCompanyId()
	{
		return companyId;
	}


	public void setCompanyId(String companyId)
	{
		this.companyId = companyId;
	}


	public String getPostId() {
		return postId;
	}


	public void setPostId(String postId) {
		this.postId = postId;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getQq() {
		return qq;
	}


	public void setQq(String qq) {
		this.qq = qq;
	}


	public String getWechat() {
		return wechat;
	}


	public void setWechat(String wechat) {
		this.wechat = wechat;
	}


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public String getUserGroupId() {
		return userGroupId;
	}


	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}


	@Override
	public String toString()
	{
		return "User [username=" + username + ", password=" + password + ", fullname=" + fullname + ", idNumber="
				+ idNumber + ", dateOfBirth=" + dateOfBirth + ", isLock=" + isLock + ", workingStatus=" + workingStatus
				+ ", picture=" + picture + ", validityStartDate=" + validityStartDate + ", validityEndDate="
				+ validityEndDate + ", companyId=" + companyId + ", postId=" + postId + ", tel=" + tel
				+ ", email=" + email + ", qq=" + qq + ", wechat=" + wechat + ", roleId=" + roleId + ", userGroupId="
				+ userGroupId + ", " + super.toString()
				+ "]";
	}
	
}
