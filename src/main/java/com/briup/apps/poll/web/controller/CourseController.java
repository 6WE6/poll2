package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 视图控制层    课程
 * @author WE
 *
 */
@Api(description="课程相关接口")
@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private ICourseService courseService;
	
	@ApiOperation(value="查询所有课程信息")
	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse(){
		
		try {
			List<Course> list =courseService.findAllCourse();
			//返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
		
	}

}
