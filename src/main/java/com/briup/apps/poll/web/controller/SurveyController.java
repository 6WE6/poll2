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

	@PostMapping("saveOrUpdateSurvey")
	@ApiOperation(value="保存或更新年级信息，如果是保存新课调信息，请不要填id！")
	public String saveOrUpdateSurvey(Survey survey){
		try {
			surveyService.saveOrUpdateSurvey(survey);
			return "操作成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "操作失败！"+e.getMessage();
		}
	}

	@GetMapping("batchDeleteSurvey")
	@ApiOperation(value="批量删除课调信息")
	public MsgResponse batchDeleteCoure(Long[] ids){
		try {
			surveyService.batchDeleteSurvey(ids);
			return MsgResponse.success("success", ids);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}