package com.xiaoshu.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.CompanyMapper;
import com.xiaoshu.dao.PersonMapper;
import com.xiaoshu.entity.Company;
import com.xiaoshu.entity.Log;
import com.xiaoshu.entity.Person;
import com.xiaoshu.entity.PersonVo;

@Service
public class PersonService {
	
	@Autowired
	private PersonMapper personMapper;
	@Autowired
	private CompanyMapper companyMapper;
	
	public PageInfo<PersonVo> findPage(PersonVo personVo,Integer pageNum,Integer pageSize){
	    PageHelper.startPage(pageNum, pageSize);
	    List<PersonVo> plist=personMapper.findList(personVo);
	    PageInfo<PersonVo> page = new PageInfo<>(plist);
	    return page;
		
	}

	public Person findByName(String getpName) {
		Person p=new Person();
		p.setpName(getpName);
		Person person = personMapper.selectOne(p);
		return person;
	}

	public void updatePerson(Person person) {
		personMapper.updateByPrimaryKeySelective(person);
		
	}

	public void addP(Person person) {
		personMapper.insert(person);
		
	}

	public void deleteP(int parseInt) {
		personMapper.deleteByPrimaryKey(parseInt);
		
	}

	public void importP(MultipartFile importFile) throws InvalidFormatException, IOException {
		Workbook wb = WorkbookFactory.create(importFile.getInputStream());
		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		for (int i = 0; i < rowNum; i++) {
			Row row = sheet.getRow(i+1);
			String name = row.getCell(0).toString();
			String sex = row.getCell(1).toString();
			String cname = row.getCell(2).toString();
			Date cometime = row.getCell(3).getDateCellValue();
			Person person = new Person();
			person.setpName(name);
			person.setGender(sex.equals("男")?"1":"0");
			person.setCometime(cometime);
			Company c = findCid(cname);
			person.setCid(c.getCid());
			addP(person);
			
		}
		
	}
	public Company findCid(String cname){
		Company company = new Company();
		company.setCompanyName(cname);
		return companyMapper.selectOne(company);
	}

	public List<PersonVo> findP(PersonVo personVo) {
		List<PersonVo> plist=personMapper.findList(personVo);
		return plist;
	}

}
