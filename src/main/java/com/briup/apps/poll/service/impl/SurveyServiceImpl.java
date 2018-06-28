package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.SurveyExample;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.dao.ClazzMapper;
import com.briup.apps.poll.dao.CourseMapper;
import com.briup.apps.poll.dao.GradeMapper;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.dao.UserMapper;
import com.briup.apps.poll.dao.extend.SurveyVMMapper;
import com.briup.apps.poll.service.ISurveyService;

/**
 * 业务逻辑处理接口   
 * @author yun
 */
@Service
public class SurveyServiceImpl implements ISurveyService{

	@Autowired
	private SurveyMapper surveyMapper;
	@Autowired
	private SurveyVMMapper surveyVMMapper;

	/**
	 * 按模板查询所有课调(QBC查询)
	 */
	@Override
	public List<Survey> findAllSurvey() throws Exception {
		SurveyExample example = new SurveyExample();
		return surveyMapper.selectByExample(example);
	}
	/**
	 * 通过id查询课调信息
	 */
	@Override
	public Survey findSurveyById(long id) throws Exception {
		return surveyMapper.selectByPrimaryKey(id);
	}
	/**
	 * 通过关键字查询课调信息
	 */
	@Override
	public List<Survey> findSurveyByKeyword(String keywords) throws Exception {
		SurveyExample example = new SurveyExample();
		//添加条件：code属性中包含keywords关键字
		example.createCriteria().andCodeLike(keywords);
		return surveyMapper.selectByExample(example);
	}
	/**
	 * 保存或更新课调信息
	 */
	@Override
	public void saveOrUpdateSurvey(Survey survey) throws Exception {
		if(survey.getId()!=null){
			//更新
			surveyMapper.updateByPrimaryKey(survey);
		}else{
			//插入
			surveyMapper.insert(survey);
		}
	}
	/**
	 * 通过id删除课调信息
	 */
	@Override
	public void deleteSurveyById(long id) throws Exception {
		surveyMapper.deleteByPrimaryKey(id);	
	}
	/**
	 * 批量删除课调信息
	 */
	@Override
	public void batchDeleteSurvey(Long[] ids) throws Exception {
		//forEach循环遍历数组或集合
		for(long id : ids){
			surveyMapper.deleteByPrimaryKey(id);
		}		
	}
	/**
	 * 查询所有课调详细信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SurveyVM> findAllSurveyVM() throws Exception {
		return surveyVMMapper.findAll();
	}
	/**
	 * 查询所有课调详细信息通过关键字
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SurveyVM> findSurveyVMByKeyword(String keywords) throws Exception {
		return surveyVMMapper.findSurveyByKeyword(keywords);
	}

	/**
	 * 查询所有课调详细信息通过id
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SurveyVM> findAllByIdAnswers(Long id) throws Exception {
		return surveyVMMapper.findAllByIdAnswers(id);
	}

	/**
	 * 查询所有课调详细信息通过id
	 * @return
	 * @throws Exception
	 */
	@Override
	public SurveyVM findByIdSurveyVM(Long id) throws Exception {
		return surveyVMMapper.findById(id);
	}


}
