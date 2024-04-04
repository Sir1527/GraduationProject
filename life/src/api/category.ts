import  request  from "@/utils/http";

export const getCategoryListAPI = () => {
    return request({
        url: '/category/selectAll',
        method: 'GET'
    })
}