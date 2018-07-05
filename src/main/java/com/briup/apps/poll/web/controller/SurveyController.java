package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 视图控制层    课调
 * @author yun
 *
 */
@RestController
@RequestMapping("/survey")
@Api(description="课调相关接口")
public class SurveyController {

	@Autowired
	private ISurveyService surveyService;
	
	@Autowired
	private IAnswersService answersService;
	
	// @author yun
	@GetMapping("findAllSurvey")
	@ApiOperation(value="查询所有课调信息",notes="保存课调信息时无需输入id")
	public MsgResponse findAllSurvey(){
		List<Survey> surveys = new ArrayList<Survey>();
		try {
			surveys = surveyService.findAllSurvey();
			//返回成功信息
			return MsgResponse.success("success",surveys);
		} catch (Exception e) {
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}		
	}
	// @author yun
	@GetMapping("findSurveyById")
	@ApiOperation(value="通过id查询课调信息")
	public MsgResponse findSurveyById(@RequestParam long id){
		Survey survey = new Survey();
		try {
			survey = surveyService.findSurveyById(id);
			return MsgResponse.success("success", survey);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	// @author yun
	@GetMapping("deleteSurveyById")
	@ApiOperation(value="通过id删除课调信息")
	public MsgResponse deleteSurveyById(@RequestParam long id){
		//调用service层代码完成课调信息的删除
		try {
			surveyService.deleteSurveyById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}
	}
	// @author yun
	@GetMapping("findSurveyByKeyword")
	@ApiOperation(value="通过关键字查询课调信息")
	public MsgResponse findSurveyByKeyword(@RequestParam String keywords){
		try {
			List<Survey> surveys = surveyService.findSurveyByKeyword(keywords);
			return MsgResponse.success("success", surveys);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}

	/**
	 * 保存或修改课调信息
	 * @param survey
	 * @return
	 * @author yun
	 */
	@PostMapping("saveOrUpdateSurvey")
	@ApiOperation(value="保存或更新课调信息，如果是保存新课调信息，请不要填id！")
	public MsgResponse saveOrUpdateSurvey(Survey survey){
		try {
			surveyService.saveOrUpdateSurvey(survey);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	// @author yun
	@GetMapping("batchDeleteSurvey")
	@ApiOperation(value="批量删除课调信息")
	public MsgResponse batchDeleteSurvey(Long[] ids){
		try {
			surveyService.batchDeleteSurvey(ids);
			return MsgResponse.success("success", ids);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	// @author yun
	@GetMapping("findAllSurveyVM")
	@ApiOperation(value="获得所有的课调详细信息")
	public MsgResponse findAllSurveyVM(){
		try {
			List<SurveyVM> surveyVMs = surveyService.findAllSurveyVM();
			return MsgResponse.success("success", surveyVMs);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	// @author yun
	@GetMapping("findSurveyVMByKeyword")
	@ApiOperation(value="通过关键字获得所有的课调详细信息")
	public MsgResponse findSurveyVMByKeyword(@RequestParam String keywords){
		try {
			List<SurveyVM> surveyVMs = surveyService.findSurveyVMByKeyword(keywords);
			return MsgResponse.success("success", surveyVMs);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	// @author yun
	@GetMapping("findAllByIdAnswers")
	@ApiOperation(value="通过id获得所有的课调的答题卡")
	public MsgResponse findAllByIdAnswers(@RequestParam Long id){
		try {
			List<SurveyVM> surveyVMs = surveyService.findAllByIdAnswers(id);
			return MsgResponse.success("success", surveyVMs);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	// @author yun
	@GetMapping("findByIdSurveyVM")
	@ApiOperation(value="通过id获得课调")
	public MsgResponse findByIdSurveyVM(@RequestParam Long id){
		try {
			SurveyVM surveyVM = surveyService.findByIdSurveyVM(id);
			return MsgResponse.success("success", surveyVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("SurveyExamine")
	@ApiOperation(value="课调审核")
	public MsgResponse SurveyExamine(@RequestParam Long id){

		try{
			if(surveyService.checkSurvey(id)==null)
			{
				return MsgResponse.success("课调未查询到或者课调状态不是未审核", null);
			}else{
				return MsgResponse.success("success", surveyService.checkSurvey(id));
			}

		}catch (Exception e) {
			// 
			return MsgResponse.error(e.getMessage());
		}

	}

	@GetMapping("openSurvey")
	@ApiOperation(value="通过课调id开启课调")
	public MsgResponse openSurvey(@RequestParam Long id){
		try {
			return MsgResponse.success(surveyService.openSurvey(id), null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("closeSurvey")
	@ApiOperation(value="通过课调id关闭课调")
	public MsgResponse closeSurvey(@RequestParam Long id){
		try {
			return MsgResponse.success(surveyService.closeSurvey(id), null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("checkSurvey")
	@ApiOperation(value="通过课调id将课调改为审核通过状态或审核未通过状态，输入的results必须为1或者0")
	public MsgResponse checkSurvey(@RequestParam Long id,int results){
		try {
			return MsgResponse.success(surveyService.resultsOfSurvey(id, results), null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value="通过班级Id查询出该班级下所有已经审核的课调")
	@GetMapping("findSurveyByClazzId")	
	public MsgResponse findSurveyByClazzId(long id){
		try {
			List<SurveyVM> list=surveyService.findByClazzIdAndCheckPass(id);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// 
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="去审核课调",notes="返回课调基本信息以及课调中的主观题答案")
	@GetMapping(value="toCheckSurvey")
	public MsgResponse toCheckSurvey(long id){
		try {
			SurveyVM surveyVM = surveyService.findByIdSurveyVM(id);
			List<Answers> answers = answersService.findAnswersByServeyId(id);
			double total = 0.0;
			for(Answers answer : answers){
				// 5|4
				String selectStr = answer.getSelections();
				if(selectStr!=null){
					String[] arr = selectStr.split("[|]");
					Double singleTotal = 0.0;
					for(String a : arr){
						int select = Integer.parseInt(a);
						singleTotal += select;
					}
					double singleAverage = singleTotal/arr.length;
					total += singleAverage;
				}
			}
			double average = total / answers.size();
			surveyVM.setAverage(average);
			return MsgResponse.success("success", surveyVM);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}