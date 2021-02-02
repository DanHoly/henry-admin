<template>
  <a-card :bordered="false">
    <div class="table-page-search-wrapper" v-if="hasPerm('arvResidualValueAsset:page')">
      <a-form layout="inline">
        <a-row :gutter="48">
          <a-col :md="8" :sm="10">
            <a-form-item label="资产追踪码" >
              <a-input v-model="queryParam.assetTrackCode" allow-clear placeholder="请输入资产追踪码"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="设备类型" >
              <a-input v-model="queryParam.deviceType" allow-clear placeholder="请输入设备类型(0 无 1 桌面机 2 柜机 3 移动充电宝 4 充电线 5 无线辅助通讯设备)"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="资产业务属性" >
              <a-input v-model="queryParam.businessType" allow-clear placeholder="请输入资产业务属性（0  无  1.  直营  2.代理  3  服务商）"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="资产唯一码" >
              <a-input v-model="queryParam.assetItemNo" allow-clear placeholder="请输入资产唯一码"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="资产类别编码" >
              <a-input v-model="queryParam.assetCategoryCode" allow-clear placeholder="请输入资产类别编码"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="类型编码" >
              <a-input v-model="queryParam.assetTypeCode" allow-clear placeholder="请输入类型编码"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="mac" >
              <a-input v-model="queryParam.macCode" allow-clear placeholder="请输入mac"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="sn" >
              <a-input v-model="queryParam.snCode" allow-clear placeholder="请输入sn"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="资产财务属性" >
              <a-input v-model="queryParam.assetFinancialAttribute" allow-clear placeholder="请输入资产财务属性（0 固定资产 1 存货 2 售出品 3 虚拟测试 4 实体测试 5 赠品 ）"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="固定资产时间" >
              <a-input v-model="queryParam.permanentTime" allow-clear placeholder="请输入固定资产时间"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="资产状态" >
              <a-input v-model="queryParam.status" allow-clear placeholder="请输入资产状态（0  正常，1  报修，2  报失，3  报废，6, 报废待处理 8 报废已处理）"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="资产追踪创建时间" >
              <a-input v-model="queryParam.trackCodeCreateTime" allow-clear placeholder="请输入资产追踪创建时间"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="用途" >
              <a-input v-model="queryParam.fakeTag" allow-clear placeholder="请输入标记 0.普通 1 测试用虚拟设备 2 工厂老化测试用设备 3 测试用实体机 4 赠品（对外） 5 赠品（内部福利） 6 第三方测试用"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="货主类型" >
              <a-input v-model="queryParam.legalType" allow-clear placeholder="请输入货主类型 （0 默认 1 直营 2 服务商 3 代理 4 用户 5 运营商）"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="资产第一次绑定门店时间" >
              <a-input v-model="queryParam.firstBindShopTime" allow-clear placeholder="请输入资产第一次绑定门店时间"/>
            </a-form-item>
          </a-col>
          <a-col :md="8" :sm="10">
            <a-form-item label="ARV资产财务状态" >
              <a-input v-model="queryParam.assetFinancialStatus" allow-clear placeholder="请输入ARV资产财务状态 0.正常  1.报修  2.报失  6.报废待处理 8.报废已处理  99.未知"/>
            </a-form-item>
          </a-col>
          <a-col :md="!advanced && 8 || 10" :sm="10">
            <span class="table-page-search-submitButtons" :style="advanced && { float: 'right', overflow: 'hidden' } || {} ">
              <a-button type="primary" @click="$refs.table.refresh(true)">查询</a-button>
              <a-button style="margin-left: 5px" @click="() => queryParam = {}">重置</a-button>
            </span>
          </a-col>
        </a-row>
      </a-form>
    </div>
    <div class="table-operator" v-if="hasPerm('arvResidualValueAsset:add')" >
      <a-button type="primary" v-if="hasPerm('arvResidualValueAsset:add')" icon="plus" @click="$refs.addForm.add()">新增资产残值表</a-button>
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
        <a v-if="hasPerm('arvResidualValueAsset:edit')" @click="$refs.editForm.edit(record)">编辑</a>
        <a-divider type="vertical" v-if="hasPerm('arvResidualValueAsset:edit') & hasPerm('arvResidualValueAsset:delete')"/>
        <a-popconfirm v-if="hasPerm('arvResidualValueAsset:delete')" placement="topRight" title="确认删除？" @confirm="() => arvResidualValueAssetDelete(record)">
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
  import { arvResidualValueAssetPage, arvResidualValueAssetDelete } from '@/api/modular/system/arvResidualValueAssetManage'
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
              title: '资产追踪码',
              dataIndex: 'assetTrackCode'
            },
            {
              title: '设备类型',
              dataIndex: 'deviceType'
            },
            {
              title: '资产业务属性',
              dataIndex: 'businessType'
            },
            {
              title: '资产唯一码',
              dataIndex: 'assetItemNo'
            },
            {
              title: '资产类别编码',
              dataIndex: 'assetCategoryCode'
            },
            {
              title: '类型编码',
              dataIndex: 'assetTypeCode'
            },
            {
              title: 'mac',
              dataIndex: 'macCode'
            },
            {
              title: 'sn',
              dataIndex: 'snCode'
            },
            {
              title: '资产财务属性',
              dataIndex: 'assetFinancialAttribute'
            },
            {
              title: '固定资产时间',
              dataIndex: 'permanentTime'
            },
            {
              title: '资产状态',
              dataIndex: 'status'
            },
            {
              title: '资产追踪创建时间',
              dataIndex: 'trackCodeCreateTime'
            },
            {
              title: '用途',
              dataIndex: 'fakeTag'
            },
            {
              title: '货主类型',
              dataIndex: 'legalType'
            },
            {
              title: '资产第一次绑定门店时间',
              dataIndex: 'firstBindShopTime'
            },
            {
              title: 'ARV资产财务状态',
              dataIndex: 'assetFinancialStatus'
            }
        ],
        // 加载数据方法 必须为 Promise 对象
        loadData: parameter => {
          return arvResidualValueAssetPage(Object.assign(parameter, this.queryParam)).then((res) => {
            return res.data
          })
        },
        selectedRowKeys: [],
        selectedRows: []
    }
    },
    created () {
      if (this.hasPerm('arvResidualValueAsset:edit') || this.hasPerm('arvResidualValueAsset:delete')) {
        this.columns.push({
          title: '操作',
          width: '150px',
          dataIndex: 'action',
          scopedSlots: { customRender: 'action' }
        })
      }
    },
    methods: {
        arvResidualValueAssetDelete (record) {
          arvResidualValueAssetDelete(record).then((res) => {
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
    margin-bottom: 10px;
  }
  button {
    margin-right: 8px;
  }
</style>
