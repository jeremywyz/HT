package cn.tarena.ht.pojo;

public class User extends BaseEntity{
	  
	private String userId;
	private String username;
	private String password;
	private Integer state;
	
	
	private Dept dept;	//一对一关联
	private UserInfo userInfo;  //用户扩展信息和用户表一对一关联
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", dept=" + dept + ", username=" + username + ", password=" + password
				+ ", state=" + state + ", userInfo=" + userInfo + "]";
	}
	
	
	
	
}
