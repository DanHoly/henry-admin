
package com.cn.henry.modular.controller;

import com.cn.henry.core.pojo.response.ResponseData;
import com.cn.henry.core.pojo.response.SuccessResponseData;
import com.cn.henry.modular.service.DatasourceExampleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 一个示例接口
 *
 * @author yubaoshan
 * @date 2020/4/9 18:09
 */
@RestController
@RequestMapping("/example")
public class DatasourceExampleController {

    @Resource
    private DatasourceExampleService datasourceService;

    @RequestMapping("/niceDay")
    public ResponseData niceDay() {
        return new SuccessResponseData("nice day");
    }

    @RequestMapping("/masterDatasource")
    public ResponseData masterDatasource() {
        return new SuccessResponseData(datasourceService.masterDatasource());
    }

    @RequestMapping("/backupDatasource")
    public ResponseData backupDatasource() {
        return new SuccessResponseData(datasourceService.backupDatasource());
    }

    @RequestMapping("/datasourceTransactionNone")
    public ResponseData datasourceTransactionNone() {
        datasourceService.datasourceTransactionNone();
        return new SuccessResponseData();
    }

    @RequestMapping("/datasourceTransaction")
    public ResponseData datasourceTransaction() {
        datasourceService.datasourceTransaction();
        return new SuccessResponseData();
    }

}
