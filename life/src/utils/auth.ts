const TOKEN_KEY = 'token';

const isLogin = () => {
    return !!localStorage.getItem(TOKEN_KEY);
};

const getToken = () => {
    return localStorage.getItem(TOKEN_KEY);
};

const setToken =(token: string) => {
    localStorage.setItem(TOKEN_KEY, token);
};

const clearToken = () => {
    localStorage.removeItem(TOKEN_KEY);
};

const setUserId = (id: string) => {
    localStorage.setItem('userId', id);
};

const getUserId = () => {
    return localStorage.getItem('userId');
};

const setUserCAvatar = (avatar: string) => {
    localStorage.setItem('userCAvatar', avatar);
};

const getUserAvatar = () => {
    return localStorage.getItem('userCAvatar');
};

export { isLogin, getToken, setToken, clearToken, getUserId, setUserId, setUserCAvatar, getUserAvatar };