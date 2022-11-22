import React from 'react';

import './Testimony.css';

interface TestimonyProps {
    text: string;
    image: string;
}

export class Testimony extends React.Component<TestimonyProps, {}> {

    constructor(props:TestimonyProps){
        super(props);
    }

    render():React.ReactNode {
        return (
            <div className="testimony">
                <img  className="testimony-img" src={this.props.image}/>
                <p className="testimony-text">{this.props.text}</p>
            </div>
        )
    }

}