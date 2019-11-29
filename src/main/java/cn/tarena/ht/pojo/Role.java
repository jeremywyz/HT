package cn.tarena.ht.pojo;

public class Role extends BaseEntity{
	 //private String id;
	 private String roleId;
	 private String name;
	 private String remarks;
	 private Integer orderNo;
	 private String checked;	//为了实现回显   true/false
	 
	
	 
	
	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getRoleId() {
		return roleId;
	}
	
	//该方法为了满足zTree树的Id属性   getId() ----id
	public String getId() {
		return roleId;
	}
	
	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + ", remarks=" + remarks + ", orderNo=" + orderNo + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	 
	 
}
