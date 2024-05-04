export interface activity {
    id?: string,
    name?: string,
    cover?: string,
    descr?: string,
    start?: string,
    end?: string,
    content?: string,
    address?: string
    status?: string,
}

export interface respActivity {
    code?: string,
    msg?: string,
    data?: activity | null,
}

export interface respActivityList {
    code?: string,
    msg?: string,
    data?: {
        list: activity[],
        total: string,
        pageNum: string,
        pageSize: string,
    }
}

export interface form {
    userId?: string | any,
    activityId?: string | any,
    phone?: string | any,
}