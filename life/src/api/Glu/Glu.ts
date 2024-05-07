import  request  from "@/utils/http";
import type {GluAdd, respGluECharts} from "@/api/Glu/type";

enum API {
    GluECharts_URL = "/glu/selectECharts?userId=",
    GluECharts_ADD_URL = "/glu/add"
}

export const reqGluECharts = (userId: string | any) =>
    request.get<any, respGluECharts>(API.GluECharts_URL + userId)

export const reqAddGluECharts = (gluAdd: GluAdd | any) =>
    request.post<any, respGluECharts>(API.GluECharts_ADD_URL, gluAdd)