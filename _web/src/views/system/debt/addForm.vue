<template>
  <a-modal
    title="新增债务表"
    :width="900"
    :visible="visible"
    :confirmLoading="confirmLoading"
    @ok="handleSubmit"
    @cancel="handleCancel"
  >
    <a-spin :spinning="confirmLoading">
      <a-form :form="form">
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
          label="债务类型欠债1,借出2"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入债务类型" v-decorator="['debtType', {rules: [{required: true, message: '请输入债务类型'}]}]" />
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
          label="债务记录日期"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入债务记录日期" v-decorator="['debtDate', {rules: [{required: true, message: '请输入债务记录日期！'}]}]" />
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
          label="约定归还日期"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入约定归还日期" v-decorator="['refundDate', {rules: [{required: true, message: '请输入约定归还日期！'}]}]" />
        </a-form-item>
        <a-form-item
          label="是否归还"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入是否归还" v-decorator="['isRefund', {rules: [{required: true, message: '请输入是否归还,N否,Y是！'}]}]" />
        </a-form-item>
        <a-form-item
          label="债务原因"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入债务原因" v-decorator="['debtReason', {rules: [{required: true, message: '请输入债务原因！'}]}]" />
        </a-form-item>
        <a-form-item
          label="证据截图"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入证据截图" v-decorator="['debtImg', {rules: [{required: true, message: '请输入证据截图！'}]}]" />
        </a-form-item>
        <a-form-item
          label="身份证号"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入身份证号" v-decorator="['cardid', {rules: [{required: true, message: '请输入身份证号！'}]}]" />
        </a-form-item>
        <a-form-item
          label="电话号码"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入电话号码" v-decorator="['phone', {rules: [{required: true, message: '请输入电话号码！'}]}]" />
        </a-form-item>
        <a-form-item
          label="家庭地址"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入家庭地址" v-decorator="['familyAddress', {rules: [{required: true, message: '请输入家庭地址！'}]}]" />
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
  import { debtAdd } from '@/api/modular/system/debtManage'
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
      add (record) {
        this.visible = true
      },
      /**
       * 提交表单
       */
      handleSubmit () {
        const { form: { validateFields } } = this
        this.confirmLoading = true
        validateFields((errors, values) => {
          if (!errors) {
              debtAdd(values).then((res) => {
              if (res.success) {
                this.$message.success('新增成功')
                this.confirmLoading = false
                this.$emit('ok', values)
                this.handleCancel()
              } else {
                this.$message.error('新增失败')// + res.message
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
