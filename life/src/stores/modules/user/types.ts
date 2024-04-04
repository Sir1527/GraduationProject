export type RoleType = 'USER' | 'ADMIN'

export interface UserState {
    username?: string;
    password?: string;
    name?: string;
    avatar?: string;
    phone?: string;
    email?: string;
    token?: string;
    role: RoleType;
}