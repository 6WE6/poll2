package com.briup.apps.poll.web.controller;

import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.service.QuestionnaireQuestionService;
import com.briup.apps.poll.util.MsgResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author JiaQi
 */

@Api(description = "问题评卷相关接口？")
@RestController
@RequestMapping("/QQ")
public class QuestionnaireQuestionController {

    @Resource
    private QuestionnaireQuestionService questionnaireQuestionService;//mapper

    /**
     * 获取全部
     * @param QQ
     * @return
     */
    @GetMapping("findAll")
    @ApiOperation(value = "获取全部")
    public MsgResponse findAll(@RequestParam QuestionnaireQuestionExample QQ){
        try{
            return new MsgResponse().success("200",questionnaireQuestionService.selectByExample(QQ));
        }catch (Exception e){
            return new MsgResponse().success("500",e.toString());
        }
    }

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    @ApiOperation(value = "通过id获取")
    @GetMapping("findById")
    public MsgResponse findById(@RequestParam Long id){
        try{
            return new MsgResponse().success("200",questionnaireQuestionService.selectByPrimaryKey(id));
        }catch (Exception e){
            return new MsgResponse().success("500",e.toString());
        }
    }

    /**
     * 通过id删除
     * @param id
     * @return
     */
    @GetMapping("delById")
    @ApiOperation(value = "通过id删除")
    public MsgResponse delById(@RequestParam Long id){
        try{
            return new MsgResponse().success("200",questionnaireQuestionService.deleteByPrimaryKey(id));
        }catch (Exception e){
            return new MsgResponse().success("500",e.toString());
        }
    }

    /**
     * 更新
     * @param QQ
     * @return
     */
    @PostMapping("update")
    @ApiOperation(value = "更新")
    public MsgResponse update(@RequestParam QuestionnaireQuestion QQ){
        try{
            return new MsgResponse().success("200",questionnaireQuestionService.updateByPrimaryKeySelective(QQ));
        }catch (Exception e){
            return new MsgResponse().success("500",e.toString());
        }
    }
}
