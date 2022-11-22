//Import the react dependency to access the React.Component class
import React from 'react';

import { Testimony } from '../Testimony/Testimony';
import logo from "../../img/Revature.png";
//Import any CSS  sheets that you need
import './Welcome.css';

interface WelcomeState {
    message: string,
    testimony: string[]
}

//We pass in the datatypes for any props passed in, as well as the datatype for the state
export class Welcome extends React.Component<any, WelcomeState> {

    //start out with empty state
    state:WelcomeState = {
        message: "",
        testimony: []
    };

    //Constructor is used to passing props if had any, and possibly setting some default state
    constructor(props:any) {
        super(props);
    }

    //ComponentDidMount method is primarily used to make requests/load data externally
    componentDidMount(): void {
        console.log("The welcome page rendered");
        //We made a api request and load data into the state
        this.setState({
            message: "Have an attitude of gratitude",
            testimony: [
                "Testimony number 1",
                "Testimony number 2"
            ]
        });

        console.log(this.state);
    }

    componentWillUnmount(): void {
        console.log("Mine time has come partner, its the end");
        this.setState({
            message: "",
            testimony: []
        });
    }

    //To display the component, we want to have a render method
    render(): React.ReactNode {
        return(
            <div className="welcome">
                <h1>Welcome to our school</h1>

                <h2>Revatures Message of the day:</h2>
                <h3>{this.state.message}</h3>

                <h2>Here's what our students have to say</h2>
                <Testimony 
                    text={this.state.testimony[0]}
                    image={"https://media.istockphoto.com/id/1354898581/photo/shot-of-a-young-businessman-using-a-laptop-in-a-modern-office.jpg?b=1&s=170667a&w=0&k=20&c=TH7fxRJwwlUKThNim9J9xYwH3j_Ih8m3WPTSew-Xaw4="}
                ></Testimony>
                <Testimony 
                    text={this.state.testimony[1]}
                    image={"https://thumbs.dreamstime.com/b/warm-friendly-beautiful-cheerful-african-american-executive-business-woman-isolated-white-background-beautiful-female-african-167982803.jpg"}
                ></Testimony>

            </div>
        );
    }
}