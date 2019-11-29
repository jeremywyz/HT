package cn.tarena.ht.pojo;

public class Module extends BaseEntity{
	//模块信息
	 
	private String moduleId;
	private Module parentModule;  //父级模块信息
	private String name;           //权限标识
	private Integer ctype;         //类型  1主菜单/2左侧菜单/3按钮
	private Integer state;         
	private Integer orderNo;
	private String remark;
	private String checked;
	
	//为Ztree树 展现层级结构
	public String getpId(){
		if(parentModule !=null){
			return parentModule.getModuleId();
		}	
		return null;
	}
	//为zTree树的回显做准备
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	//为zTree树准备id
	public String getId() {
		return moduleId;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public Module getParentModule() {
		return parentModule;
	}
	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCtype() {
		return ctype;
	}
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}  	
	
	
}
