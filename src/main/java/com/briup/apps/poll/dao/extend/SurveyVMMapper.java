package com.briup.apps.poll.dao.extend;

import java.util.List;


import com.briup.apps.poll.bean.extend.SurveyVM;

/**
 * POJO类    课调Mapper
 * @author yun
 */
public interface SurveyVMMapper {
	List<SurveyVM> findAll();
	List<SurveyVM> findSurveyByKeyword(String keywords);
	List<SurveyVM> findAllByIdAnswers(Long id);
	SurveyVM findById(Long id);
	/**
	 * 审核通过
	 */
	List<SurveyVM> selectByClazzIdAndCheckPass(long id);
}
