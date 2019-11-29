package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.pojo.Dept;
@Service
public class DeptServiceImpl implements DeptService {
	
	@Resource
	private DeptMapper deptMapper;
	
	@Override
	public List<Dept> findAll() {
		
		return deptMapper.findAll();
	}

	@Override
	public void updateState(String[] deptIds, int state) {
		
		//修改状态 
		deptMapper.updateState(deptIds,state);
		
	}

	@Override
	public void delteDepts(String[] deptId) {
		
		deptMapper.delteDepts(deptId);
		
	}

	@Override
	public void saveDept(Dept dept) {
		dept.setState(1);  //状态为启用  1表示启用   0停用
		dept.setCreateTime(new Date());   //设置当前时间
		
		deptMapper.saveDept(dept);
		
	}

	@Override
	public Dept findOne(String deptId) {
		
		return deptMapper.findOne(deptId);
	}

	@Override
	public List<Dept> findParentDeptList(String deptId) {
		
		return deptMapper.findParentDeptList(deptId);
	}

	@Override
	public void updateDept(Dept dept) {
		dept.setUpdateTime(new Date());
		
		deptMapper.updateDept(dept);
	}

	@Override
	public void updateState(List<String> deptId, int state) {
		System.out.println(deptId);
		
	}

}
