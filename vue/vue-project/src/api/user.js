import service from '@/axios/request'

export function login(data) {
    return service({
        url: '/api/login.action',
        method: 'post',
        data:data
    })
}

export function getUserlist(data) {
    return service({
        url: '/api/userlist.action',
        method: 'post',
        data:data
    })
}

export function deleteUser(data) {
    return service({
        url: '/api/deleteuser.action',
        method: 'post',
        data:data
    })
}

export function updateUser(data) {
    return service({
        url: '/api/updateuser.action',
        method: 'post',
        data:data
    })
}

export function addUser(data) {
    return service({
        url: '/api/adduser.action',
        method: 'post',
        data:data
    })
}