import service from '@/axios/request'

export function getCameralist(data) {
    return service({
        url: '/api/cameralist.action',
        method: 'post',
        data:data
    })
}

export function deleteCamera(data) {
    return service({
        url: '/api/deletecamera.action',
        method: 'post',
        data:data
    })
}

export function updateCamera(data) {
    return service({
        url: '/api/updatecamera.action',
        method: 'post',
        data:data
    })
}

export function addCamera(data) {
    return service({
        url: '/api/addcamera.action',
        method: 'post',
        data:data
    })
}