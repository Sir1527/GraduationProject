import  request  from "@/utils/http";
import type {Reminder, respReminder} from "@/api/reminder/type";

enum API {
    REMINDER_URL = "/reminder/selectAll",
    REMINDER_ADD_URL = "/reminder/add",
}

export const reqReminder = (userId: string | any) =>
    request.get<any,respReminder>(API.REMINDER_URL + '?userId=' + userId)

export const reqReminderAdd = (data: Reminder | any) =>
    request.post<any,respReminder>(API.REMINDER_ADD_URL,data)