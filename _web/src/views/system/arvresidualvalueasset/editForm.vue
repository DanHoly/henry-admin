<template>
  <a-modal
    title="编辑资产残值表"
    :width="900"
    :visible="visible"
    :confirmLoading="confirmLoading"
    @ok="handleSubmit"
    @cancel="handleCancel"
  >
    <a-spin :spinning="confirmLoading">
      <a-form :form="form">
        <a-form-item v-show="false">
          <a-input v-decorator="['id']" />
        </a-form-item>
        <a-form-item
          label="资产追踪码"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入资产追踪码" v-decorator="['assetTrackCode', {rules: [{required: true, message: '请输入资产追踪码！'}]}]" />
        </a-form-item>
        <a-form-item
          label="设备类型"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入设备类型" v-decorator="['deviceType', {rules: [{required: true, message: '请输入设备类型(0 无 1 桌面机 2 柜机 3 移动充电宝 4 充电线 5 无线辅助通讯设备)！'}]}]" />
        </a-form-item>
        <a-form-item
          label="资产业务属性"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入资产业务属性" v-decorator="['businessType', {rules: [{required: true, message: '请输入资产业务属性（0  无  1.  直营  2.代理  3  服务商）！'}]}]" />
        </a-form-item>
        <a-form-item
          label="资产唯一码"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入资产唯一码" v-decorator="['assetItemNo', {rules: [{required: true, message: '请输入资产唯一码！'}]}]" />
        </a-form-item>
        <a-form-item
          label="资产类别编码"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入资产类别编码" v-decorator="['assetCategoryCode', {rules: [{required: true, message: '请输入资产类别编码！'}]}]" />
        </a-form-item>
        <a-form-item
          label="类型编码"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入类型编码" v-decorator="['assetTypeCode', {rules: [{required: true, message: '请输入类型编码！'}]}]" />
        </a-form-item>
        <a-form-item
          label="mac"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入mac" v-decorator="['macCode', {rules: [{required: true, message: '请输入mac！'}]}]" />
        </a-form-item>
        <a-form-item
          label="设备唯一识别码"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入设备唯一识别码" v-decorator="['uniqueCode', {rules: [{required: true, message: '请输入设备唯一识别码！'}]}]" />
        </a-form-item>
        <a-form-item
          label="sn"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入sn" v-decorator="['snCode', {rules: [{required: true, message: '请输入sn！'}]}]" />
        </a-form-item>
        <a-form-item
          label="资产财务属性"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入资产财务属性" v-decorator="['assetFinancialAttribute', {rules: [{required: true, message: '请输入资产财务属性（0 固定资产 1 存货 2 售出品 3 虚拟测试 4 实体测试 5 赠品 ）！'}]}]" />
        </a-form-item>
        <a-form-item
          label="固定资产时间"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入固定资产时间" v-decorator="['permanentTime', {rules: [{required: true, message: '请输入固定资产时间！'}]}]" />
        </a-form-item>
        <a-form-item
          label="资产状态"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入资产状态" v-decorator="['status', {rules: [{required: true, message: '请输入资产状态（0  正常，1  报修，2  报失，3  报废，6, 报废待处理 8 报废已处理）！'}]}]" />
        </a-form-item>
        <a-form-item
          label="资产追踪创建时间"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入资产追踪创建时间" v-decorator="['trackCodeCreateTime', {rules: [{required: true, message: '请输入资产追踪创建时间！'}]}]" />
        </a-form-item>
        <a-form-item
          label="用途"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入用途" v-decorator="['fakeTag', {rules: [{required: true, message: '请输入标记 0.普通 1 测试用虚拟设备 2 工厂老化测试用设备 3 测试用实体机 4 赠品（对外） 5 赠品（内部福利） 6 第三方测试用！'}]}]" />
        </a-form-item>
        <a-form-item
          label="货主id"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入货主id" v-decorator="['legalId', {rules: [{required: true, message: '请输入货主id！'}]}]" />
        </a-form-item>
        <a-form-item
          label="货主名称"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入货主名称" v-decorator="['legalName', {rules: [{required: true, message: '请输入货主名称！'}]}]" />
        </a-form-item>
        <a-form-item
          label="货主类型"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入货主类型" v-decorator="['legalType', {rules: [{required: true, message: '请输入货主类型 （0 默认 1 直营 2 服务商 3 代理 4 用户 5 运营商）！'}]}]" />
        </a-form-item>
        <a-form-item
          label="货主"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入货主" v-decorator="['legal', {rules: [{required: true, message: '请输入货主！'}]}]" />
        </a-form-item>
        <a-form-item
          label="原始货主"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入原始货主" v-decorator="['originalLegal', {rules: [{required: true, message: '请输入原始货主！'}]}]" />
        </a-form-item>
        <a-form-item
          label="资产第一次绑定门店时间"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入资产第一次绑定门店时间" v-decorator="['firstBindShopTime', {rules: [{required: true, message: '请输入资产第一次绑定门店时间！'}]}]" />
        </a-form-item>
        <a-form-item
          label="执行单号"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入执行单号" v-decorator="['processOrderNo', {rules: [{required: true, message: '请输入执行单号！'}]}]" />
        </a-form-item>
        <a-form-item
          label="代理商采购出货时间"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入代理商采购出货时间" v-decorator="['proxyStockOutTime', {rules: [{required: true, message: '请输入代理商采购出货时间！'}]}]" />
        </a-form-item>
        <a-form-item
          label="ARV资产财务状态"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入ARV资产财务状态" v-decorator="['assetFinancialStatus', {rules: [{required: true, message: '请输入ARV资产财务状态 0.正常  1.报修  2.报失  6.报废待处理 8.报废已处理  99.未知！'}]}]" />
        </a-form-item>
        <a-form-item
          label="0.未删除，1.已删除"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入0.未删除，1.已删除" v-decorator="['isDeleted', {rules: [{required: true, message: '请输入0.未删除，1.已删除！'}]}]" />
        </a-form-item>
        <a-form-item
          label="创建时间"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入创建时间" v-decorator="['gmtCreate', {rules: [{required: true, message: '请输入创建时间！'}]}]" />
        </a-form-item>
        <a-form-item
          label="修改时间"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入修改时间" v-decorator="['gmtModify', {rules: [{required: true, message: '请输入修改时间！'}]}]" />
        </a-form-item>

      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>
  import { arvResidualValueAssetEdit } from '@/api/modular/system/arvResidualValueAssetManage'
  export default {
    data () {
      return {
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 }
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 15 }
        },
        visible: false,
        confirmLoading: false,
        form: this.$form.createForm(this)
      }
    },
    methods: {
      // 初始化方法
      edit (record) {
        this.visible = true
        setTimeout(() => {
          this.form.setFieldsValue(
            {
              id: record.id,
              assetTrackCode: record.assetTrackCode,
              deviceType: record.deviceType,
              businessType: record.businessType,
              assetItemNo: record.assetItemNo,
              assetCategoryCode: record.assetCategoryCode,
              assetTypeCode: record.assetTypeCode,
              macCode: record.macCode,
              uniqueCode: record.uniqueCode,
              snCode: record.snCode,
              assetFinancialAttribute: record.assetFinancialAttribute,
              permanentTime: record.permanentTime,
              status: record.status,
              trackCodeCreateTime: record.trackCodeCreateTime,
              fakeTag: record.fakeTag,
              legalId: record.legalId,
              legalName: record.legalName,
              legalType: record.legalType,
              legal: record.legal,
              originalLegal: record.originalLegal,
              firstBindShopTime: record.firstBindShopTime,
              processOrderNo: record.processOrderNo,
              proxyStockOutTime: record.proxyStockOutTime,
              assetFinancialStatus: record.assetFinancialStatus,
              isDeleted: record.isDeleted,
              gmtCreate: record.gmtCreate,
              gmtModify: record.gmtModify
            }
          )
        }, 100)
      },
      handleSubmit () {
        const { form: { validateFields } } = this
        this.confirmLoading = true
        validateFields((errors, values) => {
          if (!errors) {
              arvResidualValueAssetEdit(values).then((res) => {
              if (res.success) {
                this.$message.success('编辑成功')
                this.confirmLoading = false
                this.$emit('ok', values)
                this.handleCancel()
              } else {
                this.$message.error('编辑失败')//  + res.message
              }
            }).finally((res) => {
              this.confirmLoading = false
            })
          } else {
            this.confirmLoading = false
          }
        })
      },
      handleCancel () {
        this.form.resetFields()
        this.visible = false
      }
    }
  }
</script>
