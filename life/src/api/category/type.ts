export interface category{
    id?: string;
    name?: string;
}

export interface respCategory {
    code: number;
    message: string;
    data: category[];
}
