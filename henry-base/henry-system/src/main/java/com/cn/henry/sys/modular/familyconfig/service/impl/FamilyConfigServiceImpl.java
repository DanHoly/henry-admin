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
package com.cn.henry.sys.modular.familyconfig.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.henry.core.exception.ServiceException;
import com.cn.henry.core.factory.PageFactory;
import com.cn.henry.core.pojo.page.PageResult;

import com.cn.henry.sys.modular.familyconfig.entity.FamilyConfig;
import com.cn.henry.sys.modular.familyconfig.enums.FamilyConfigExceptionEnum;
import com.cn.henry.sys.modular.familyconfig.mapper.FamilyConfigMapper;
import com.cn.henry.sys.modular.familyconfig.param.FamilyConfigParam;
import com.cn.henry.sys.modular.familyconfig.service.FamilyConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 家庭初始配置表service接口实现类
 *
 * @author henry
 * @date 2021-01-25 20:00:45
 */
@Service
public class FamilyConfigServiceImpl extends ServiceImpl<FamilyConfigMapper, FamilyConfig> implements FamilyConfigService {

    @Override
    public PageResult<FamilyConfig> page(FamilyConfigParam familyConfigParam) {
        QueryWrapper<FamilyConfig> queryWrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotNull(familyConfigParam)) {

            // 根据自增ID 查询
            if (ObjectUtil.isNotEmpty(familyConfigParam.getId())) {
                queryWrapper.lambda().eq(FamilyConfig::getId, familyConfigParam.getId());
            }

            // 根据家庭名称 模糊查询
            if (ObjectUtil.isNotEmpty(familyConfigParam.getName())) {
                queryWrapper.lambda().like(FamilyConfig::getName, familyConfigParam.getName());
            }

            // 根据初始总资产 模糊查询
            if (ObjectUtil.isNotEmpty(familyConfigParam.getInitMoney())) {
                queryWrapper.lambda().like(FamilyConfig::getInitMoney, familyConfigParam.getInitMoney());
            }

            // 根据负债 模糊查询
            if (ObjectUtil.isNotEmpty(familyConfigParam.getDebt())) {
                queryWrapper.lambda().like(FamilyConfig::getDebt, familyConfigParam.getDebt());
            }

            // 根据存款 模糊查询
            if (ObjectUtil.isNotEmpty(familyConfigParam.getDeposit())) {
                queryWrapper.lambda().like(FamilyConfig::getDeposit, familyConfigParam.getDeposit());
            }

            // 根据 模糊查询
            if (ObjectUtil.isNotEmpty(familyConfigParam.getState())) {
                queryWrapper.lambda().like(FamilyConfig::getState, familyConfigParam.getState());
            }

            // 根据 模糊查询
            if (ObjectUtil.isNotEmpty(familyConfigParam.getRemark())) {
                queryWrapper.lambda().like(FamilyConfig::getRemark, familyConfigParam.getRemark());
            }

        }
        return new PageResult<>(this.page(PageFactory.defaultPage(), queryWrapper));
    }

    @Override
    public List<FamilyConfig> list(FamilyConfigParam familyConfigParam) {
        LambdaQueryWrapper<FamilyConfig> queryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtil.isNotNull(familyConfigParam)) {

            // 根据自增ID 查询
            if (ObjectUtil.isNotEmpty(familyConfigParam.getId())) {
                queryWrapper.eq(FamilyConfig::getId, familyConfigParam.getId());
            }

            // 根据家庭名称 模糊查询
            if (ObjectUtil.isNotEmpty(familyConfigParam.getName())) {
                queryWrapper.like(FamilyConfig::getName, familyConfigParam.getName());
            }

            // 根据初始总资产 模糊查询
            if (ObjectUtil.isNotEmpty(familyConfigParam.getInitMoney())) {
                queryWrapper.like(FamilyConfig::getInitMoney, familyConfigParam.getInitMoney());
            }

            // 根据负债 模糊查询
            if (ObjectUtil.isNotEmpty(familyConfigParam.getDebt())) {
                queryWrapper.like(FamilyConfig::getDebt, familyConfigParam.getDebt());
            }

            // 根据存款 模糊查询
            if (ObjectUtil.isNotEmpty(familyConfigParam.getDeposit())) {
                queryWrapper.like(FamilyConfig::getDeposit, familyConfigParam.getDeposit());
            }

            // 根据 模糊查询
            if (ObjectUtil.isNotEmpty(familyConfigParam.getState())) {
                queryWrapper.like(FamilyConfig::getState, familyConfigParam.getState());
            }

            // 根据 模糊查询
            if (ObjectUtil.isNotEmpty(familyConfigParam.getRemark())) {
                queryWrapper.like(FamilyConfig::getRemark, familyConfigParam.getRemark());
            }

        }
        return this.list(queryWrapper);
    }

    @Override
    public void add(FamilyConfigParam familyConfigParam) {
        FamilyConfig familyConfig = new FamilyConfig();
        BeanUtil.copyProperties(familyConfigParam, familyConfig);
        this.save(familyConfig);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(FamilyConfigParam familyConfigParam) {
            this.removeById(familyConfigParam.getId());
                                }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(FamilyConfigParam familyConfigParam) {
        FamilyConfig familyConfig = this.queryFamilyConfig(familyConfigParam);
        BeanUtil.copyProperties(familyConfigParam, familyConfig);
        this.updateById(familyConfig);
    }

    @Override
    public FamilyConfig detail(FamilyConfigParam familyConfigParam) {
        return this.queryFamilyConfig(familyConfigParam);
    }

    /**
     * 获取家庭初始配置表
     *
     * @author henry
     * @date 2021-01-25 20:00:45
     */
    private FamilyConfig queryFamilyConfig(FamilyConfigParam familyConfigParam) {
        FamilyConfig familyConfig = this.getById(familyConfigParam.getId());
        if (ObjectUtil.isNull(familyConfig)) {
            throw new ServiceException(FamilyConfigExceptionEnum.NOT_EXIST);
        }
        return familyConfig;
    }
}
