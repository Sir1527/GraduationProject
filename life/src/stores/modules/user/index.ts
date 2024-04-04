import {defineStore} from "pinia";
import type {LoginFormData, RespUserData} from "@/api/user/type";
import {reqLogin} from "@/api/user/user";
import {setToken} from "@/utils/auth";
import type {UserState} from "@/stores/modules/user/types";

const userAppStore = defineStore('user',{
    state: () => {
        return {}
    },

    getters: {

    },

    actions: {
        async userLogin(data: LoginFormData) {
            let res: RespUserData = await reqLogin(data)
            if (res.code === '200') {
                this.token = res.data as string;
                setToken(this.token)
                return 'ok'
            } else {
                return Promise.reject(new Error(res.data as string))
            }
        },
    },
})

export default userAppStore