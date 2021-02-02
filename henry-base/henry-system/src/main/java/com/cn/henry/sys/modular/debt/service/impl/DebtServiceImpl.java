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
package com.cn.henry.sys.modular.debt.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.henry.core.exception.ServiceException;
import com.cn.henry.core.factory.PageFactory;
import com.cn.henry.core.pojo.page.PageResult;
import com.cn.henry.sys.modular.debt.entity.Debt;
import com.cn.henry.sys.modular.debt.enums.DebtExceptionEnum;
import com.cn.henry.sys.modular.debt.mapper.DebtMapper;
import com.cn.henry.sys.modular.debt.param.DebtParam;
import com.cn.henry.sys.modular.debt.service.DebtService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 债务表service接口实现类
 *
 * @author henry
 * @date 2021-01-26 15:41:18
 */
@Service
public class DebtServiceImpl extends ServiceImpl<DebtMapper, Debt> implements DebtService {

    @Override
    public PageResult<Debt> page(DebtParam debtParam) {
        QueryWrapper<Debt> queryWrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotNull(debtParam)) {

            // 根据自增ID 查询
            if (ObjectUtil.isNotEmpty(debtParam.getId())) {
                queryWrapper.lambda().eq(Debt::getId, debtParam.getId());
            }

            // 根据用户id 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getUserId())) {
                queryWrapper.lambda().like(Debt::getUserId, debtParam.getUserId());
            }

            // 根据家庭id 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getFamilyId())) {
                queryWrapper.lambda().like(Debt::getFamilyId, debtParam.getFamilyId());
            }

            // 根据债务类型欠债1,借出2 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getDebtType())) {
                queryWrapper.lambda().like(Debt::getDebtType, debtParam.getDebtType());
            }

            // 根据金额 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getMoney())) {
                queryWrapper.lambda().like(Debt::getMoney, debtParam.getMoney());
            }

            // 根据债务记录日期 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getDebtDate())) {
                queryWrapper.lambda().like(Debt::getDebtDate, debtParam.getDebtDate());
            }

            // 根据对方姓名 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getName())) {
                queryWrapper.lambda().like(Debt::getName, debtParam.getName());
            }

            // 根据约定归还日期 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getRefundDate())) {
                queryWrapper.lambda().like(Debt::getRefundDate, debtParam.getRefundDate());
            }

            // 根据是否归还,N否,Y是 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getIsRefund())) {
                queryWrapper.lambda().like(Debt::getIsRefund, debtParam.getIsRefund());
            }

            // 根据债务原因 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getDebtReason())) {
                queryWrapper.lambda().like(Debt::getDebtReason, debtParam.getDebtReason());
            }

            // 根据证据截图 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getDebtImg())) {
                queryWrapper.lambda().like(Debt::getDebtImg, debtParam.getDebtImg());
            }

            // 根据身份证号 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getCardid())) {
                queryWrapper.lambda().like(Debt::getCardid, debtParam.getCardid());
            }

            // 根据电话号码 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getPhone())) {
                queryWrapper.lambda().like(Debt::getPhone, debtParam.getPhone());
            }

            // 根据家庭地址 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getFamilyAddress())) {
                queryWrapper.lambda().like(Debt::getFamilyAddress, debtParam.getFamilyAddress());
            }

            // 根据 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getRemark())) {
                queryWrapper.lambda().like(Debt::getRemark, debtParam.getRemark());
            }

            // 根据 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getState())) {
                queryWrapper.lambda().like(Debt::getState, debtParam.getState());
            }

            // 根据 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getExt1())) {
                queryWrapper.lambda().like(Debt::getExt1, debtParam.getExt1());
            }

        }
        return new PageResult<>(this.page(PageFactory.defaultPage(), queryWrapper));
    }

    @Override
    public List<Debt> list(DebtParam debtParam) {
        LambdaQueryWrapper<Debt> queryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtil.isNotNull(debtParam)) {

            // 根据自增ID 查询
            if (ObjectUtil.isNotEmpty(debtParam.getId())) {
                queryWrapper.eq(Debt::getId, debtParam.getId());
            }

            // 根据用户id 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getUserId())) {
                queryWrapper.like(Debt::getUserId, debtParam.getUserId());
            }

            // 根据家庭id 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getFamilyId())) {
                queryWrapper.like(Debt::getFamilyId, debtParam.getFamilyId());
            }

            // 根据债务类型欠债1,借出2 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getDebtType())) {
                queryWrapper.like(Debt::getDebtType, debtParam.getDebtType());
            }

            // 根据金额 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getMoney())) {
                queryWrapper.like(Debt::getMoney, debtParam.getMoney());
            }

            // 根据债务记录日期 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getDebtDate())) {
                queryWrapper.like(Debt::getDebtDate, debtParam.getDebtDate());
            }

            // 根据对方姓名 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getName())) {
                queryWrapper.like(Debt::getName, debtParam.getName());
            }

            // 根据约定归还日期 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getRefundDate())) {
                queryWrapper.like(Debt::getRefundDate, debtParam.getRefundDate());
            }

            // 根据是否归还,N否,Y是 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getIsRefund())) {
                queryWrapper.like(Debt::getIsRefund, debtParam.getIsRefund());
            }

            // 根据债务原因 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getDebtReason())) {
                queryWrapper.like(Debt::getDebtReason, debtParam.getDebtReason());
            }

            // 根据证据截图 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getDebtImg())) {
                queryWrapper.like(Debt::getDebtImg, debtParam.getDebtImg());
            }

            // 根据身份证号 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getCardid())) {
                queryWrapper.like(Debt::getCardid, debtParam.getCardid());
            }

            // 根据电话号码 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getPhone())) {
                queryWrapper.like(Debt::getPhone, debtParam.getPhone());
            }

            // 根据家庭地址 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getFamilyAddress())) {
                queryWrapper.like(Debt::getFamilyAddress, debtParam.getFamilyAddress());
            }

            // 根据 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getRemark())) {
                queryWrapper.like(Debt::getRemark, debtParam.getRemark());
            }

            // 根据 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getState())) {
                queryWrapper.like(Debt::getState, debtParam.getState());
            }

            // 根据 模糊查询
            if (ObjectUtil.isNotEmpty(debtParam.getExt1())) {
                queryWrapper.like(Debt::getExt1, debtParam.getExt1());
            }

        }
        return this.list(queryWrapper);
    }

    @Override
    public void add(DebtParam debtParam) {
        Debt debt = new Debt();
        BeanUtil.copyProperties(debtParam, debt);
        this.save(debt);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(DebtParam debtParam) {
            this.removeById(debtParam.getId());
                                                                        }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(DebtParam debtParam) {
        Debt debt = this.queryDebt(debtParam);
        BeanUtil.copyProperties(debtParam, debt);
        this.updateById(debt);
    }

    @Override
    public Debt detail(DebtParam debtParam) {
        return this.queryDebt(debtParam);
    }

    /**
     * 获取债务表
     *
     * @author henry
     * @date 2021-01-26 15:41:18
     */
    private Debt queryDebt(DebtParam debtParam) {
        Debt debt = this.getById(debtParam.getId());
        if (ObjectUtil.isNull(debt)) {
            throw new ServiceException(DebtExceptionEnum.NOT_EXIST);
        }
        return debt;
    }
}
