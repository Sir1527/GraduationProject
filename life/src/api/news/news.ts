import request from "@/utils/http"
import type {RespNewsData} from "@/api/news/type";

enum API {
    NEWS_TOP_URL = '/news/selectTopNews'
}

export const reqNewsTopList = (sort: string) =>
    request.get<any,RespNewsData>(API.NEWS_TOP_URL+'?sort='+sort)

export const getTableDateAPI = () => {
    return request({
        url: '/news/selectPage',
        method: 'GET',
    })
}