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
package com.cn.henry.sys.modular.debt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.henry.core.pojo.page.PageResult;
import com.cn.henry.sys.modular.debt.entity.Debt;
import com.cn.henry.sys.modular.debt.param.DebtParam;
import java.util.List;

/**
 * 债务表service接口
 *
 * @author henry
 * @date 2021-01-26 15:41:18
 */
public interface DebtService extends IService<Debt> {

    /**
     * 查询债务表
     *
     * @author henry
     * @date 2021-01-26 15:41:18
     */
    PageResult<Debt> page(DebtParam debtParam);

    /**
     * 债务表列表
     *
     * @author henry
     * @date 2021-01-26 15:41:18
     */
    List<Debt> list(DebtParam debtParam);

    /**
     * 添加债务表
     *
     * @author henry
     * @date 2021-01-26 15:41:18
     */
    void add(DebtParam debtParam);

    /**
     * 删除债务表
     *
     * @author henry
     * @date 2021-01-26 15:41:18
     */
    void delete(DebtParam debtParam);

    /**
     * 编辑债务表
     *
     * @author henry
     * @date 2021-01-26 15:41:18
     */
    void edit(DebtParam debtParam);

    /**
     * 查看债务表
     *
     * @author henry
     * @date 2021-01-26 15:41:18
     */
     Debt detail(DebtParam debtParam);
}
