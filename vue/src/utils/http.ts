import axios from "axios";

const httpInstance = axios.create({
    baseURL:'http://localhost:9090',
    timeout: 5000,
})

export default httpInstance;