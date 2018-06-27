package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 视图控制层 班级
 * 
 * @author lixiaofeng
 *
 */
@Api(description = "班级相关接口")
@RestController
@RequestMapping("/clazz")
public class ClazzController {
	@Autowired
	private IClazzService clazzService;

	/**
	 * 查询所有班级信息
	 * 
	 * @return
	 */
	@ApiOperation(value = "查询所有班级信息")
	@GetMapping("findAllClazz")
	public MsgResponse findAllClazz() {
		try {
			List<Clazz> list = clazzService.findAllClazz();
			// 返回成功信息
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			// 返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 通过id查询班级信息
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "通过id查询班级信息")
	@GetMapping("findClazzById")
	public MsgResponse findClazzById(@RequestParam long id) {
		Clazz clazz=new Clazz();
		try {

			clazz=clazzService.findClazzById(id);
			return MsgResponse.success("success",clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 根据关键字查询班级信息
	 * 
	 * @param keyWords
	 * @return
	 */
	@ApiOperation(value = "根据关键字查询班级信息", notes = "输入name中关键字进行查询")
	@GetMapping("findClazzByKeyword")
	public MsgResponse findClazzByKeyword(@RequestParam String keyWords) {
		try {
			List<Clazz> list = clazzService.query(keyWords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 保存或者更新班级信息
	 * 
	 * @param clazz
	 * @return
	 */
	@ApiOperation(value = "保存或者更新班级信息", notes = "执行插入操作时不需要输入id，输入id时执行更新操作")
	@GetMapping("saveOrUpdateClazz")
	public MsgResponse saveOrUpdateClazz(Clazz clazz) {
		try {
			clazzService.saveOrUpdateClazz(clazz);
			return MsgResponse.success("success", clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 根据id删除班级信息
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据id删除班级信息")
	@GetMapping("deleteClazzById")
	public MsgResponse deleteClazzById(@RequestParam long id) {
		try {
			clazzService.deleteClazzById(id);
			return MsgResponse.success("success", "删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	/**
	 * 批量删除班级信息
	 * 
	 * @param ids
	 * @return
	 */

	@ApiOperation(value = "批量删除班级信息", notes = "使用回车键输入多个id值")
	@GetMapping("batchDeleteClazz")
	public MsgResponse batchDeleteClazz(@RequestParam long[] ids) {
		try {
			clazzService.batchDeleteClazz(ids);
			return MsgResponse.success("success", "批量删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}