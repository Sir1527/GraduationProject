import  request  from "@/utils/http";
import type {LoginFormData, RespUserData} from "@/api/user/type";

enum API {
    LOGIN_URL = '/login',
    USER_ID = '/user/selectById/'
}

export const reqLogin = (data: LoginFormData) =>
    request.post<any, RespUserData>(API.LOGIN_URL, data)

export const reqUserById = (id: string | any) =>
    request.get<any,RespUserData>(API.USER_ID + id)



