
package com.cn.henry.sys.modular.arvresidualvalueasset.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.henry.sys.modular.arvresidualvalueasset.service.ArvResidualValueAssetService;
import com.cn.henry.core.exception.ServiceException;
import com.cn.henry.core.factory.PageFactory;
import com.cn.henry.core.pojo.page.PageResult;
import com.cn.henry.sys.modular.arvresidualvalueasset.entity.ArvResidualValueAsset;
import com.cn.henry.sys.modular.arvresidualvalueasset.enums.ArvResidualValueAssetExceptionEnum;
import com.cn.henry.sys.modular.arvresidualvalueasset.mapper.ArvResidualValueAssetMapper;
import com.cn.henry.sys.modular.arvresidualvalueasset.param.ArvResidualValueAssetParam;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 资产残值表service接口实现类
 *
 * @author hudong
 * @date 2021-01-19 11:13:43
 */
@Service
public class ArvResidualValueAssetServiceImpl extends ServiceImpl<ArvResidualValueAssetMapper, ArvResidualValueAsset> implements ArvResidualValueAssetService {

    @Override
    public PageResult<ArvResidualValueAsset> page(ArvResidualValueAssetParam arvResidualValueAssetParam) {
        QueryWrapper<ArvResidualValueAsset> queryWrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotNull(arvResidualValueAssetParam)) {

            // 根据资产追踪码 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getAssetTrackCode())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getAssetTrackCode, arvResidualValueAssetParam.getAssetTrackCode());
            }

            // 根据设备类型(0 无 1 桌面机 2 柜机 3 移动充电宝 4 充电线 5 无线辅助通讯设备) 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getDeviceType())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getDeviceType, arvResidualValueAssetParam.getDeviceType());
            }

            // 根据资产业务属性（0  无  1.  直营  2.代理  3  服务商） 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getBusinessType())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getBusinessType, arvResidualValueAssetParam.getBusinessType());
            }

            // 根据资产唯一码 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getAssetItemNo())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getAssetItemNo, arvResidualValueAssetParam.getAssetItemNo());
            }

            // 根据资产类别编码 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getAssetCategoryCode())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getAssetCategoryCode, arvResidualValueAssetParam.getAssetCategoryCode());
            }

            // 根据类型编码 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getAssetTypeCode())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getAssetTypeCode, arvResidualValueAssetParam.getAssetTypeCode());
            }

            // 根据mac 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getMacCode())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getMacCode, arvResidualValueAssetParam.getMacCode());
            }

            // 根据sn 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getSnCode())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getSnCode, arvResidualValueAssetParam.getSnCode());
            }

            // 根据资产财务属性（0 固定资产 1 存货 2 售出品 3 虚拟测试 4 实体测试 5 赠品 ） 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getAssetFinancialAttribute())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getAssetFinancialAttribute, arvResidualValueAssetParam.getAssetFinancialAttribute());
            }

            // 根据固定资产时间 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getPermanentTime())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getPermanentTime, arvResidualValueAssetParam.getPermanentTime());
            }

            // 根据资产状态（0  正常，1  报修，2  报失，3  报废，6, 报废待处理 8 报废已处理） 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getStatus())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getStatus, arvResidualValueAssetParam.getStatus());
            }

            // 根据资产追踪创建时间 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getTrackCodeCreateTime())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getTrackCodeCreateTime, arvResidualValueAssetParam.getTrackCodeCreateTime());
            }

            // 根据标记 0.普通 1 测试用虚拟设备 2 工厂老化测试用设备 3 测试用实体机 4 赠品（对外） 5 赠品（内部福利） 6 第三方测试用 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getFakeTag())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getFakeTag, arvResidualValueAssetParam.getFakeTag());
            }


            // 根据货主类型 （0 默认 1 直营 2 服务商 3 代理 4 用户 5 运营商） 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getLegalType())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getLegalType, arvResidualValueAssetParam.getLegalType());
            }


            // 根据资产第一次绑定门店时间 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getFirstBindShopTime())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getFirstBindShopTime, arvResidualValueAssetParam.getFirstBindShopTime());
            }

            // 根据ARV资产财务状态 0.正常  1.报修  2.报失  6.报废待处理 8.报废已处理  99.未知 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getAssetFinancialStatus())) {
                queryWrapper.lambda().like(ArvResidualValueAsset::getAssetFinancialStatus, arvResidualValueAssetParam.getAssetFinancialStatus());
            }

        }
        return new PageResult<>(this.page(PageFactory.defaultPage(), queryWrapper));
    }

    @Override
    public List<ArvResidualValueAsset> list(ArvResidualValueAssetParam arvResidualValueAssetParam) {
        LambdaQueryWrapper<ArvResidualValueAsset> queryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtil.isNotNull(arvResidualValueAssetParam)) {


            // 根据资产追踪码 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getAssetTrackCode())) {
                queryWrapper.like(ArvResidualValueAsset::getAssetTrackCode, arvResidualValueAssetParam.getAssetTrackCode());
            }

            // 根据设备类型(0 无 1 桌面机 2 柜机 3 移动充电宝 4 充电线 5 无线辅助通讯设备) 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getDeviceType())) {
                queryWrapper.like(ArvResidualValueAsset::getDeviceType, arvResidualValueAssetParam.getDeviceType());
            }

            // 根据资产业务属性（0  无  1.  直营  2.代理  3  服务商） 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getBusinessType())) {
                queryWrapper.like(ArvResidualValueAsset::getBusinessType, arvResidualValueAssetParam.getBusinessType());
            }

            // 根据资产唯一码 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getAssetItemNo())) {
                queryWrapper.like(ArvResidualValueAsset::getAssetItemNo, arvResidualValueAssetParam.getAssetItemNo());
            }

            // 根据资产类别编码 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getAssetCategoryCode())) {
                queryWrapper.like(ArvResidualValueAsset::getAssetCategoryCode, arvResidualValueAssetParam.getAssetCategoryCode());
            }

            // 根据类型编码 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getAssetTypeCode())) {
                queryWrapper.like(ArvResidualValueAsset::getAssetTypeCode, arvResidualValueAssetParam.getAssetTypeCode());
            }

            // 根据mac 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getMacCode())) {
                queryWrapper.like(ArvResidualValueAsset::getMacCode, arvResidualValueAssetParam.getMacCode());
            }


            // 根据sn 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getSnCode())) {
                queryWrapper.like(ArvResidualValueAsset::getSnCode, arvResidualValueAssetParam.getSnCode());
            }

            // 根据资产财务属性（0 固定资产 1 存货 2 售出品 3 虚拟测试 4 实体测试 5 赠品 ） 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getAssetFinancialAttribute())) {
                queryWrapper.like(ArvResidualValueAsset::getAssetFinancialAttribute, arvResidualValueAssetParam.getAssetFinancialAttribute());
            }

            // 根据固定资产时间 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getPermanentTime())) {
                queryWrapper.like(ArvResidualValueAsset::getPermanentTime, arvResidualValueAssetParam.getPermanentTime());
            }

            // 根据资产状态（0  正常，1  报修，2  报失，3  报废，6, 报废待处理 8 报废已处理） 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getStatus())) {
                queryWrapper.like(ArvResidualValueAsset::getStatus, arvResidualValueAssetParam.getStatus());
            }

            // 根据资产追踪创建时间 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getTrackCodeCreateTime())) {
                queryWrapper.like(ArvResidualValueAsset::getTrackCodeCreateTime, arvResidualValueAssetParam.getTrackCodeCreateTime());
            }

            // 根据标记 0.普通 1 测试用虚拟设备 2 工厂老化测试用设备 3 测试用实体机 4 赠品（对外） 5 赠品（内部福利） 6 第三方测试用 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getFakeTag())) {
                queryWrapper.like(ArvResidualValueAsset::getFakeTag, arvResidualValueAssetParam.getFakeTag());
            }

            // 根据货主类型 （0 默认 1 直营 2 服务商 3 代理 4 用户 5 运营商） 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getLegalType())) {
                queryWrapper.like(ArvResidualValueAsset::getLegalType, arvResidualValueAssetParam.getLegalType());
            }


            // 根据资产第一次绑定门店时间 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getFirstBindShopTime())) {
                queryWrapper.like(ArvResidualValueAsset::getFirstBindShopTime, arvResidualValueAssetParam.getFirstBindShopTime());
            }


            // 根据ARV资产财务状态 0.正常  1.报修  2.报失  6.报废待处理 8.报废已处理  99.未知 模糊查询
            if (ObjectUtil.isNotEmpty(arvResidualValueAssetParam.getAssetFinancialStatus())) {
                queryWrapper.like(ArvResidualValueAsset::getAssetFinancialStatus, arvResidualValueAssetParam.getAssetFinancialStatus());
            }


        }
        return this.list(queryWrapper);
    }

    @Override
    public void add(ArvResidualValueAssetParam arvResidualValueAssetParam) {
        ArvResidualValueAsset arvResidualValueAsset = new ArvResidualValueAsset();
        BeanUtil.copyProperties(arvResidualValueAssetParam, arvResidualValueAsset);
        this.save(arvResidualValueAsset);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(ArvResidualValueAssetParam arvResidualValueAssetParam) {
            this.removeById(arvResidualValueAssetParam.getId());
                                                                                                                }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(ArvResidualValueAssetParam arvResidualValueAssetParam) {
        ArvResidualValueAsset arvResidualValueAsset = this.queryArvResidualValueAsset(arvResidualValueAssetParam);
        BeanUtil.copyProperties(arvResidualValueAssetParam, arvResidualValueAsset);
        this.updateById(arvResidualValueAsset);
    }

    @Override
    public ArvResidualValueAsset detail(ArvResidualValueAssetParam arvResidualValueAssetParam) {
        return this.queryArvResidualValueAsset(arvResidualValueAssetParam);
    }

    /**
     * 获取资产残值表
     *
     * @author hudong
     * @date 2021-01-19 11:13:43
     */
    private ArvResidualValueAsset queryArvResidualValueAsset(ArvResidualValueAssetParam arvResidualValueAssetParam) {
        ArvResidualValueAsset arvResidualValueAsset = this.getById(arvResidualValueAssetParam.getId());
        if (ObjectUtil.isNull(arvResidualValueAsset)) {
            throw new ServiceException(ArvResidualValueAssetExceptionEnum.NOT_EXIST);
        }
        return arvResidualValueAsset;
    }
}
