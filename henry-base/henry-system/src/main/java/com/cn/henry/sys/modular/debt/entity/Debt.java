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
package com.cn.henry.sys.modular.debt.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.cn.henry.core.pojo.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 债务表
 *
 * @author henry
 * @date 2021-01-26 15:41:18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("f_debt")
public class Debt extends BaseEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 家庭id
     */
    private Long familyId;

    /**
     * 债务类型欠债1,借出2
     */
    private Integer debtType;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 债务记录日期
     */
    private Date debtDate;

    /**
     * 对方姓名
     */
    private String name;

    /**
     * 约定归还日期
     */
    private Date refundDate;

    /**
     * 是否归还,N否,Y是
     */
    private String isRefund;

    /**
     * 债务原因
     */
    private String debtReason;

    /**
     * 证据截图
     */
    private String debtImg;

    /**
     * 身份证号
     */
    private String cardid;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 家庭地址
     */
    private String familyAddress;

    /**
     * 
     */
    private String remark;

    /**
     * 
     */
    private String state;

    /**
     * 
     */
    private String ext1;
}
