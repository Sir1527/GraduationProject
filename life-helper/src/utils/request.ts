import axios from "axios";

const request = axios.create({
    baseURL:'http://localhost:9090',
    timeout: 3000
});

request.interceptors.response.use(
    response => {
        let res = response.data;

        if (typeof res === 'string') {
            res = response.data;
        }
        if (typeof res === 'string') {
            res = res ? JSON.parse(res) : res
        }
        return res;
    },
    error => {
        console.error('response error:' + error)
        return Promise.reject(error)
    }
)

export default request;