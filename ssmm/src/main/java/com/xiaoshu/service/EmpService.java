package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.EmpMapper;
import com.xiaoshu.entity.Emp;
import com.xiaoshu.entity.EmpVo;

@Service
public class EmpService {
	
	@Autowired
	private EmpMapper empMapper;
	
	public PageInfo<EmpVo> findPage(EmpVo empVo,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);	
        List<EmpVo> list=empMapper.findList(empVo);
        PageInfo<EmpVo> page = new PageInfo<>(list);
		return page;
	}

	public Emp findByName(String tbEmpName) {
		Emp emp = new Emp();
		emp.setTbEmpName(tbEmpName);
		return empMapper.selectOne(emp);
	}

	public void updateEmp(Emp emp2) {
		empMapper.updateByPrimaryKeySelective(emp2);
		
	}

	public void addEmp(Emp emp) {
		empMapper.insert(emp);
		
	}

	public void deleteEmp(int parseInt) {
		empMapper.deleteByPrimaryKey(parseInt);
		
	}

}
