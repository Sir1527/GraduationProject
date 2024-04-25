import  request  from "@/utils/http";
import type {respCommentCount, respCommentList} from "@/api/comment/type";

enum API {
    COMMENT_LIST_URL = '/comment/selectTree/',
    COMMENt_COUNT_URL = '/comment/selectCount/',
}

export const reqCommentList = (fid: string | any, module: string | any) =>
    request.get<any,respCommentList>(API.COMMENT_LIST_URL + fid + '/' +module)

export const reqCommentCount = (fid: string, module: string) =>
    request.get<any,respCommentCount>(API.COMMENT_LIST_URL + fid + '/' +module)