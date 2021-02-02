import { axios } from '@/utils/request'

/**
 * 查询资产残值表
 *
 * @author hudong
 * @date 2021-01-19 11:13:43
 */
export function arvResidualValueAssetPage (parameter) {
  return axios({
    url: '/arvResidualValueAsset/page',
    method: 'get',
    params: parameter
  })
}

/**
 * 资产残值表列表
 *
 * @author hudong
 * @date 2021-01-19 11:13:43
 */
export function arvResidualValueAssetList (parameter) {
  return axios({
    url: '/arvResidualValueAsset/list',
    method: 'get',
    params: parameter
  })
}

/**
 * 添加资产残值表
 *
 * @author hudong
 * @date 2021-01-19 11:13:43
 */
export function arvResidualValueAssetAdd (parameter) {
  return axios({
    url: '/arvResidualValueAsset/add',
    method: 'post',
    data: parameter
  })
}

/**
 * 编辑资产残值表
 *
 * @author hudong
 * @date 2021-01-19 11:13:43
 */
export function arvResidualValueAssetEdit (parameter) {
  return axios({
    url: '/arvResidualValueAsset/edit',
    method: 'post',
    data: parameter
  })
}

/**
 * 删除资产残值表
 *
 * @author hudong
 * @date 2021-01-19 11:13:43
 */
export function arvResidualValueAssetDelete (parameter) {
  return axios({
    url: '/arvResidualValueAsset/delete',
    method: 'post',
    data: parameter
  })
}
