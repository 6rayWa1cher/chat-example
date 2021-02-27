import React from 'react';

const LoginPage = ({handleLogin, username, setUsername, password, setPassword}) => {

    return (
        <>
            <input value={username} onChange={evt => setUsername(evt.target.value)}/>
            <input value={password} onChange={evt => setPassword(evt.target.value)}/>
            <button onClick={handleLogin}>Login</button>
        </>
    );
}

export default LoginPage;