<template>
  <a-modal
    title="编辑人情来往表"
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
          label="用户id"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入用户id" v-decorator="['userId', {rules: [{required: true, message: '请输入用户id！'}]}]" />
        </a-form-item>
        <a-form-item
          label="家庭id"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入家庭id" v-decorator="['familyId', {rules: [{required: true, message: '请输入家庭id！'}]}]" />
        </a-form-item>
        <a-form-item
          label="对方姓名"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入对方姓名" v-decorator="['name', {rules: [{required: true, message: '请输入对方姓名！'}]}]" />
        </a-form-item>
        <a-form-item
          label="金额"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入金额" v-decorator="['money', {rules: [{required: true, message: '请输入金额！'}]}]" />
        </a-form-item>
        <a-form-item
          label="本人亲到"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入本人亲到,是Y,否N" v-decorator="['isSelf', {rules: [{required: true, message: '请输入本人亲到,是Y,否N！'}]}]" />
        </a-form-item>
        <a-form-item
          label="送礼日期"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入送礼日期" v-decorator="['giftDate', {rules: [{required: true, message: '请输入送礼日期！'}]}]" />
        </a-form-item>
        <a-form-item
          label="送礼原因"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入送礼原因" v-decorator="['giftReason', {rules: [{required: true, message: '请输入送礼原因！'}]}]" />
        </a-form-item>
        <a-form-item
          label="送礼类型"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入送礼类型,送礼1,收礼2" v-decorator="['giftType', {rules: [{required: true, message: '请输入送礼类型,送礼1,收礼2！'}]}]" />
        </a-form-item>
        <a-form-item
          label="备注"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入备注" v-decorator="['remark', {rules: [{required: true, message: '请输入！'}]}]" />
        </a-form-item>
        <a-form-item
          label="是否有效"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入是否有效" v-decorator="['state', {rules: [{required: true, message: '请输入！'}]}]" />
        </a-form-item>
      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>
  import { interpersonalEdit } from '@/api/modular/system/interpersonalManage'
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
              userId: record.userId,
              familyId: record.familyId,
              name: record.name,
              money: record.money,
              isSelf: record.isSelf,
              giftDate: record.giftDate,
              giftReason: record.giftReason,
              giftType: record.giftType,
              remark: record.remark,
              state: record.state,
              ext1: record.ext1
            }
          )
        }, 100)
      },
      handleSubmit () {
        const { form: { validateFields } } = this
        this.confirmLoading = true
        validateFields((errors, values) => {
          if (!errors) {
              interpersonalEdit(values).then((res) => {
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
