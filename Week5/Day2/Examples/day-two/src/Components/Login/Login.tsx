import React, {useState} from 'react';
import {useNavigate} from 'react-router-dom';

import axios from 'axios';

export const Login:React.FC = () => {

    const [email, setEmail] = useState<string>("");
    const [password, setPassword] = useState<string>("");
    const [error, setError] = useState<boolean>(false);

    //With react router dom there is a hook called useNavigate that allows you to change the location on demand
    let navigate = useNavigate();

    const handleChange = (e:React.ChangeEvent<HTMLInputElement>): void => {
        if(e.target.name === "email"){
            setEmail(e.target.value);
        } else {
            setPassword(e.target.value);
        }
    }

    const handleLogin = async () => {
        let login = {
            email, 
            password
        }

        //try to make a request to the backend to login
        try{
            //url, requstBody, optional other metadata obj
            let res = await axios.post('http://localhost:8000/person/login', login);
            setError(false);
            let user = await res.data;

            console.log(user);

            //Do some login to determine where to push them
            if(user.type === "TEACHER"){
                navigate("/courses");
            }
            else {
                navigate("/student");
            }



        } catch(e){
            setError(true);
        }
    }

    return (
        <div className="login">
            {error ? <h3>Username or password incorrect</h3> : <></>}
            <h2>Email:</h2>
            <input type="text" name="email" onChange={handleChange}/>
            <h2>Password:</h2>
            <input type="password" name="password" onChange={handleChange}/>
            <button onClick={handleLogin}>Login</button>
        </div>
    )

}