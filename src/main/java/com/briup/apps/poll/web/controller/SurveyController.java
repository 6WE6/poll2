package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
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
		
		/*try{
			if()
			
		}catch (Exception e) {
			// TODO: handle exception
		}*/
		return MsgResponse.success("课调开启成功", null);
		
	}
	
	@GetMapping("openSurvey")
	@ApiOperation(value="通过课调id开启课调")
	public MsgResponse openSurvey(@RequestParam Long id){
		try {
			//先查，在判断，在改变状态
			Survey survey=surveyService.findSurveyById(id);	
			//审核状态为未开启或审核通过可以开启
			if(survey.getStatus().equals(Survey.STATUS_INIT) || survey.getStatus().equals(Survey.STATUS_CHECK_PASS))
			{
				//设置课调编码
				String code=survey.getId().toString();
				survey.setCode(code);
				survey.setStatus(Survey.STATUS_BEGIN);
				surveyService.saveOrUpdateSurvey(survey);	
				return MsgResponse.success("课调开启成功", null);
			}else{
				return MsgResponse.success("课调已经开启", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("closeSurvey")
	@ApiOperation(value="通过课调id关闭课调")
	public MsgResponse closeSurvey(@RequestParam Long id){
		try {
			//先查，在判断，在改变状态
			Survey survey=surveyService.findSurveyById(id);	
			//审核状态为开启时可以关闭，其他不可以
			if(survey.getStatus().equals(Survey.STATUS_BEGIN))
			{
				survey.setStatus(Survey.STATUS_INIT);
				surveyService.saveOrUpdateSurvey(survey);	
				return MsgResponse.success("课调关闭成功", null);
			}else{
				return MsgResponse.success("课调已经关闭", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}