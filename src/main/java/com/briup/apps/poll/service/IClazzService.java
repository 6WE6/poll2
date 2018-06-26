package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Clazz;

/**
 * 业务逻辑处理接口 班级
 * 
 * @author lixiaofeng
 *
 */
public interface IClazzService {
	/**
	 * 查询所有班级信息
	 */
	List<Clazz> findAllClazz() throws Exception;

	/**
	 * 通过id查询班级信息
	 */
	Clazz findClazzById(long id) throws Exception;

	/**
	 * 通过关键字查询班级信息
	 */
	List<Clazz> query(String keywords) throws Exception;

	List<Clazz> findClazzByKeyword(String keywords) throws Exception;

	/**
	 * 保存或修改班级信息信息
	 */
	void saveOrUpdateClazz(Clazz clazz) throws Exception;

	/**
	 * 通过id删除班级信息
	 */
	void deleteClazzById(long id) throws Exception;

	/**
	 * 批量删除班级信息
	 */
	void batchDeleteClazz(long[] ids) throws Exception;
}
