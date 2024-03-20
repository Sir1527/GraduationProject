import request from "@/utils/http";


export const getNewsTopListAPI = () => {
    return request({
        url: 'news/selectAll',
        method: 'GET',
    })
}