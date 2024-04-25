import  request  from "@/utils/http";
import type {respActivity} from "@/api/activity/type";

enum API {
    ACTIVITY_URL = '/activity/selectPage',
}

export const reqActivityList = () =>
    request.get<any,respActivity>(API.ACTIVITY_URL)