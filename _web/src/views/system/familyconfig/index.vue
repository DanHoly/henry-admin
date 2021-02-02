<template>
  <a-card :bordered="false">
    <div class="table-page-search-wrapper" v-if="hasPerm('familyConfig:page')">
      <a-form layout="inline">
        <a-row :gutter="48">
          <a-col :md="8" :sm="24">
            <a-form-item label="家庭名称" >
              <a-input v-model="queryParam.name" allow-clear placeholder="请输入家庭名称"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="初始总资产" >
              <a-input v-model="queryParam.initMoney" allow-clear placeholder="请输入初始总资产"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="负债" >
              <a-input v-model="queryParam.debt" allow-clear placeholder="请输入负债"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="存款" >
              <a-input v-model="queryParam.deposit" allow-clear placeholder="请输入存款"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="资产状态" >
              <a-input v-model="queryParam.state" allow-clear placeholder="请输入资产状态"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="24">
            <a-form-item label="备注" >
              <a-input v-model="queryParam.remark" allow-clear placeholder="请输入备注"/>
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
    <div class="table-operator" v-if="hasPerm('familyConfig:add')" >
      <a-button type="primary" v-if="hasPerm('familyConfig:add')" icon="plus" @click="$refs.addForm.add()">新增家庭初始配置表</a-button>
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
        <a v-if="hasPerm('familyConfig:edit')" @click="$refs.editForm.edit(record)">编辑</a>
        <a-divider type="vertical" v-if="hasPerm('familyConfig:edit') & hasPerm('familyConfig:delete')"/>
        <a-popconfirm v-if="hasPerm('familyConfig:delete')" placement="topRight" title="确认删除？" @confirm="() => familyConfigDelete(record)">
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
  import { familyConfigPage, familyConfigDelete } from '@/api/modular/system/familyConfigManage'
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
              title: '家庭名称',
              dataIndex: 'name'
            },
            {
              title: '初始总资产',
              dataIndex: 'initMoney'
            },
            {
              title: '负债',
              dataIndex: 'debt'
            },
            {
              title: '存款',
              dataIndex: 'deposit'
            },
            {
              title: '资产状态',
              dataIndex: 'state'
            },
            {
              title: '备注',
              dataIndex: 'remark'
            }
        ],
        // 加载数据方法 必须为 Promise 对象
        loadData: parameter => {
          return familyConfigPage(Object.assign(parameter, this.queryParam)).then((res) => {
            return res.data
          })
        },
        selectedRowKeys: [],
        selectedRows: []
    }
    },
    created () {
      if (this.hasPerm('familyConfig:edit') || this.hasPerm('familyConfig:delete')) {
        this.columns.push({
          title: '操作',
          width: '150px',
          dataIndex: 'action',
          scopedSlots: { customRender: 'action' }
        })
      }
    },
    methods: {
        familyConfigDelete (record) {
          familyConfigDelete(record).then((res) => {
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
