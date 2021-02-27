import React, {useRef, useState} from "react";
import SockJsClient from 'react-stomp';
import {wsEndpointUrl} from "../config";

const Chatter = ({username, password, handleLoginFailure}) => {
    const client = useRef(null);
    const [text, setText] = useState('Hello world!');
    const [messages, setMessages] = useState([]);
    const [targetUsername, setTargetUsername] = useState('');

    const sendEndpoint = '/app/chat/send';
    const dmEndpoint = (targetUsername) => `/app/chat/dm_send/${targetUsername}`;
    const topics = ['/topic/msg', `/topic/dm/${username}`];

    const getClient = () => client.current;

    const sendMessage = (body) => getClient().sendMessage(sendEndpoint, JSON.stringify(
        {
            body
        }
    ));

    const sendDirectMessage = (body, target) => {
        setMessages([...messages, {body, author: username}])
        getClient().sendMessage(dmEndpoint(target), JSON.stringify(
            {
                body
            }
        ));
    }

    return (
        <>
            <SockJsClient
                url={wsEndpointUrl}
                topics={topics}
                headers={{
                    login: username,
                    passcode: password
                }}
                onMessage={(msg) => {
                    console.log(msg);
                    setMessages([...messages, msg]);
                }}
                onConnectFailure={(msg) => {
                    console.error(msg);
                    if (typeof msg !== "object" || !"headers" in msg) return;
                    const {headers} = msg;
                    const {message} = headers;
                    if (message.includes("BadCredentialsException")) {
                        client.current.disconnect()
                        handleLoginFailure();
                    }
                }}
                ref={c => client.current = c}
            />
            <div>
                <h3>Chat</h3>
                {messages.map(({body, author}) => (
                    <p style={{backgroundColor: 'yellow'}}>{author}: {body}</p>
                ))}
            </div>
            <input value={text} onChange={evt => setText(evt.target.value)}/>
            <br/>
            <button onClick={() => sendMessage(text)}>Send!</button>
            <br/>
            <input value={targetUsername} onChange={evt => setTargetUsername(evt.target.value)}/>
            <button onClick={() => sendDirectMessage(text, targetUsername)}>Send to user!</button>
        </>
    )
};

export default Chatter;