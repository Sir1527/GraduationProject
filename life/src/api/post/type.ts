export interface post {
    postId?: string,
    userId?: string,
    userAvatar?: string,
    title?: string,
    cover?: string,
    content?: string,
    category?: string,
    count?: string,
    createTime?:string,
}

export interface RespPostPageList {
    code?: string,
    mas?: string,
    data?: {
        total?: number,
        list?: Array<post>,
        pageNum?: number,
        pageSize?: number,
    }
}

export interface RespPost{
    code?: string,
    mas?: string,
    data?: post
}

export interface FormPost {
    userId?: string,
    userAvatar?: string,
    title?: string,
    cover?: string,
    content?: string,
    category?: string,
}