/*
Copyright [2020] [https://www.xiaonuo.vip]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

XiaoNuo采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：

1.请不要删除和修改根目录下的LICENSE文件。
2.请不要删除和修改XiaoNuo源码头部的版权声明。
3.请保留源码和相关描述文件的项目出处，作者声明等。
4.分发源码时候，请注明软件出处 https://gitee.com/xiaonuobase/xiaonuo-vue
5.在修改包名，模块名称，项目代码等时，请注明软件出处 https://gitee.com/xiaonuobase/xiaonuo-vue
6.若您的项目无法满足以上几点，可申请商业授权，获取XiaoNuo商业授权许可，请在官网购买授权，地址为 https://www.xiaonuo.vip
 */
package com.cn.henry.sys.modular.familyconfig.controller;

import com.cn.henry.core.annotion.BusinessLog;
import com.cn.henry.core.annotion.Permission;
import com.cn.henry.core.enums.LogAnnotionOpTypeEnum;
import com.cn.henry.core.pojo.response.ResponseData;
import com.cn.henry.core.pojo.response.SuccessResponseData;

import com.cn.henry.sys.modular.familyconfig.param.FamilyConfigParam;
import com.cn.henry.sys.modular.familyconfig.service.FamilyConfigService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.annotation.Resource;

/**
 * 家庭初始配置表控制器
 *
 * @author henry
 * @date 2021-01-25 20:00:45
 */
@RestController
public class FamilyConfigController {

    @Resource
    private FamilyConfigService familyConfigService;

    /**
     * 查询家庭初始配置表
     *
     * @author henry
     * @date 2021-01-25 20:00:45
     */
    @Permission
    @GetMapping("/familyConfig/page")
    @BusinessLog(title = "家庭初始配置表_查询", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData page(FamilyConfigParam familyConfigParam) {
        return new SuccessResponseData(familyConfigService.page(familyConfigParam));
    }

    /**
     * 添加家庭初始配置表
     *
     * @author henry
     * @date 2021-01-25 20:00:45
     */
    @Permission
    @PostMapping("/familyConfig/add")
    @BusinessLog(title = "家庭初始配置表_增加", opType = LogAnnotionOpTypeEnum.ADD)
    public ResponseData add(@RequestBody @Validated(FamilyConfigParam.add.class) FamilyConfigParam familyConfigParam) {
        familyConfigService.add(familyConfigParam);
        return new SuccessResponseData();
    }

    /**
     * 删除家庭初始配置表
     *
     * @author henry
     * @date 2021-01-25 20:00:45
     */
    @Permission
    @PostMapping("/familyConfig/delete")
    @BusinessLog(title = "家庭初始配置表_删除", opType = LogAnnotionOpTypeEnum.DELETE)
    public ResponseData delete(@RequestBody @Validated(FamilyConfigParam.delete.class) FamilyConfigParam familyConfigParam) {
        familyConfigService.delete(familyConfigParam);
        return new SuccessResponseData();
    }

    /**
     * 编辑家庭初始配置表
     *
     * @author henry
     * @date 2021-01-25 20:00:45
     */
    @Permission
    @PostMapping("/familyConfig/edit")
    @BusinessLog(title = "家庭初始配置表_编辑", opType = LogAnnotionOpTypeEnum.EDIT)
    public ResponseData edit(@RequestBody @Validated(FamilyConfigParam.edit.class) FamilyConfigParam familyConfigParam) {
        familyConfigService.edit(familyConfigParam);
        return new SuccessResponseData();
    }

    /**
     * 查看家庭初始配置表
     *
     * @author henry
     * @date 2021-01-25 20:00:45
     */
    @Permission
    @GetMapping("/familyConfig/detail")
    @BusinessLog(title = "家庭初始配置表_查看", opType = LogAnnotionOpTypeEnum.DETAIL)
    public ResponseData detail(@Validated(FamilyConfigParam.detail.class) FamilyConfigParam familyConfigParam) {
        return new SuccessResponseData(familyConfigService.detail(familyConfigParam));
    }

    /**
     * 家庭初始配置表列表
     *
     * @author henry
     * @date 2021-01-25 20:00:45
     */
    @Permission
    @GetMapping("/familyConfig/list")
    @BusinessLog(title = "家庭初始配置表_列表", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData list(FamilyConfigParam familyConfigParam) {
        return new SuccessResponseData(familyConfigService.list(familyConfigParam));
    }

}
