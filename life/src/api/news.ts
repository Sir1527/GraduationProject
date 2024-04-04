import  request  from "@/utils/http";

export const getNewsTopListAPI = (sort: string) => {
    return request({
        url: '/news/selectTopNews',
        method: 'GET',
        params:{
            sort
        }
    })
}

export const getTableDateAPI = () => {
    return request({
        url: '/news/selectPage',
        method: 'GET',
    })
}