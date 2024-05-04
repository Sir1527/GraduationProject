import  request  from "@/utils/http";
import type {respActivity, respActivityList} from "@/api/activity/type";

enum API {
    ACTIVITY_URL = '/activity/selectPage',
}

export const reqActivity = (id: string) =>
    request.get<any,respActivity>('activity/selectById/' + id)

export const reqActivityList = (pageNum: number, pageSize: number,) =>
    request.get<any,respActivityList>(API.ACTIVITY_URL + '?pageNum=' + pageNum +'&pageSize=' +pageSize)

