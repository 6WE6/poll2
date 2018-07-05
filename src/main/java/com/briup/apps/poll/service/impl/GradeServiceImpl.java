package com.briup.apps.poll.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.GradeExample;
import com.briup.apps.poll.bean.extend.GradeVM;
import com.briup.apps.poll.dao.GradeMapper;
import com.briup.apps.poll.dao.extend.GradeVMMapper;
import com.briup.apps.poll.service.IGradeService;

/**
 * 业务逻辑实现接口  年级
 * @author psq
 *
 */
@Service
public class GradeServiceImpl implements IGradeService
{
	@Autowired
	private GradeMapper gradeMapper;
	
	@Autowired
	private GradeVMMapper gradeVMMapper;

	/**
	 * 查找所有年级信息
	 */
	@Override
	public List<Grade> findAllGrade() throws Exception {
		// 查询语句方法为selectByExampleWithBLOBs
		GradeExample gradeExample=new GradeExample();
		if(gradeMapper.selectByExample(gradeExample)!=null){
			return gradeMapper.selectByExampleWithBLOBs(gradeExample);
		}else{
			return null;
		}
		
		
	}
	
	/**
	 * 根据id查找年级信息
	 */
	@Override
	public Grade findGradeById(long id) throws Exception {
		// 	
		if(gradeMapper.selectByPrimaryKey(id)==null){
			return null;
		}else{
			return gradeMapper.selectByPrimaryKey(id);
		}
		
		
	}

	/**
	 * 根据关键字查找年级信息
	 */
	@Override
	public List<Grade> findGradeByKeyword(String keywords) throws Exception 
	{
		//添加条件：name属性中包含keywords关键字
		GradeExample gradeExample = new GradeExample();	
		gradeExample.createCriteria().andNameLike(keywords);
		return gradeMapper.selectByExampleWithBLOBs(gradeExample);
	}

	/**
	 * 保存或修改年级信息
	 */
	@Override
	public String saveOrUpdateGrade(Grade grade) throws Exception {
		// 
		if(grade.getId()!=null){
			//更新
			//判断是否存在
			if(gradeMapper.selectByPrimaryKey(grade.getId())!=null)
			{
				gradeMapper.updateByPrimaryKeyWithBLOBs(grade);
				return "更新成功";
			}else{
				return "更新失败，请确认年级ID";
			}
			
			
		}else{
			//插入		
			gradeMapper.insert(grade);	
			return "插入成功";
		}
		
	}

	/**
	 * 根据id删除年级信息
	 */
	@Override
	public void deleteGradeById(long id) throws Exception {
		// 
		gradeMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 批量删除年级信息
	 */
	@Override
	public String batchDeleteGrade(List<Long> ids) throws Exception {
		// 迭代循环查询
		for(Long id:ids)
		{
			Grade grades = gradeMapper.selectByPrimaryKey(id);
			if(grades==null){
				return "输入数据中有未查询到的年级";
			}
		}	
		//迭代循环删除
		for(Long id:ids)
		{
			gradeMapper.deleteByPrimaryKey(id);
		}
		return "删除成功";
		
	}
	
	/**
	 *根据年级信息查询学校信息和年级信息 
	 */
	@Override
	public GradeVM findSchoolbyGrade(Long id) throws Exception {
		// 注意返回值
		return gradeVMMapper.findSchoolbyGrade(id);
	}
	
	

}
