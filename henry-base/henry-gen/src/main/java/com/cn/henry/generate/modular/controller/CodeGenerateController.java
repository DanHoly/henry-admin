
package com.cn.henry.generate.modular.controller;

import com.cn.henry.core.annotion.BusinessLog;
import com.cn.henry.core.annotion.Permission;
import com.cn.henry.core.context.constant.ConstantContextHolder;
import com.cn.henry.core.enums.LogAnnotionOpTypeEnum;
import com.cn.henry.core.exception.DemoException;
import com.cn.henry.core.pojo.response.ResponseData;
import com.cn.henry.core.pojo.response.SuccessResponseData;
import com.cn.henry.generate.modular.param.CodeGenerateParam;
import com.cn.henry.generate.modular.service.CodeGenerateService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 代码生成器
 *
 * @auther yubaoshan
 * @date 12/15/20 11:20 PM
 */
@RestController
public class CodeGenerateController {

    @Resource
    private CodeGenerateService codeGenerateService;

    /**
     * 代码生成基础数据
     *
     * @author yubaoshan
     * @date 2020年12月16日20:58:48
     */
    @Permission
    @GetMapping("/codeGenerate/page")
    @BusinessLog(title = "代码生成配置_查询", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData page(CodeGenerateParam codeGenerateParam) {
        return new SuccessResponseData(codeGenerateService.page(codeGenerateParam));
    }

    /**
     * 代码生成基础配置保存
     *
     * @auther yubaoshan
     * @date 12/15/20 11:20 PM
     */
    @Permission
    @PostMapping("/codeGenerate/add")
    @BusinessLog(title = "代码生成配置_增加", opType = LogAnnotionOpTypeEnum.ADD)
    public ResponseData add(@RequestBody @Validated(CodeGenerateParam.add.class) CodeGenerateParam codeGenerateParam) {
        this.codeGenerateService.add(codeGenerateParam);
        return new SuccessResponseData();
    }

    /**
     * 代码生成基础配置编辑
     *
     * @auther yubaoshan
     * @date 2020年12月16日20:56:19
     */
    @Permission
    @PostMapping("/codeGenerate/edit")
    @BusinessLog(title = "代码生成配置_编辑", opType = LogAnnotionOpTypeEnum.EDIT)
    public ResponseData edit(@RequestBody @Validated(CodeGenerateParam.add.class) CodeGenerateParam codeGenerateParam) {
        codeGenerateService.edit(codeGenerateParam);
        return new SuccessResponseData();
    }

    /**
     * 删除代码生成基础配置
     *
     * @author yubaoshan
     * @date 2020年12月16日22:13:32
     */
    @Permission
    @PostMapping("/codeGenerate/delete")
    @BusinessLog(title = "代码生成配置_删除", opType = LogAnnotionOpTypeEnum.DELETE)
    public ResponseData delete(@RequestBody @Validated(CodeGenerateParam.delete.class) List<CodeGenerateParam> codeGenerateParamList) {
        codeGenerateService.delete(codeGenerateParamList);
        return new SuccessResponseData();
    }

    /**
     * 查询当前数据库用户下的所有表
     *
     * @author yubaoshan
     * @date 2020-12-16 01:55:48
     */
    @Permission
    @GetMapping("/codeGenerate/InformationList")
    @BusinessLog(title = "数据库表列表_查询", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData InformationList() {
        return ResponseData.success(codeGenerateService.InformationTableList());
    }

    /**
     * 代码生成基础配置生成
     *
     * @auther yubaoshan
     * @date 12/15/20 11:20 PM
     */
    @Permission
    @PostMapping("/codeGenerate/runLocal")
    @BusinessLog(title = "代码生成_本地项目", opType = LogAnnotionOpTypeEnum.OTHER)
    public ResponseData runLocal(@RequestBody @Validated(CodeGenerateParam.detail.class) CodeGenerateParam codeGenerateParam) {
        // 演示环境开启，则不允许操作
        if (ConstantContextHolder.getDemoEnvFlag()) {
            throw new DemoException();
        }
        this.codeGenerateService.runLocal(codeGenerateParam);
        return new SuccessResponseData();
    }

    /**
     * 代码生成基础配置生成
     *
     * @auther yubaoshan
     * @date 12/15/20 11:20 PM
     */
    @Permission
    @GetMapping("/codeGenerate/runDown")
    @BusinessLog(title = "代码生成_下载方式", opType = LogAnnotionOpTypeEnum.OTHER)
    public void runDown(@Validated(CodeGenerateParam.detail.class) CodeGenerateParam codeGenerateParam, HttpServletResponse response) {
        // 演示环境开启，则不允许操作
        if (ConstantContextHolder.getDemoEnvFlag()) {
            throw new DemoException();
        }
        this.codeGenerateService.runDown(codeGenerateParam, response);
    }
}
