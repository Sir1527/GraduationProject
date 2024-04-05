import { defineStore } from 'pinia';
import type { UserState } from './types';
import {getToken, setToken} from "@/utils/auth";
import type {LoginFormData, RespUserData} from "@/api/user/type";
import {reqLogin} from "@/api/user/user";
import {set} from "@vueuse/core";

export const useUserStore = defineStore('User', {
    state: (): UserState => {
        return {
            token: getToken() as string,
        }
    },

    actions: {
        async login(data: LoginFormData){
            const res: RespUserData = await reqLogin(data)
            if (res.code === '200') {
                this.token = res.data?.token as string;
                setToken(res.data?.token as string);
                return 'ok'
            }else {
                return Promise.reject(new Error(res.msg as string))
            }
        }
    }
})


export default useUserStore;