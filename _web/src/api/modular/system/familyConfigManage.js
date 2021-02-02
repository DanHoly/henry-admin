import { axios } from '@/utils/request'

/**
 * 查询家庭初始配置表
 *
 * @author henry
 * @date 2021-01-25 20:00:45
 */
export function familyConfigPage (parameter) {
  return axios({
    url: '/familyConfig/page',
    method: 'get',
    params: parameter
  })
}

/**
 * 家庭初始配置表列表
 *
 * @author henry
 * @date 2021-01-25 20:00:45
 */
export function familyConfigList (parameter) {
  return axios({
    url: '/familyConfig/list',
    method: 'get',
    params: parameter
  })
}

/**
 * 添加家庭初始配置表
 *
 * @author henry
 * @date 2021-01-25 20:00:45
 */
export function familyConfigAdd (parameter) {
  return axios({
    url: '/familyConfig/add',
    method: 'post',
    data: parameter
  })
}

/**
 * 编辑家庭初始配置表
 *
 * @author henry
 * @date 2021-01-25 20:00:45
 */
export function familyConfigEdit (parameter) {
  return axios({
    url: '/familyConfig/edit',
    method: 'post',
    data: parameter
  })
}

/**
 * 删除家庭初始配置表
 *
 * @author henry
 * @date 2021-01-25 20:00:45
 */
export function familyConfigDelete (parameter) {
  return axios({
    url: '/familyConfig/delete',
    method: 'post',
    data: parameter
  })
}
