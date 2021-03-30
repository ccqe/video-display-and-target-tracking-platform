import service from '@/axios/request'

export function getVideo(data){
    return service({
      url:'/api/video.action',
      method:'post',
      data: data
    })
}