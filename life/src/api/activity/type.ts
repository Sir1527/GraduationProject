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
    data?: activity
}

export interface respActivityList {
    code?: string,
    msg?: string,
    data?: {
        list: activity[],
        total: number
    }
}
