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

const setUserName = (userName: string) => {
    return localStorage.setItem('userName', userName)
}

const getUserName = () => {
    return localStorage.getItem('userName')
}

const setName = (name: string) => {
    return localStorage.setItem('name', name)
}

const getName = () => {
    return localStorage.getItem('name')
}

const setUserEmail = (email: string) => {
    return localStorage.setItem('email', email)
}

const getEmail = () => {
    return localStorage.getItem('email')
}

const setPhone = (phone: string) => {
    return localStorage.setItem('phone', phone)
}

const getPhone = () => {
    return localStorage.getItem('phone')
}

export { isLogin, getToken, setToken, clearToken, getUserId, setUserId, setUserCAvatar, getUserAvatar, setUserName, getUserName, setName, getName, setUserEmail, getEmail, setPhone, getPhone };