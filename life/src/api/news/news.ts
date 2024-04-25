import request from "@/utils/http"
import type {RespNews, RespNewsPageData, RespNewsTopData} from "@/api/news/type";

enum API {
    NEWS_TOP_URL = '/news/selectTopNews',
    NEWS_TableData_URL = '/news/selectPage',
    News_Category_URL = '/news/selectPage',
    News_URL = '/news/selectById/'
}

export const reqNewsTopList = (sort: string) =>
    request.get<any,RespNewsTopData>(API.NEWS_TOP_URL+'?sort='+sort)

export const getTableDateAPI = () => {
    return request({
        url: '/news/selectPage?pageSize=50',
        method: 'GET',
    })
}

export const reqNewsTableDate = () =>
    request.get<any,RespNewsPageData>(API.NEWS_TableData_URL)

export const reqCategoryNews = (category: string) =>
    request.get<any,RespNewsPageData>(API.News_Category_URL+'category='+category+'&pageSize=50')

export const getNews = (id: number) =>
    request.get<any,RespNews>(API.News_URL+id)

export const reqNewsCount = (id: string) =>
    request.put<any>('/news/updateCount/' + id)