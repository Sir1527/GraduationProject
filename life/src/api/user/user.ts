import  request  from "@/utils/http";
import type {LoginFormData, RespUserData} from "@/api/user/type";

enum API {
    LOGIN_URL = '/login',
}

export const reqLogin = (data : LoginFormData) =>
    request.post<any, RespUserData>(API.LOGIN_URL, data)



