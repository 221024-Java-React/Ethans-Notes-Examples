import React, {useState, useEffect} from 'react';
//import the component to use inside of anothe compontent
import { RegisterForm } from '../RegisterForm/RegisterForm';
import { LoginForm } from '../LoginForm/LoginForm';
import { useNavigate } from 'react-router-dom';

export const LoginPage:React.FC = () => {

    //useState is a hook that allows us to manage the state of this particular component
    const [registerToggle, setRegisterToggle] = useState<boolean>(false);

    const navigate = useNavigate();
    
    useEffect(()=> {
        if(localStorage.getItem("userId")) navigate("/home");
    },[])

    return (
        <div className="login-container">
            <h1>Welcome to the Bank of Revature</h1>
            {
                !registerToggle ? <LoginForm/> :
                    <RegisterForm changeToggle={() => setRegisterToggle(!registerToggle)}/>
            }
            {/* We want to register a click listener on the span below to allow the user to switch to register mode*/}
            {!registerToggle ? <p>Not a member? <span onClick={() => setRegisterToggle(!registerToggle)}>Click Here to Register.</span></p> : <></>}
        </div>
    )
}
