export interface Reminder {
    reminderId?: string,
    userId?: string | any,
    reminderTime?: string,
    time?: number,
    title?: string
    createTime?: string,
}

export interface respReminder {
    code?: string,
    msg?: string,
    data?: Array<Reminder>,
}


