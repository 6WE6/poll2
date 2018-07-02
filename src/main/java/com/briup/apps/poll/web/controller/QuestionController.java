package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 视图控制层  问题
 * @author wanglinhao
 *
 */

@Api(description = "问题相关接口")
@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private IQuestionService questionService;
	
	/**
	 * 查询全部问题信息，包括关联的选项
	 * @return
	 */
	@ApiOperation(value = "查询全部问题信息,包括关联的选项", notes = "")
	@GetMapping("findAllQuestionVM")
	public MsgResponse findAllQuestionVM() {
		try {
			List<QuestionVM> questionVMs = questionService.findAllQuestionVM();
			return MsgResponse.success("success", questionVMs);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 通过id查询问题信息，包括关联的选项
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "通过id查询问题信息，包括关联的选项", notes = "")
	@GetMapping("findQuestionVMById")
	public MsgResponse findQuestionVMById(long id) {
		try {
			QuestionVM questionVM = questionService.findQuestionVMById(id);
			return MsgResponse.success("success", questionVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 通过关键字模糊查询，包括关联的选项,关键字的索引列有 QuestionVM.name（问题的标题）和 Options.name（选项的内容）
	 * @param keyword
	 * @return
	 */
	@ApiOperation(value = "通过关键字模糊查询，包括关联的选项", notes = "关键字的索引列有 QuestionVM.name（问题的标题）和 Options.name（选项的内容）")
	@GetMapping("findQuestionVMByKeyword")
	public MsgResponse findQuestionVMByKeyword(@RequestParam String keyword) {
		try {
			List<QuestionVM> questionVM = questionService.findQuestionVMByKeyword(keyword);
			return MsgResponse.success("success", questionVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 通过问卷 id 查找问卷下的所有问题
	 * @param questionnaireId 问卷 id
	 * @return
	 */
	@ApiOperation(value = "通过问卷 id 查找问卷下的所有问题", notes = "")
	@GetMapping("findQuestionVMByQuestionnaireId")
	public MsgResponse findQuestionVMByQuestionnaireId(@RequestParam long questionnaireId) {
		try {
			List<QuestionVM> questionVM = questionService.findQuestionVMByQuestionnaireId(questionnaireId);
			return MsgResponse.success("success", questionVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 保存或修改问题信息，包括关联的选项
	 * @param questionVM
	 * @return
	 */
	@ApiOperation(value = "保存或修改问题信息，包括关联的选项", notes = "id为空执行新增操作，id不为空执行修改操作")
	@PostMapping("saveOrUpdataQuestionVM")
	public MsgResponse saveOrUpdataQuestionVM(QuestionVM questionVM) {
		try {
			questionService.saveOrUpdataQuestionVM(questionVM);
			return MsgResponse.success("success", "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 批量删除问题信息，包括关联的选项
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "批量删除问题信息，包括关联的选项", notes = "")
	@GetMapping("batchDeleteQuestionVM")
	public MsgResponse batchDeleteQuestionVM(long[] ids) {
		try {
			questionService.batchDeleteQuestionVM(ids);
			return MsgResponse.success("success", "批量删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 查询所有的问题
	 * @return
	 */
	@ApiOperation(value = "查询所有问题信息", notes = "")
	@GetMapping("findAllQuestion")
	public MsgResponse findAllQuestion() {
		try {
			List<Question> questions = questionService.findAllQuestion();
			return MsgResponse.success("success", questions);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 通过id查询问题
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "通过id查询问题", notes = "")
	@GetMapping("findQuestionById")
	public MsgResponse findQuestionById(long id) {
		try {
			Question question = questionService.findQuestionById(id);
			return MsgResponse.success("success", question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 通过关键字查询问题
	 * @param keywords
	 * @return
	 */
	@ApiOperation(value = "通过关键字查询问题", notes = "")
	@GetMapping("findQuestionByKeyword")
	public MsgResponse findQuestionByKeyword(String keywords) {
		try {
			List<Question> questions = questionService.findQuestionByKeyword(keywords);
			return MsgResponse.success("success", questions);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 保存或修改问题信息
	 * @param question
	 * @return
	 */
	@ApiOperation(value = "保存或修改问题信息", notes = "")
	@PostMapping("saveOrUpdataQuestion")
	public MsgResponse saveOrUpdataQuestion(Question question) {
		try {
			questionService.saveOrUpdataQuestion(question);;
			return MsgResponse.success("success", "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 通过id删除问题信息
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "通过id删除问题信息", notes = "")
	@GetMapping("deleteQuestionById")
	public MsgResponse deleteQuestionById(long id) {
		try {
			questionService.deleteQuestionById(id);
			return MsgResponse.success("success", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	/**
	 * 批量删除问题信息
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "批量删除问题信息", notes = "")
	@GetMapping("batchDeleteQuestion")
	public MsgResponse batchDeleteQuestion(long[] ids) {
		try {
			questionService.batchDeleteQuestion(ids);
			return MsgResponse.success("success", "批量删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
}
