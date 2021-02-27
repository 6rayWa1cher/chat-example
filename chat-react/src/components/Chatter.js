import React, {useRef, useState} from "react";
import SockJsClient from 'react-stomp';
import {wsEndpointUrl} from "../config";

const Chatter = () => {
    const client = useRef(null);
    const [author, setAuthor] = useState('Human');
    const [text, setText] = useState('Hello world!');
    const [messages, setMessages] = useState([]);

    const sendEndpoint = '/app/chat/send';
    const topics = ['/topic/msg'];

    const getClient = () => client.current;

    const sendMessage = (body, author) => getClient().sendMessage(sendEndpoint, JSON.stringify(
        {
            body,
            author
        }
    ));

    return (
        <>
            <SockJsClient
                url={wsEndpointUrl}
                topics={topics}
                onMessage={(msg) => {
                    console.log(msg);
                    setMessages([...messages, msg]);
                }}
                ref={c => client.current = c}
            />
            <div>
                <h3>Chat</h3>
                {messages.map(({body, author}) => (
                    <p style={{backgroundColor: 'yellow'}}>{author}: {body}</p>
                ))}
            </div>
            <input value={author} onChange={evt => setAuthor(evt.target.value)}/>
            <input value={text} onChange={evt => setText(evt.target.value)}/>
            <button onClick={() => sendMessage(text, author)}>Send!</button>
        </>
    )
};

export default Chatter;