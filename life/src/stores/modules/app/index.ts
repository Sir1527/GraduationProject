import {defineStore} from "pinia";
import type {AppState} from "@/stores/modules/app/types";
import defaultSettings from '@/config/config.json'

const useAppStore = defineStore('app', {
    state: (): AppState => ({ ...defaultSettings}),

    getters: {

    },

    actions: {
        // Update app settings
        updateSettings(partial: Partial<AppState>) {
            // @ts-ignore-next-line
            this.$patch(partial);
        },
        toggleTheme(dark: boolean) {
            if (dark) {
                this.theme = 'dark';
                document.body.setAttribute('arco-theme', 'dark');
            } else {
                this.theme = 'light';
                document.body.removeAttribute('arco-theme');
            }
        },
        toggleDevice(device: string) {
            this.device = device;
        },
        toggleMenu(value: boolean) {
            this.hideMenu = value;
        },
    },

})

export default useAppStore;