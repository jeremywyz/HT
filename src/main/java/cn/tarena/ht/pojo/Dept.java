package cn.tarena.ht.pojo;

public class Dept extends BaseEntity{
	   
   private String deptId;
   private Dept parentDept;  //上级部门一对一封装
   private String deptName;
   private Integer state;
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public Dept getParentDept() {
		return parentDept;
	}
	public void setParentDept(Dept parentDept) {
		this.parentDept = parentDept;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", parentDept=" + parentDept + ", deptName=" + deptName + ", state=" + state
				+ "]";
	}


	
}

