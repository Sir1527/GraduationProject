export interface newsData {
    id?: string,
    title?: string,
    descr?: string,
    content?: string,
    cover?: string,
    time?: string,
    count?: number,
    category?: string,
    likes?: string,
}

export interface TableData {
    pageNum?: number,
    pageSize?: number,
    total?: number,
    list?: Array<[]>;
}

export interface RespNews {
    code?: string,
    msg?: string,
    data?: newsData,
}

export interface RespNewsTopData {
    code?: string,
    msg? :string,
    data?: Array<newsData>,
}

export interface RespNewsPageData {
    code?: string,
    msg?: string,
    data?: {
        total?: number,
        list?: Array<newsData>,
        pageNum?: number,
        pageSize?: number,
        size?: number,
        startRow?: number,
        endRow?: number,
        pages?: number,
        prePage?: number,
        nextPage?: number,
        isFirstPage?: boolean,
        isLastPage?: boolean,
        hasPreviousPage?: boolean,
        hasNextPage?: boolean,
        navigatepageNums?: [number],
        navigateFirstPage?: number,
        navigateLastPage?: number,
    }
}

