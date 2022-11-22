import React from 'react';
import logo from '../../img/Revature.png';
import './Navbar.css';

export class Navbar extends React.Component {

    render(){
        return(
            <div className="navbar">
                <div className="nav-item">
                    <img className="nav-logo" src={logo} />
                </div>
                <div className="nav-item">
                    <p className="nav-link">Course Link</p>
                </div>
                <div className="nav-item">
                    <p className="nav-link">Student/Teacher Login</p>
                </div>
            </div>
        )
    }

}