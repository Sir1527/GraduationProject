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

export { isLogin, getToken, setToken, clearToken, getUserId, setUserId };