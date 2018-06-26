package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.School;

/**
 * 业务逻辑处理接口    学校
 * @author yun
 */

public interface ISchoolService {
 
	/**
	 * 查询所有的学校
	 * @return List<School>
	 * @throws Exception
	 */
	List<School> findAllSchool() throws Exception;
	/**
	 * 通过id查询学校
	 * @param id
	 * @return school
	 * @throws Exception
	 */
	School findSchoolById(long id) throws Exception;
	/**
	 * 通过关键字查询学校
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	List<School> findSchoolByKeyword(String keywords) throws Exception;
	/**
	 * 保存或修改学校信息
	 * @param school
	 * @return 
	 * @throws Exception
	 */
	void saveOrUpdateSchool(School school) throws Exception;
	/**
	 * 通过id删除学校信息
	 * @param id
	 * @throws Exception
	 */
	void deleteSchoolById(long id) throws Exception;
	/**
	 * 批量删除学校信息
	 * @param school
	 * @throws Exception
	 */
	void batchDeleteSchool(List<Long> ids) throws Exception;
}
 
			