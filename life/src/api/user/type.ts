export interface LoginFormData {
    username?: string,
    password?: string,
    role?: string,
}

export interface UserData {
    id?: string,
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
    data?: UserData,
}