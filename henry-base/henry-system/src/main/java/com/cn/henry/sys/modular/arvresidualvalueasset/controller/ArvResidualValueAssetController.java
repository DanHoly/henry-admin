
package com.cn.henry.sys.modular.arvresidualvalueasset.controller;

import com.cn.henry.sys.modular.arvresidualvalueasset.service.ArvResidualValueAssetService;
import com.cn.henry.core.annotion.BusinessLog;
import com.cn.henry.core.annotion.Permission;
import com.cn.henry.core.enums.LogAnnotionOpTypeEnum;
import com.cn.henry.core.pojo.response.ResponseData;
import com.cn.henry.core.pojo.response.SuccessResponseData;
import com.cn.henry.sys.modular.arvresidualvalueasset.param.ArvResidualValueAssetParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 资产残值表控制器
 *
 * @author hudong
 * @date 2021-01-19 11:13:43
 */
@RestController
public class ArvResidualValueAssetController {

    @Resource
    private ArvResidualValueAssetService arvResidualValueAssetService;

    /**
     * 查询资产残值表
     *
     * @author hudong
     * @date 2021-01-19 11:13:43
     */
    @Permission
    @GetMapping("/arvResidualValueAsset/page")
    @BusinessLog(title = "资产残值表_查询", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData page(ArvResidualValueAssetParam arvResidualValueAssetParam) {
        return new SuccessResponseData(arvResidualValueAssetService.page(arvResidualValueAssetParam));
    }

    /**
     * 添加资产残值表
     *
     * @author hudong
     * @date 2021-01-19 11:13:43
     */
    @Permission
    @PostMapping("/arvResidualValueAsset/add")
    @BusinessLog(title = "资产残值表_增加", opType = LogAnnotionOpTypeEnum.ADD)
    public ResponseData add(@RequestBody @Validated(ArvResidualValueAssetParam.add.class) ArvResidualValueAssetParam arvResidualValueAssetParam) {
        arvResidualValueAssetService.add(arvResidualValueAssetParam);
        return new SuccessResponseData();
    }

    /**
     * 删除资产残值表
     *
     * @author hudong
     * @date 2021-01-19 11:13:43
     */
    @Permission
    @PostMapping("/arvResidualValueAsset/delete")
    @BusinessLog(title = "资产残值表_删除", opType = LogAnnotionOpTypeEnum.DELETE)
    public ResponseData delete(@RequestBody @Validated(ArvResidualValueAssetParam.delete.class) ArvResidualValueAssetParam arvResidualValueAssetParam) {
        arvResidualValueAssetService.delete(arvResidualValueAssetParam);
        return new SuccessResponseData();
    }

    /**
     * 编辑资产残值表
     *
     * @author hudong
     * @date 2021-01-19 11:13:43
     */
    @Permission
    @PostMapping("/arvResidualValueAsset/edit")
    @BusinessLog(title = "资产残值表_编辑", opType = LogAnnotionOpTypeEnum.EDIT)
    public ResponseData edit(@RequestBody @Validated(ArvResidualValueAssetParam.edit.class) ArvResidualValueAssetParam arvResidualValueAssetParam) {
        arvResidualValueAssetService.edit(arvResidualValueAssetParam);
        return new SuccessResponseData();
    }

    /**
     * 查看资产残值表
     *
     * @author hudong
     * @date 2021-01-19 11:13:43
     */
    @Permission
    @GetMapping("/arvResidualValueAsset/detail")
    @BusinessLog(title = "资产残值表_查看", opType = LogAnnotionOpTypeEnum.DETAIL)
    public ResponseData detail(@Validated(ArvResidualValueAssetParam.detail.class) ArvResidualValueAssetParam arvResidualValueAssetParam) {
        return new SuccessResponseData(arvResidualValueAssetService.detail(arvResidualValueAssetParam));
    }

    /**
     * 资产残值表列表
     *
     * @author hudong
     * @date 2021-01-19 11:13:43
     */
    @Permission
    @GetMapping("/arvResidualValueAsset/list")
    @BusinessLog(title = "资产残值表_列表", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData list(ArvResidualValueAssetParam arvResidualValueAssetParam) {
        return new SuccessResponseData(arvResidualValueAssetService.list(arvResidualValueAssetParam));
    }

}
