//import a couple of things from the react testing library
import {render, screen, waitFor, fireEvent} from "@testing-library/react";
import { Todo } from "../../Types/Todo";
import { TodoCard } from "./TodoCard";

//first we describe/create our test suite
describe("Todo card component test suite", () => {

    //For our Todo card, we must pass in some functions, so we will use a mock to watch those functions
    const update = jest.fn(() => console.log("update method was called"));
    const remove = jest.fn(() => console.log("The remove method was called"));

    //Lets also create a test todo object
    const todo = {
        id: 1,
        title: "Test",
        description: "Description",
        finished: false
    }

    //Describe the individual tests
    it("should display the title passed in as a prop", () => {
        //Render the component so we can check the dom
        render(<TodoCard todo={todo} updateTodo={update} removeTodo={remove}/>);

        //we test to see that the property title is displayed in our component
        waitFor(() => expect(
            screen.findByText("Test")
        ).toBeInTheDocument());
    });

    it("should display the description passed in as a prop", () => {
        render(<TodoCard todo={todo} updateTodo={update} removeTodo={remove}/>);
        waitFor(() => expect(
            screen.findByText("Description")
        ).toBeInTheDocument());
    });

    //Check for user events
    it("should call the props function when the update button is pressed", () => {
        render(<TodoCard todo={todo} updateTodo={update} removeTodo={remove} />);
        fireEvent.click(screen.getByText("Check Complete"));
        expect(update).toBeCalledTimes(1);
    })

    //Check for user events
    it("should call the props function when the remove button is pressed", () => {
        render(<TodoCard todo={todo} updateTodo={update} removeTodo={remove} />);
        fireEvent.click(screen.getByText("Remove Todo"));
        expect(remove).toBeCalledTimes(1);
    })

});