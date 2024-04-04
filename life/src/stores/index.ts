import {createPinia} from "pinia";
import useAppStore from "@/stores/modules/app";
import userAppStore from "@/stores/modules/user";

const pinia = createPinia();

export { useAppStore, userAppStore};

export default pinia;