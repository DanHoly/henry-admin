<template>
  <a-card :bordered="false">
    <div class="table-page-search-wrapper" v-if="hasPerm('debt:page')">
      <a-form layout="inline">
        <a-row :gutter="48">
          <a-col :md="8" :sm="24">
            <a-form-item label="用户id" >
              <a-input v-model="queryParam.userId" allow-clear placeholder="请输入用户id"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="家庭id" >
              <a-input v-model="queryParam.familyId" allow-clear placeholder="请输入家庭id"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="债务类型" >
              <a-input v-model="queryParam.debtType" allow-clear placeholder="请输入债务类型"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="金额" >
              <a-input v-model="queryParam.money" allow-clear placeholder="请输入金额"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="债务记录日期" >
              <a-input v-model="queryParam.debtDate" allow-clear placeholder="请输入债务记录日期"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="对方姓名" >
              <a-input v-model="queryParam.name" allow-clear placeholder="请输入对方姓名"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="约定归还日期" >
              <a-input v-model="queryParam.refundDate" allow-clear placeholder="请输入约定归还日期"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="是否归还" >
              <a-input v-model="queryParam.isRefund" allow-clear placeholder="请输入是否归还,N否,Y是"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="债务原因" >
              <a-input v-model="queryParam.debtReason" allow-clear placeholder="请输入债务原因"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="证据截图" >
              <a-input v-model="queryParam.debtImg" allow-clear placeholder="请输入证据截图"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="身份证号" >
              <a-input v-model="queryParam.cardid" allow-clear placeholder="请输入身份证号"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="电话号码" >
              <a-input v-model="queryParam.phone" allow-clear placeholder="请输入电话号码"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="家庭地址" >
              <a-input v-model="queryParam.familyAddress" allow-clear placeholder="请输入家庭地址"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="备注" >
              <a-input v-model="queryParam.remark" allow-clear placeholder="请输入备注"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="是否有效" >
              <a-input v-model="queryParam.state" allow-clear placeholder="请输入是否有效"/>
            </a-form-item>
          </a-col>
          <a-col :md="!advanced && 8 || 24" :sm="24">
            <span class="table-page-search-submitButtons" :style="advanced && { float: 'right', overflow: 'hidden' } || {} ">
              <a-button type="primary" @click="$refs.table.refresh(true)">查询</a-button>
              <a-button style="margin-left: 8px" @click="() => queryParam = {}">重置</a-button>
            </span>
          </a-col>
        </a-row>
      </a-form>
    </div>
    <div class="table-operator" v-if="hasPerm('debt:add')" >
      <a-button type="primary" v-if="hasPerm('debt:add')" icon="plus" @click="$refs.addForm.add()">新增债务表</a-button>
    </div>
    <s-table
      ref="table"
      size="default"
      :columns="columns"
      :data="loadData"
      :alert="true"
      :rowKey="(record) => record.id"
      :rowSelection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
    >
      <span slot="action" slot-scope="text, record">
        <a v-if="hasPerm('debt:edit')" @click="$refs.editForm.edit(record)">编辑</a>
        <a-divider type="vertical" v-if="hasPerm('debt:edit') & hasPerm('debt:delete')"/>
        <a-popconfirm v-if="hasPerm('debt:delete')" placement="topRight" title="确认删除？" @confirm="() => debtDelete(record)">
          <a>删除</a>
        </a-popconfirm>
      </span>
    </s-table>
    <add-form ref="addForm" @ok="handleOk" />
    <edit-form ref="editForm" @ok="handleOk" />
  </a-card>
</template>
<script>
  import { STable } from '@/components'
  import { debtPage, debtDelete } from '@/api/modular/system/debtManage'
  import addForm from './addForm.vue'
  import editForm from './editForm.vue'
  export default {
    components: {
      STable,
      addForm,
      editForm
    },
    data () {
      return {
        // 高级搜索 展开/关闭
        advanced: false,
        // 查询参数
        queryParam: {},
        // 表头
        columns: [
            {
              title: '用户id',
              dataIndex: 'userId'
            },
            {
              title: '家庭id',
              dataIndex: 'familyId'
            },
            {
              title: '债务类型欠债1,借出2',
              dataIndex: 'debtType'
            },
            {
              title: '金额',
              dataIndex: 'money'
            },
            {
              title: '债务记录日期',
              dataIndex: 'debtDate'
            },
            {
              title: '对方姓名',
              dataIndex: 'name'
            },
            {
              title: '约定归还日期',
              dataIndex: 'refundDate'
            },
            {
              title: '是否归还',
              dataIndex: 'isRefund'
            },
            {
              title: '债务原因',
              dataIndex: 'debtReason'
            },
            {
              title: '证据截图',
              dataIndex: 'debtImg'
            },
            {
              title: '身份证号',
              dataIndex: 'cardid'
            },
            {
              title: '电话号码',
              dataIndex: 'phone'
            },
            {
              title: '家庭地址',
              dataIndex: 'familyAddress'
            },
            {
              title: '备注',
              dataIndex: 'remark'
            },
            {
              title: '是否有效',
              dataIndex: 'state'
            }
        ],
        // 加载数据方法 必须为 Promise 对象
        loadData: parameter => {
          return debtPage(Object.assign(parameter, this.queryParam)).then((res) => {
            return res.data
          })
        },
        selectedRowKeys: [],
        selectedRows: []
    }
    },
    created () {
      if (this.hasPerm('debt:edit') || this.hasPerm('debt:delete')) {
        this.columns.push({
          title: '操作',
          width: '150px',
          dataIndex: 'action',
          scopedSlots: { customRender: 'action' }
        })
      }
    },
    methods: {
        debtDelete (record) {
          debtDelete(record).then((res) => {
          if (res.success) {
            this.$message.success('删除成功')
            this.$refs.table.refresh()
          } else {
            this.$message.error('删除失败') // + res.message
          }
        })
      },
      toggleAdvanced () {
        this.advanced = !this.advanced
      },
      handleOk () {
        this.$refs.table.refresh()
      },
      onSelectChange (selectedRowKeys, selectedRows) {
        this.selectedRowKeys = selectedRowKeys
        this.selectedRows = selectedRows
      }
    }
  }
</script>
<style lang="less">
  .table-operator {
    margin-bottom: 18px;
  }
  button {
    margin-right: 8px;
  }
</style>
