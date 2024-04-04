import axios from "axios";
import {getToken} from "@/utils/auth";
import router from "@/router";

const httpInstance = axios.create({
    baseURL:'http://localhost:9090',
    timeout: 30000,
})

httpInstance.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json;charset=utf-8';
    const user = getToken();
    config.headers['token'] = user;

    return config;
}, error => {
    console.error('request error:' + error);
    return Promise.reject(error);
});

// response 拦截器
// 可以在接口响应后统一处理结果
httpInstance.interceptors.response.use(
    response => {
        let res = response.data;

        // 兼容服务端返回的字符串数据
        if (typeof res === 'string') {
            res = res ? JSON.parse(res) : res
        }
        if (res.code === '401') {
            router.push('/login')
        }
        return res;
    },
    error => {
        console.error('response error: ' + error) // for debug
        return Promise.reject(error)
    }
)

export default httpInstance;