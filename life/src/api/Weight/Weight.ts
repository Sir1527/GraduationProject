import  request  from "@/utils/http";
import type {respWeightEcharts, WeightAdd} from "@/api/Weight/type";

enum API {
    WeightECharts_URL = "/weight/selectEcharts?userId=",
    WeightECharts_ADD_URL = "/weight/add",
}

export const reqGetWeightECharts = (userId: string | any) =>
    request.get<any, respWeightEcharts>(API.WeightECharts_URL + userId)

export const reqWeightECharts = (data: WeightAdd | any) =>
    request.post<any,respWeightEcharts>(API.WeightECharts_ADD_URL, data)

