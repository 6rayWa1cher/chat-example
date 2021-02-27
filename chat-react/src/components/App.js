import React, {useState} from 'react';
import Chatter from "./Chatter";
import LoginPage from "./LoginPage";

function App() {
    const [initial, setInitial] = useState(true);
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = () => setInitial(false);
    const handleLoginFailure = () => {
        alert("bad login");
        setInitial(true);
    }

    return initial ? (
        <LoginPage
            username={username}
            setUsername={setUsername}
            password={password}
            setPassword={setPassword}
            handleLogin={handleLogin}
        />
    ) : (
        <Chatter
            username={username}
            password={password}
            handleLoginFailure={handleLoginFailure}
        />
    );
}

export default App;
