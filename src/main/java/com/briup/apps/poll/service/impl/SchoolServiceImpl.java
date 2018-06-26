package com.briup.apps.poll.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.bean.SchoolExample;
import com.briup.apps.poll.dao.SchoolMapper;
import com.briup.apps.poll.service.ISchoolService;

@Service("schoolService")
public class SchoolServiceImpl implements ISchoolService {

	@Autowired
	private SchoolMapper schoolMapper;

	/**
	 * 按模板查询所有学校(QBC查询)
	 */
	@Override
	public List<School> findAllSchool() throws Exception {
		SchoolExample example = new SchoolExample();
		return schoolMapper.selectByExampleWithBLOBs(example);
	}
	
	/**
	 * 通过id查询学校信息
	 */
	@Override
	public School findSchoolById(long id) throws Exception {
		return schoolMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 通过关键字查询学校信息
	 */
	@Override
	public List<School> findSchoolByKeyword(String keywords) throws Exception {
		SchoolExample example = new SchoolExample();
		//添加条件：name属性中包含keywords关键字
		example.createCriteria().andNameLike(keywords);
		return schoolMapper.selectByExampleWithBLOBs(example);
	}
	
	/**
	 * 保存或更新学校信息
	 */
	@Override
	public void saveOrUpdateSchool(School school) throws Exception {
		// TODO Auto-generated method stub
		if(school.getId()!=null){
			//更新
			schoolMapper.updateByPrimaryKey(school);
		}else{
			//插入
			schoolMapper.insert(school);
		}
	}

	/**
	 * 通过id删除学校信息
	 */
	@Override
	public void deleteSchoolById(long id) throws Exception {
		schoolMapper.deleteByPrimaryKey(id);	
	}
	
	/**
	 * 批量删除学校信息
	 */
	@Override
	public void batchDeleteSchool(List<Long> ids) throws Exception {
		//forEach循环遍历数组或集合
		for(long id : ids){
			schoolMapper.deleteByPrimaryKey(id);
		}		
	}
	
 
}
 