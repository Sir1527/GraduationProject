import  request  from "@/utils/http";

export interface activityData {
    pageNum: number;
    pageSiez: number;
}

export const getActivityListAPI = (pageNum:number,pageSiez:number) => {
    return request({
        url: '/activity/selectPage',
        method:'GET',
        params: {
            pageNum,
            pageSiez
        }
    })
}