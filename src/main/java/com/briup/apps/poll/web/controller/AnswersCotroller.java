package com.briup.apps.poll.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "答题卡相关接口")
@RestController
@RequestMapping("/answer")
public class AnswersCotroller {
	@Autowired
	private IAnswersService answersService;
	/*
	 * 查询所有答题卡，包括问卷
	 */
	@ApiOperation(value="查询所有班答题卡",notes="答题卡携带调查问卷survey")
	@GetMapping("findAllVM")
	public MsgResponse findAllVM() {
		try {
			List<AnswersVM> list=answersService.selectAllAnswersVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}
	/*
	 * 查询所有答题卡
	 */
	@ApiOperation(value = "查询所有答题卡信息", notes = "单表")
	@GetMapping("/findAllAnswers")

	public MsgResponse findAllAnswers() {

		try {
			List<Answers> list = answersService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	/*
	 * 通过id查询答题卡
	 */
	@ApiOperation(value = "通过id查询答题卡", notes = "单表")
	@GetMapping("/findAnswersById")
	public MsgResponse findAnswersById(@RequestParam long id) {

		Answers answers = new Answers();
		try {
			answers = answersService.findAnswersById(id);
			return MsgResponse.success("success", answers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	/*
	 * 通过seivey id查询答题卡
	 */
	@ApiOperation(value = "通过seivey id查询答题卡", notes = "单表")
	@GetMapping("/findAnswersBySurveyId")	
	public MsgResponse findAnswersBySurveyId(@RequestParam long id) {

	List<Answers> list;
	try {
		list = answersService.findAnswersByServeyId(id);
		return MsgResponse.success("success", list);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}

	}
	/*
	 * 通过关键字查询答题卡
	 */

	@ApiOperation(value = "通过关键字查询答题卡")
	@GetMapping("/findAnswersByKeyword")
	public MsgResponse findAnswersByKeyword(@RequestParam String keywords) {
		try {
			List<Answers> list = answersService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	/*
	 * 保存或修改答题卡信息
	 */
	@ApiOperation(value = "保存或更新答题卡信息")
	@PostMapping("saveOrUpdateAnswers")
	public String saveOrUpdateAnswers(Answers answers) {
		try {
			answersService.saveOrUpdateAnswers(answers);
			return "操作成功";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "操作失败" + e.getMessage();
		}
	}

	/*
	 * 通过id删除答题卡信息
	 */
	@ApiOperation(value = "通过id删除答题卡信息")
	@GetMapping("deleteAnswersById")
	public MsgResponse deleteAnswersById(@RequestParam long id) {

		try {
			answersService.deleteAnswersById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	/*
	 * 批量删除答题卡信息
	 */
	@ApiOperation(value = "批量删除答题卡信息")
	@GetMapping("batchDeleteAnswers")
	public MsgResponse batchDeleteAnswers(long[] ids) {
		try {
			answersService.bathDeleteAnswers(ids);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

}
