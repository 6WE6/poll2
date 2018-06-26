package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.service.IGradeService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "年级相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private IGradeService gradeService;

	/**
	 * 查询所有年级信息
	 */
	@ApiOperation(value = "查询所有年级信息", notes = "保存年级信息时无需输入id")
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade() {
		try {
			List<Grade> list = gradeService.findAllGrade();
			// 返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 通过id查询年级信息
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "通过id查询年级信息")
	@GetMapping("findGradeById")
	public MsgResponse findGradeById(@RequestParam long id) {
		Grade grade = new Grade();
		try {
			grade = gradeService.findGradeById(id);
			return MsgResponse.success("success", grade);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 通过id删除年级信息
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "通过id删除年级信息")
	@GetMapping("deleteGradeById")
	public MsgResponse deleteGradeById(@RequestParam long id) {
		// 调用service层代码完成课程信息的删除
		try {
			gradeService.deleteGradeById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());

		}
	}

	/**
	 * 通过关键字查询年级信息
	 * 
	 * @param keywords
	 * @return
	 */
	@ApiOperation(value = "通过关键字查询年级信息")
	@GetMapping("findGradeByKeyword")
	public MsgResponse findGradeByKeyword(@RequestParam String keywords) {
		List<Grade> list = new ArrayList<Grade>();
		try {
			list = gradeService.findGradeByKeyword(keywords);
			return MsgResponse.success("success",list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 保存或更新年级信息
	 * 
	 * @param grade
	 * @return
	 */
	@ApiOperation(value = "保存或更新年级信息")
	@PostMapping("saveOrUpdateGrade")
	public String saveOrUpdateGrade(Grade grade) {
		try {
			gradeService.saveOrUpdateGrade(grade);
			return "操作成功";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "操作失败！" + e.getMessage();
		}
	}

	/**
	 * 批量删除年级信息
	 * 
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "批量删除年级信息")
	@GetMapping("batchDeleteGrade")
	public MsgResponse batchDeleteGrade(List<Long> ids) {
		try {
			gradeService.batchDeleteGrade(ids);
			return MsgResponse.success("success", ids);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

}
