import  request  from "@/utils/http";
import type {FormPost, RespPost, RespPostPageList} from "@/api/post/type";

enum API {
    POST_LIST_PAGE_URL = 'post/selectPage',
    POST_ADD_URL = 'post/add',
    POST_URL = 'post/selectById/',
    POST_COUNT_URL = 'post/updateCount/'
}

export const reqPostListPage = (pageNum: number | any, pageSize: number | any, userId: string | any) =>
    request.get<any, RespPostPageList>(API.POST_LIST_PAGE_URL + '?pageNum=' + pageNum + '&pageSize=' + pageSize + '&userId=' + userId)

export const reqAddPost = (data: FormPost) =>
    request.post<any, RespPost>(API.POST_ADD_URL, data)

export const reqPostListCategory = (pageNum: number | any, pageSize: number | any,category: string | any) =>
    request.get<any, RespPostPageList>(API.POST_LIST_PAGE_URL+ '?pageNum=' + pageNum + '&pageSize=' + pageSize + '&category=' + category)

export const reqPost = (id: number | any, userId: string | any) =>
    request.get<any,RespPost>(API.POST_URL + id + '?userId=' + userId)

export const reqPostCount = (id: string) =>
    request.put<any,RespPost>(API.POST_COUNT_URL + id)