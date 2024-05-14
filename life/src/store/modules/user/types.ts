export type RoleType = 'USER' | 'ADMIN'

export interface UserState {
    id?: string;
    username?: string;
    name?: string;
    avatar?: string;
    phone?: string;
    email?: string;
    token?: string;
    role?: RoleType;
}