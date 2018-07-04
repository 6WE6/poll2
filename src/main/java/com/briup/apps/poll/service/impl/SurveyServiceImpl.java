package com.briup.apps.poll.service.impl;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.SurveyExample;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.dao.extend.SurveyVMMapper;
import com.briup.apps.poll.service.ISurveyService;

/**
 * 业务逻辑处理接口
 * 
 * @author yun
 */
@Service
public class SurveyServiceImpl implements ISurveyService {

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
		// 添加条件：code属性中包含keywords关键字
		example.createCriteria().andCodeLike(keywords);
		return surveyMapper.selectByExample(example);
	}

	/**
	 * 保存或更新课调信息
	 */
	@Override
	public void saveOrUpdateSurvey(Survey survey) throws Exception {
		if (survey.getId() != null) {
			// 更新
			surveyMapper.updateByPrimaryKey(survey);
		} else {
			// status code surveyDate
			survey.setStatus(Survey.STATUS_INIT);
			// 获取当前时间
			Date now = new Date();
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
			String surveydateF = sd.format(now);
			survey.setCode("KD" + surveydateF);
			// 获取当前时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String surveydateT = sdf.format(now);
			survey.setSurveydate(surveydateT);
			// 插入
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
		// forEach循环遍历数组或集合
		for (long id : ids) {
			surveyMapper.deleteByPrimaryKey(id);
		}
	}

	/**
	 * 查询所有课调详细信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SurveyVM> findAllSurveyVM() throws Exception {
		return surveyVMMapper.findAll();
	}

	/**
	 * 查询所有课调详细信息通过关键字
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SurveyVM> findSurveyVMByKeyword(String keywords) throws Exception {
		return surveyVMMapper.findSurveyByKeyword(keywords);
	}

	/**
	 * 查询所有课调详细信息通过id
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SurveyVM> findAllByIdAnswers(Long id) throws Exception {
		return surveyVMMapper.findAllByIdAnswers(id);
	}

	/**
	 * 查询所有课调详细信息通过id
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public SurveyVM findByIdSurveyVM(Long id) throws Exception {
		return surveyVMMapper.findById(id);
	}

	/**
	 * 课调审核
	 */
	@Override
	public SurveyVM checkSurvey(Long id) throws Exception {
		// 先查询，在判断，最后返回
		Survey survey=surveyMapper.selectByPrimaryKey(id);
		//判断是否存在
		if(survey!=null)
		{
			if(survey.getStatus().equals(Survey.STATUS_CHECK_UN))
			{
				return surveyVMMapper.findById(id);
			}else{
				return null;
			}
		}else{
			return null;
		}
		
	}

	/**
	 * 开启课调
	 */
	@Override
	public String openSurvey(Long id) throws Exception {
		// 先查询，在判断，在改变
		Survey survey = surveyMapper.selectByPrimaryKey(id);
		//判断课调的状态为关闭
		if(survey.getStatus().equals(Survey.STATUS_INIT))
		{
			//设置课调编码
			String code=survey.getId().toString();
			survey.setCode(code);
			//设置课调状态
			survey.setStatus(Survey.STATUS_BEGIN);
			surveyMapper.updateByPrimaryKey(survey);
			return "课调开启成功";
		}else
		{
			return "课调状态不是关闭状态";
		}
	}

	/**
	 * 关闭课调
	 */
	@Override
	public String closeSurvey(Long id) throws Exception {
		
		// 先查询，在判断，在改变
		Survey survey = surveyMapper.selectByPrimaryKey(id);
		SurveyVM surveyVM = surveyVMMapper.findById(id);
		if(survey.getStatus().equals(Survey.STATUS_BEGIN))
		{
			//设置平均分
			//获取答题卡集合
			List<Answers> list=surveyVM.getAnswers();
			//总的平均分
			double average=0;
			//循环遍历答题卡，得到平均分
			for(Answers answer : list)
			{
				//单人平均分
				double total=0;
				//将字符串数组分割
				String[] arr = answer.getSelections().split("[|]");
				for(String a:arr)
				{
					total+=Integer.parseInt(a);
				}
				total=total/arr.length;
				average+=total;
			}
			average=average/list.size();	
			//判断average为NaN的情况
			if(Double.isNaN(average))
			{
				average=0;
			}
			//设置平均分
			survey.setAverage(average);
			//设置为未审核状态
			survey.setStatus(Survey.STATUS_CHECK_UN);
			surveyMapper.updateByPrimaryKey(survey);
			return "课调关闭成功";
		}else{
			return "课调状态不是开启状态";
		}
	}

	/**
	 * 0代表未通过，1代表通过
	 */
	@Override
	public String resultsOfSurvey(Long id, int results) throws Exception {
		// 先查询，在判断，在查询
		Survey survey=surveyMapper.selectByPrimaryKey(id);
		if(survey!=null && survey.getStatus().equals(Survey.STATUS_CHECK_UN))
		{
			if(results==0){
				survey.setStatus(Survey.STATUS_CHECK_NOPASS);
				surveyMapper.updateByPrimaryKey(survey);
			}else{
				survey.setStatus(Survey.STATUS_CHECK_PASS);
				surveyMapper.updateByPrimaryKey(survey);
			}
			return "课调修改成功";
		}else{
			return "课调未查询到或者课调状态不是未审核";
		}
	}

}
