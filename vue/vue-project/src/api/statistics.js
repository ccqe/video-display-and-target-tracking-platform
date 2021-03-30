import service from '@/axios/request'

export function getData(data){
    return service({
      url:'/api/data.action',
      method:'post',
      data:data
    })
}