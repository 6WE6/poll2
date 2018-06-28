package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;

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

	/**
	 * 查询所有课调详细信息
	 * @return
	 * @throws Exception
	 */
	List<SurveyVM> findAllSurveyVM() throws Exception;
	/**
	 * 根据关键字查询所有课调详细信息
	 * @return
	 * @throws Exception
	 */
	List<SurveyVM> findSurveyVMByKeyword(String keywords) throws Exception;
	/**
	 * 根据id查询所有课调下的答题卡
	 * @return
	 * @throws Exception
	 */
	List<SurveyVM> findAllByIdAnswers(Long id) throws Exception;
	/**
	 * 根据id查询所有课调的详细信息
	 * @return
	 * @throws Exception
	 */
	SurveyVM findByIdSurveyVM(Long id) throws Exception;

}
