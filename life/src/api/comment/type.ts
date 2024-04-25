export interface comment {
    id?: string,
    content?: string,
    userId?: string | any,
    pid?: string,
    rootId?: string,
    time?: string,
    fid?: string,
    module?: string,
    username?: string,
    avatar?: string,
    replyUser?: string,
    reply?: string,
    children?: Array<comment>,
}

export interface respCommentList {
    code?: string,
    msg?: string,
    data?: Array<comment>
}

export interface respCommentCount {
    code?: string,
    msg?: string,
    data?: number,
}
