import React, {useState} from 'react';
//import the component to use inside of anothe compontent
import { RegisterForm } from '../RegisterForm/RegisterForm';

export const LoginPage:React.FC = () => {

    //useState is a hook that allows us to manage the state of this particular component
    const [registerToggle, setRegisterToggle] = useState<boolean>(false);

    return (
        <div className="login-container">
            <h1>Welcome to the Bank of Revature</h1>
            {
                !registerToggle ? <h2>Login Form Shown</h2> :
                    <RegisterForm changeToggle={() => setRegisterToggle(!registerToggle)}/>
            }
            {/* We want to register a click listener on the span below to allow the user to switch to register mode*/}
            <p>Not a member? <span onClick={() => setRegisterToggle(!registerToggle)}>Click Here to Regsiter.</span></p>
        </div>
    )
}
