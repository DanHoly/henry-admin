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
package com.cn.henry.sys.modular.debt.controller;

import com.cn.henry.core.annotion.BusinessLog;
import com.cn.henry.core.annotion.Permission;
import com.cn.henry.core.enums.LogAnnotionOpTypeEnum;
import com.cn.henry.core.pojo.response.ResponseData;
import com.cn.henry.core.pojo.response.SuccessResponseData;
import com.cn.henry.sys.modular.debt.param.DebtParam;
import com.cn.henry.sys.modular.debt.service.DebtService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.annotation.Resource;

/**
 * 债务表控制器
 *
 * @author henry
 * @date 2021-01-26 15:41:18
 */
@RestController
public class DebtController {

    @Resource
    private DebtService debtService;

    /**
     * 查询债务表
     *
     * @author henry
     * @date 2021-01-26 15:41:18
     */
    @Permission
    @GetMapping("/debt/page")
    @BusinessLog(title = "债务表_查询", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData page(DebtParam debtParam) {
        return new SuccessResponseData(debtService.page(debtParam));
    }

    /**
     * 添加债务表
     *
     * @author henry
     * @date 2021-01-26 15:41:18
     */
    @Permission
    @PostMapping("/debt/add")
    @BusinessLog(title = "债务表_增加", opType = LogAnnotionOpTypeEnum.ADD)
    public ResponseData add(@RequestBody @Validated(DebtParam.add.class) DebtParam debtParam) {
        debtService.add(debtParam);
        return new SuccessResponseData();
    }

    /**
     * 删除债务表
     *
     * @author henry
     * @date 2021-01-26 15:41:18
     */
    @Permission
    @PostMapping("/debt/delete")
    @BusinessLog(title = "债务表_删除", opType = LogAnnotionOpTypeEnum.DELETE)
    public ResponseData delete(@RequestBody @Validated(DebtParam.delete.class) DebtParam debtParam) {
        debtService.delete(debtParam);
        return new SuccessResponseData();
    }

    /**
     * 编辑债务表
     *
     * @author henry
     * @date 2021-01-26 15:41:18
     */
    @Permission
    @PostMapping("/debt/edit")
    @BusinessLog(title = "债务表_编辑", opType = LogAnnotionOpTypeEnum.EDIT)
    public ResponseData edit(@RequestBody @Validated(DebtParam.edit.class) DebtParam debtParam) {
        debtService.edit(debtParam);
        return new SuccessResponseData();
    }

    /**
     * 查看债务表
     *
     * @author henry
     * @date 2021-01-26 15:41:18
     */
    @Permission
    @GetMapping("/debt/detail")
    @BusinessLog(title = "债务表_查看", opType = LogAnnotionOpTypeEnum.DETAIL)
    public ResponseData detail(@Validated(DebtParam.detail.class) DebtParam debtParam) {
        return new SuccessResponseData(debtService.detail(debtParam));
    }

    /**
     * 债务表列表
     *
     * @author henry
     * @date 2021-01-26 15:41:18
     */
    @Permission
    @GetMapping("/debt/list")
    @BusinessLog(title = "债务表_列表", opType = LogAnnotionOpTypeEnum.QUERY)
    public ResponseData list(DebtParam debtParam) {
        return new SuccessResponseData(debtService.list(debtParam));
    }

}
