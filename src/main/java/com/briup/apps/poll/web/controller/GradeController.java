package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.extend.GradeVM;
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
			// 失败信息
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
			if (grade == null) {
				return MsgResponse.success("not find", grade);
			} else {
				return MsgResponse.success("success", grade);
			}

		} catch (Exception e) {
			//
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
		// 先查询id是否存在，确认后再删除
		try {
			Grade grade = new Grade();
			grade = gradeService.findGradeById(id);
			if (grade == null) {
				return MsgResponse.success("id not find", null);
			} else {
				gradeService.deleteGradeById(id);
				return MsgResponse.success("success", null);
			}
		} catch (Exception e) {
			//
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
			// 判断list是否为空
			list = gradeService.findGradeByKeyword(keywords);
			if (list.size() == 0) {
				return MsgResponse.success("not find", list);
			} else {
				return MsgResponse.success("success", list);
			}

		} catch (Exception e) {
			//
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
	public MsgResponse saveOrUpdateGrade(Grade grade) {
		try {
			
			return MsgResponse.success(gradeService.saveOrUpdateGrade(grade), null);
		} catch (Exception e) {
			//
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
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
	public MsgResponse batchDeleteGrade(Long[] ids) {
		try {
			List staffsList = Arrays.asList(ids);
			
			return MsgResponse.success(gradeService.batchDeleteGrade(staffsList), null);
		} catch (Exception e) {
			//
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	/**
	 * 根据年级查询学校
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据年级id查询所对应的学校")
	@GetMapping("findSchoolbyGrade")
	public MsgResponse findSchoolbyGrade(Long id) {
		try {
			GradeVM gradeVM = new GradeVM();
			gradeVM = gradeService.findSchoolbyGrade(id);
			if(gradeVM==null){
				return MsgResponse.success("not find", null);
			}else{
				return MsgResponse.success("success", gradeVM);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}


}
