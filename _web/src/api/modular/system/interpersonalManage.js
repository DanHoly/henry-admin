import { axios } from '@/utils/request'

/**
 * 查询人情来往表
 *
 * @author henry
 * @date 2021-01-27 17:16:36
 */
export function interpersonalPage (parameter) {
  return axios({
    url: '/interpersonal/page',
    method: 'get',
    params: parameter
  })
}

/**
 * 人情来往表列表
 *
 * @author henry
 * @date 2021-01-27 17:16:36
 */
export function interpersonalList (parameter) {
  return axios({
    url: '/interpersonal/list',
    method: 'get',
    params: parameter
  })
}

/**
 * 添加人情来往表
 *
 * @author henry
 * @date 2021-01-27 17:16:36
 */
export function interpersonalAdd (parameter) {
  return axios({
    url: '/interpersonal/add',
    method: 'post',
    data: parameter
  })
}

/**
 * 编辑人情来往表
 *
 * @author henry
 * @date 2021-01-27 17:16:36
 */
export function interpersonalEdit (parameter) {
  return axios({
    url: '/interpersonal/edit',
    method: 'post',
    data: parameter
  })
}

/**
 * 删除人情来往表
 *
 * @author henry
 * @date 2021-01-27 17:16:36
 */
export function interpersonalDelete (parameter) {
  return axios({
    url: '/interpersonal/delete',
    method: 'post',
    data: parameter
  })
}
