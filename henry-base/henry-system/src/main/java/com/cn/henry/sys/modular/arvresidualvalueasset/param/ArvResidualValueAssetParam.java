
package com.cn.henry.sys.modular.arvresidualvalueasset.param;

import com.cn.henry.core.pojo.base.param.BaseParam;
import lombok.Data;
import java.util.*;

/**
* 资产残值表参数类
 *
 * @author hudong
 * @date 2021-01-19 11:13:43
*/
@Data
public class ArvResidualValueAssetParam extends BaseParam {

    /**
     * id
     */
    private Long id;

    /**
     * 资产追踪码
     */
    private String assetTrackCode;


    /**
     * 设备类型(0 无 1 桌面机 2 柜机 3 移动充电宝 4 充电线 5 无线辅助通讯设备)
     */
    private Integer deviceType;


    /**
     * 资产业务属性（0  无  1.  直营  2.代理  3  服务商）
     */
    private Integer businessType;


    /**
     * 资产唯一码
     */
    private String assetItemNo;


    /**
     * 资产类别编码
     */
    private String assetCategoryCode;


    /**
     * 类型编码
     */
    private String assetTypeCode;


    /**
     * mac
     */
    private String macCode;


    /**
     * sn
     */
    private String snCode;


    /**
     * 资产财务属性（0 固定资产 1 存货 2 售出品 3 虚拟测试 4 实体测试 5 赠品 ）
     */
    private Integer assetFinancialAttribute;


    /**
     * 固定资产时间
     */
    private Date permanentTime;


    /**
     * 资产状态（0  正常，1  报修，2  报失，3  报废，6, 报废待处理 8 报废已处理）
     */
    private Integer status;


    /**
     * 资产追踪创建时间
     */
    private Date trackCodeCreateTime;


    /**
     * 标记 0.普通 1 测试用虚拟设备 2 工厂老化测试用设备 3 测试用实体机 4 赠品（对外） 5 赠品（内部福利） 6 第三方测试用
     */
    private Integer fakeTag;


    /**
     * 货主类型 （0 默认 1 直营 2 服务商 3 代理 4 用户 5 运营商）
     */
    private Integer legalType;



    /**
     * 资产第一次绑定门店时间
     */
    private Date firstBindShopTime;


    /**
     * ARV资产财务状态 0.正常  1.报修  2.报失  6.报废待处理 8.报废已处理  99.未知
     */
    private Integer assetFinancialStatus;

}
