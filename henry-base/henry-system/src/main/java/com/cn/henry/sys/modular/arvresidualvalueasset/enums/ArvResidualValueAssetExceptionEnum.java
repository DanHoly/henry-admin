
package com.cn.henry.sys.modular.arvresidualvalueasset.enums;

import com.cn.henry.core.annotion.ExpEnumType;
import com.cn.henry.core.exception.enums.abs.AbstractBaseExceptionEnum;
import com.cn.henry.core.factory.ExpEnumCodeFactory;
import com.cn.henry.sys.core.consts.SysExpEnumConstant;

/**
 * 资产残值表
 *
 * @author hudong
 * @date 2021-01-19 11:13:43
 */
@ExpEnumType(module = SysExpEnumConstant.XIAONUO_SYS_MODULE_EXP_CODE, kind = SysExpEnumConstant.SYS_POS_EXCEPTION_ENUM)
public enum ArvResidualValueAssetExceptionEnum implements AbstractBaseExceptionEnum {

    /**
     * 数据不存在
     */
    NOT_EXIST(1, "此数据不存在");

    private final Integer code;

    private final String message;
        ArvResidualValueAssetExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return ExpEnumCodeFactory.getExpEnumCode(this.getClass(), code);
    }

    @Override
    public String getMessage() {
        return message;
    }

}
