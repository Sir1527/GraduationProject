import  request  from "@/utils/http";
import type {BloodPressureAdd, respBloodPressureECharts} from "@/api/BloodPressureECharts/type";

enum API {
    BloodPressureECharts_URL = '/bloodPressure/selectEChartsByUserId?userId=',
    BloodPressureECharts_URL_ADD = '/bloodPressure/add',
}

export const reqBloodPressureECharts = (userId: string | any) =>
    request.get<any,respBloodPressureECharts>(API.BloodPressureECharts_URL + userId)

export const reqAddBloodPressureECharts = (data: BloodPressureAdd | any) =>
    request.post<any,respBloodPressureECharts>(API.BloodPressureECharts_URL_ADD, data)