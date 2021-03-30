import service from '@/axios/request'

export function getRtmp(){
    return service({
      url:'/api/rtmp.action',
      method:'get'
    })
}