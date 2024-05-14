import { defineStore } from 'pinia';
import type {RoleType, UserState} from './types';

const useUserStore = defineStore('user', {
    state: (): UserState => ({
        id: undefined,
        username: undefined,
        name: undefined,
        avatar:undefined,
        role: undefined,
        phone: undefined,
        email: undefined,
        token: undefined,
    }),

    getters: {
        userInfo(state: UserState): UserState  {
            return { ...state};
        },
    },

    actions: {
        setInfo(partial: Partial<UserState>) {
            this.$patch(partial);
        }
    },
    persist: true
})


export default useUserStore;