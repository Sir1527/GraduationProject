export interface newsData {
    id?: string,
    title?: string,
    descr?: string,
    content?: string,
    cover?: string,
    time?: string,
    count?: number,
    category?: string,
}

export interface RespNewsData {
    code?: string,
    msg? :string,
    data?: Array<newsData>,
}