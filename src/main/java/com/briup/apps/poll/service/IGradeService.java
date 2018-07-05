package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.extend.GradeVM;;

/**
 * 业务逻辑处理接口  年级模块
 * @author psq
 *
 */
public interface IGradeService 
{
	/**
	 * 查找所有年级
	 * @return 
	 * @throws Exception
	 */
	List<Grade> findAllGrade() throws Exception;
	
	/**
	 * 通过id查询年级
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Grade findGradeById(long id) throws Exception;
	
	/**
	 * 
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	List<Grade> findGradeByKeyword(String keywords) throws Exception;
	
	/**
	 * 保存或修改年级信息
	 * @param grade
	 * @return 
	 * @throws Exception
	 */
	String saveOrUpdateGrade(Grade grade) throws Exception;
	/**
	 * 通过id删除年级信息
	 * @param id
	 * @throws Exception
	 */
	void deleteGradeById(long id) throws Exception;
	
	/**
	 * 批量删除年级信息
	 * @param grade
	 * @throws Exception
	 */
	String batchDeleteGrade(List<Long> ids) throws Exception;
	
	/**
	 * 根据年级信息查询学校和年级的信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	GradeVM findSchoolbyGrade(Long id) throws Exception;
	

}
