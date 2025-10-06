import './LoginForm.css';
import { useState } from 'react';

export default function LoginForm() {
    const [message, setMessage] = useState("...");
    const [displayMessage, setDisplayMessage] = useState(false);

    function onSubmit(event) {
        event.preventDefault();
        const formData = new FormData(event.target)

        const loginInfo = {
            email: formData.get('email'),
            password: formData.get('password')
        };

        (async () => {
            const response = await fetch('http://localhost:8080/trello/v1/user/login', {
                method: "POST",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*',
                    'Access-Control-Allow-Methods': 'DELETE, POST, GET, OPTIONS',
                    'Access-Control-Allow-Headers': 'Content-Type, Authorization, X-Requested-With'
                },
                body: JSON.stringify(loginInfo),
            });
            const content = await response.json();
            if (response.ok) {
                setMessage(`Welcome ${content.name}!`);
                setDisplayMessage(true);
            } else {
                setMessage("Cannot log in, username and/or password are incorrect");
                setDisplayMessage(true);
            }
            console.log(content);
        })();
    }
    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={onSubmit}>
                <input className="email" type="email" id="email" name="email" placeholder="email" required />
                <input className="pwd" type="password" id="password" name="password" placeholder="password" required />
                <br/><br/>
                <button className="login">
                    <span>login</span>
                </button>
            </form>
            <h3 className={ displayMessage ? 'sigMessage' : null }>{message}</h3>
            <div className={ displayMessage ? 'sig sigDisplay' : 'sig' }></div>
        </div>
    );
}
