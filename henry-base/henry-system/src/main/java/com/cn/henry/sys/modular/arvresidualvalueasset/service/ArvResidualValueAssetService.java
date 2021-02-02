
package com.cn.henry.sys.modular.arvresidualvalueasset.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.henry.core.pojo.page.PageResult;
import com.cn.henry.sys.modular.arvresidualvalueasset.entity.ArvResidualValueAsset;
import com.cn.henry.sys.modular.arvresidualvalueasset.param.ArvResidualValueAssetParam;


import java.util.List;

/**
 * 资产残值表service接口
 *
 * @author hudong
 * @date 2021-01-19 11:13:43
 */
public interface ArvResidualValueAssetService extends IService<ArvResidualValueAsset> {

    /**
     * 查询资产残值表
     *
     * @author hudong
     * @date 2021-01-19 11:13:43
     */
    PageResult<ArvResidualValueAsset> page(ArvResidualValueAssetParam arvResidualValueAssetParam);

    /**
     * 资产残值表列表
     *
     * @author hudong
     * @date 2021-01-19 11:13:43
     */
    List<ArvResidualValueAsset> list(ArvResidualValueAssetParam arvResidualValueAssetParam);

    /**
     * 添加资产残值表
     *
     * @author hudong
     * @date 2021-01-19 11:13:43
     */
    void add(ArvResidualValueAssetParam arvResidualValueAssetParam);

    /**
     * 删除资产残值表
     *
     * @author hudong
     * @date 2021-01-19 11:13:43
     */
    void delete(ArvResidualValueAssetParam arvResidualValueAssetParam);

    /**
     * 编辑资产残值表
     *
     * @author hudong
     * @date 2021-01-19 11:13:43
     */
    void edit(ArvResidualValueAssetParam arvResidualValueAssetParam);

    /**
     * 查看资产残值表
     *
     * @author hudong
     * @date 2021-01-19 11:13:43
     */
     ArvResidualValueAsset detail(ArvResidualValueAssetParam arvResidualValueAssetParam);
}
