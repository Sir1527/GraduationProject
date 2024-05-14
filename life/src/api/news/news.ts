import request from "@/utils/http"
import type {RespNews, RespNewsPageData, RespNewsTopData} from "@/api/news/type";
import {getUserId} from "@/utils/auth";
import type {UserData} from "@/api/user/type";

enum API {
    NEWS_TOP_URL = '/news/selectTopNews',
    NEWS_TableData_URL = '/news/selectPage?userId=',
    News_Category_URL = '/news/selectPage',
    News_URL = '/news/selectById/'
}

export const reqNewsTopList = (sort: string) =>
    request.get<any,RespNewsTopData>(API.NEWS_TOP_URL+'?sort='+sort)

export const getTableDateAPI = (userId: string | any) => {
    return request({
        url: '/news/selectPage?pageSize=50&userId=' + userId,
        method: 'GET',
    })
}

export const reqNewsTableDate = (userId: string | any) =>
    request.get<any,RespNewsPageData>(API.NEWS_TableData_URL + userId)

export const reqCategoryNews = (category: string) =>
    request.get<any,RespNewsPageData>(API.News_Category_URL+'category='+category+'&pageSize=50')

export const getNews = (id: number, userId: string | any) =>
    request.get<any,RespNews>(API.News_URL+id + '?userId=' + userId)

export const reqNewsCount = (id: string) =>
    request.put<any>('/news/updateCount/' + id)
