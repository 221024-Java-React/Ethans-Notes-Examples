import React, {useRef, useEffect} from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { loginUser } from '../../redux/userSlice';
import { AppDispatch, RootState } from '../../redux/store';
import { useNavigate } from 'react-router-dom';

export const LoginForm:React.FC = () => {

    //To get the state out of our redux store
    let state = useSelector((state:RootState) => state.user);

    //Send actions to our reducer, which in turn updates our state, then the store
    let dispatch:AppDispatch = useDispatch();

    const emailRef = useRef<HTMLInputElement>(null);
    const passwordRef = useRef<HTMLInputElement>(null);

    const navigate = useNavigate();

    useEffect(() => {

        if(state.loggedIn){
            navigate("/home");
        }

        return () =>{
            //Clean up function, if/when our component unmounts and there is data in the form, lets
            // clear it
            if(emailRef.current) emailRef.current.value = "";
            
            if(passwordRef.current) passwordRef.current.value="";
        }
    }, [state])

    const handleLogin = async () => {
        if(emailRef.current && passwordRef.current){
            await dispatch(loginUser({
                email: emailRef.current.value,
                password: passwordRef.current.value
            }));
        }
    }

    return (
        <div className="login-form-container">
            <h2>Login below:</h2>
            {state.loginError ? <p>Incorrect username or password</p> : <></>}
            <p>Please enter your email.</p>
            <input type="text" ref={emailRef}/>
            <p>Please enter your password.</p>
            <input type="password" ref={passwordRef}/>
            <br/>
            <button onClick={handleLogin}>Login</button>
        </div>
    )
}
