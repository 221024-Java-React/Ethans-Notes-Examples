import React from 'react';

//Import any css file/s you need to style your component

//Define any state or props interfaces
interface State {
    value: string
}

interface Props {
    propValue: number
}

export class GenericComponent extends React.Component<Props, State> {

    //define your state
    state = {
        value: ""
    }

    //Pass the props to the constructor
    constructor(props:Props){
        super(props)

        //If you have default values for state, you can include them here
    }

    //Use any life cycle methods you may need
    //Define any logical methods you may need for the component

    //implement the render method
    render(): React.ReactNode {
        return (
            <div>

            </div>
        )
    }

}