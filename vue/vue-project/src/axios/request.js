import axios from 'axios'

const service = axios.create({
        baseURL:"http://localhost:8090/project",
        timeout:5000
})

export default service;