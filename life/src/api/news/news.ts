import request from "@/utils/http"
import type {RespNewsPageData, RespNewsTopData} from "@/api/news/type";

enum API {
    NEWS_TOP_URL = '/news/selectTopNews',
    NEWS_TableData_URL = '/news/selectPage'
}

export const reqNewsTopList = (sort: string) =>
    request.get<any,RespNewsTopData>(API.NEWS_TOP_URL+'?sort='+sort)

export const getTableDateAPI = () => {
    return request({
        url: '/news/selectPage',
        method: 'GET',
    })
}

export const reqNewsTableDate = () =>
    request.get<any,RespNewsPageData>(API.NEWS_TableData_URL)