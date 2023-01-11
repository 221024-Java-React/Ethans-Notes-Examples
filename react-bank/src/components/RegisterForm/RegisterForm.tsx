import React, {useRef, useEffect} from 'react';
import axios from 'axios';
import {useNavigate} from 'react-router-dom';

export const RegisterForm:React.FC<{changeToggle: ()=>void}> = ({changeToggle}) => {

    const first = useRef<HTMLInputElement>(null);
    const last = useRef<HTMLInputElement>(null);
    const email = useRef<HTMLInputElement>(null);
    const password = useRef<HTMLInputElement>(null);

    const nav = useNavigate();

    const handleRegisterClick = async () => {
        if(first.current && last.current && email.current && password.current){
            let req = await axios.post('http://localhost:8080/user/register', {
                userId: 0,
                firstName: first.current.value,
                lastName: last.current.value,
                email: email.current.value,
                password: password.current.value,
                accounts: []
            });

            let res = await req.data;
            console.log(res);

            changeToggle();

            nav("/");
        }
        
    }

    //To treat a useEffect as a component did mount, you simply leave the depedency array blank
    useEffect(() => {
        //To treat useEffect as a component will unmount you create a return with a callback function with
        //some cleanup code
        return () => {
            //When the component unmounts, set all of our inputs to empty
            if(first.current && last.current && email.current && password.current){
                first.current.value = "";
                last.current.value = "";
                email.current.value = "";
                password.current.value = "";
            }
        }
    }, [])

    return (
        <div className="reg-container">
            <h2>Enter your information to register below</h2>
            <p>First Name</p>
            <input type="text" ref={first}/>
            <p>Last Name</p>
            <input type="text" ref={last}/>
            <p>Email</p>
            <input type="email" ref={email}/>
            <p>Password</p>
            <input type="password" ref={password}/>
            <button onClick={handleRegisterClick}>Register New User</button>
        </div>
    )
}
