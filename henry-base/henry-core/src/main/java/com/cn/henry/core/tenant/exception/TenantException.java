package com.cn.henry.core.tenant.exception;

import com.cn.henry.core.exception.enums.abs.AbstractBaseExceptionEnum;
import com.cn.henry.core.exception.ServiceException;

/**
 * 多租户的异常
 *
 * @author xuyuxiang
 * @date 2020/9/3
 */
public class TenantException extends ServiceException {

    public TenantException(AbstractBaseExceptionEnum exception) {
        super(exception);
    }

}
