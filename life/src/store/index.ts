import {createPinia} from "pinia";
import useUserStore from "@/store/modules/user";
import useAppStore from "@/store/modules/app";

const pinia = createPinia();

export { useUserStore, useAppStore };
export default pinia;

