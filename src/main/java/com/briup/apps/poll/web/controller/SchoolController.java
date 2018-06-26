package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.service.ISchoolService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/school")
@Api(description="学校相关接口")
public class SchoolController {

	@Autowired
	private ISchoolService schoolService;

	@GetMapping("findAllSchool")
	@ApiOperation(value="查询所有学校信息",notes="保存学校信息时无需输入id")
	public MsgResponse findAllSchool(){
		try {
			List<School> list =schoolService.findAllSchool();
			//返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}		
	}

	@GetMapping("findSchoolById")
	@ApiOperation(value="通过id查询学校信息")
	public MsgResponse findSchoolById(@RequestParam long id){
		School school = new School();
		try {
			school = schoolService.findSchoolById(id);
			return MsgResponse.success("success", school);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@GetMapping("deleteSchoolById")
	@ApiOperation(value="通过id删除学校信息")
	public MsgResponse deleteSchoolById(@RequestParam long id){
		//调用service层代码完成学校信息的删除
		try {
			schoolService.deleteSchoolById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
			
		}
	}

	@GetMapping("findSchoolByKeyword")
	@ApiOperation(value="通过关键字查询学校信息")
	public MsgResponse findSchoolByKeyword(@RequestParam String keywords){
		School school = new School();
		try {
			school = (School) schoolService.findSchoolByKeyword(keywords);
			return MsgResponse.success("success", school);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}

	@PostMapping("saveOrUpdateSchool")
	@ApiOperation(value="保存或更新学校信息，如果是保存新学校信息，请不要填id！")
	public String saveOrUpdateSchool(School school){
		try {
			schoolService.saveOrUpdateSchool(school);
			return "操作成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "操作失败！"+e.getMessage();
		}
	}

	@GetMapping("batchDeleteSchool")
	@ApiOperation(value="批量删除学校信息")
	public MsgResponse batchDeleteCoure(List<Long> ids){
		try {
			schoolService.batchDeleteSchool(ids);
			return MsgResponse.success("success", ids);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
