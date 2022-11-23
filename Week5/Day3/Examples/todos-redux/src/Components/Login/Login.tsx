import React, {useState} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import { DispatchType, RootState } from '../../Redux/Store';
import { login } from '../../Redux/Slices/PersonSlice';

export const Login:React.FC = () => {

    const userState = useSelector((state:RootState) => state.user);
    const dispatch:DispatchType = useDispatch();

    const [email, setEmail] = useState<string>("");
    const [password, setPassword] = useState<string>("");

    const handleChange = (e:React.ChangeEvent<HTMLInputElement>) => {
        if(e.target.name === "email"){
            setEmail(e.target.value);
        } else {
            setPassword(e.target.value);
        }
    }

    const handleLogin = () => {
        dispatch(login({email, password}));
    }

    return(
        <div className="login">
            {userState.error ? <h3>Username or password incorrect</h3> : <></>}
            <h1>Email</h1>
            <input name="email" placeholder="Your email" onChange={handleChange}/>
            <h1>Password</h1>
            <input type="password" name="password" placeholder="Your password" onChange={handleChange}/>
            <button onClick={handleLogin}>Login</button>
        </div>
    )


}