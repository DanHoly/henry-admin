import { axios } from '@/utils/request'

/**
 * 查询债务表
 *
 * @author henry
 * @date 2021-01-26 15:41:18
 */
export function debtPage (parameter) {
  return axios({
    url: '/debt/page',
    method: 'get',
    params: parameter
  })
}

/**
 * 债务表列表
 *
 * @author henry
 * @date 2021-01-26 15:41:18
 */
export function debtList (parameter) {
  return axios({
    url: '/debt/list',
    method: 'get',
    params: parameter
  })
}

/**
 * 添加债务表
 *
 * @author henry
 * @date 2021-01-26 15:41:18
 */
export function debtAdd (parameter) {
  return axios({
    url: '/debt/add',
    method: 'post',
    data: parameter
  })
}

/**
 * 编辑债务表
 *
 * @author henry
 * @date 2021-01-26 15:41:18
 */
export function debtEdit (parameter) {
  return axios({
    url: '/debt/edit',
    method: 'post',
    data: parameter
  })
}

/**
 * 删除债务表
 *
 * @author henry
 * @date 2021-01-26 15:41:18
 */
export function debtDelete (parameter) {
  return axios({
    url: '/debt/delete',
    method: 'post',
    data: parameter
  })
}
