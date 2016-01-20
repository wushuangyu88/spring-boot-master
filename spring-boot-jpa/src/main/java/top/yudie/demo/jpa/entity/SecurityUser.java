package top.yudie.demo.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the security_user database table.
 * 
 */
@Entity
@Table(name="security_user")
@NamedQuery(name="SecurityUser.findAll", query="SELECT s FROM SecurityUser s")
public class SecurityUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private String userId;

	@Column(name="USER_CODE")
	private String userCode;

	@Column(name="USER_DESC")
	private String userDesc;

	@Column(name="USER_MAIL")
	private String userMail;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="USER_PHONE")
	private String userPhone;

	@Column(name="USER_PWD")
	private String userPwd;

	@Column(name="USER_SEX")
	private String userSex;

	@Column(name="USER_SORT")
	private int userSort;

	@Column(name="USER_STATE")
	private String userState;

	public SecurityUser() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserDesc() {
		return this.userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public String getUserMail() {
		return this.userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public int getUserSort() {
		return this.userSort;
	}

	public void setUserSort(int userSort) {
		this.userSort = userSort;
	}

	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

}