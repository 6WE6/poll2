package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.service.IOptionsService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="选项相关接口")
@RestController
@RequestMapping("/options")
public class OptionsController {
	
	@Autowired
	private IOptionsService optionsService;
	
	@ApiOperation(value="查询所有选项信息")
	@GetMapping("findAllOptions")
	public MsgResponse findAllOptions(){
		try {
			List<Options> list = optionsService.findAllOptions();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	@ApiOperation(value="保存或更新选项信息")
	@GetMapping("saveOrUpdateOptions")
	public MsgResponse saveOrUpdateOptions(Options options){
		try {
			optionsService.saveOrUpdateOptions(options);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	
	@ApiOperation(value="根据id删除选项信息")
	@GetMapping("deleteOptionsById")
	public MsgResponse deleteOptionsById(long id){
		try {
			optionsService.deleteOptionsById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}

}
