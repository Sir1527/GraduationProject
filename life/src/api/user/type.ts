import type {UserState} from "@/store/modules/user/types";

export interface LoginFormData {
    username?: string,
    password?: string,
    role?: string,
}

export interface UserData {
    id?: string | any,
    name?: string,
    username?: string,
    password?: string,
    role?: string,
    newPassword?: string,
    avatar?: string,
    token?: string,
    phone?: string,
    email?: string
}

export interface RespUserData {
    code?: string,
    msg?: string,
    data: UserState,
}