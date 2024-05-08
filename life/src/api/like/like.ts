import  request  from "@/utils/http";
import type {likeNewsAdd, respLike} from "@/api/like/type";

enum API {
    likeAdd_URL = '/like/add',
}

export const reqLikeAdd = (like: likeNewsAdd | any) =>
    request.post<any,respLike>(API.likeAdd_URL,like)

export const deleteLikeNews = (userId: string | any, newsId: string | any) =>
    request.delete<any,respLike>('/like/deleteNews?userId=' +userId+ '&newsId='+ newsId);

export const deleteLikePost = (userId: string | any, postId: string | any) =>
    request.delete<any,respLike>('/like/deletePost?userId=' +userId+ '&postId='+ postId);