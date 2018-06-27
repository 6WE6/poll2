package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Survey;

/**
 * 业务逻辑接口实现    课调
 * @author yun
 */
public interface ISurveyService {

	/**
	 * 查询所有课调
	 * @return
	 * @throws Exception
	 */
	List<Survey> findAllSurvey() throws Exception;
	/**
	 * 通过id查询课调
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Survey findSurveyById(long id) throws Exception;
	/**
	 * 通过关键字查询课调
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	List<Survey> findSurveyByKeyword(String keywords) throws Exception;
	/**
	 * 保存或修改课调
	 * @param survey
	 * @return 
	 * @throws Exception
	 */
	void saveOrUpdateSurvey(Survey survey) throws Exception;
	/**
	 * 通过id删除课调信息
	 * @param id
	 * @throws Exception
	 */
	void deleteSurveyById(long id) throws Exception;
	/**
	 * 批量删除课调信息
	 * @param survey
	 * @throws Exception
	 */
	void batchDeleteSurvey(Long[] ids) throws Exception;
}
