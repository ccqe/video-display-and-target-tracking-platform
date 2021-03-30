import service from '@/axios/request'

export function getCamera(){
    return service({
      url:'/api/camera.action',
      method:'get'
    })
}