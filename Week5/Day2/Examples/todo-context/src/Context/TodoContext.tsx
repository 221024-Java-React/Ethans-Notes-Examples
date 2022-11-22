import React, {useState} from 'react';
import { Todo, ContextState } from '../Types/Todo';

interface ProviderProps {
    children: React.ReactNode
}

//Create our context with the information we want store/provide
export const Context = React.createContext<ContextState | null>(null);

//Create a provider to wrap our components in, which will provide the context without using props
export const TodoProvider:React.FC<ProviderProps> = ({children}) => {

    const [todos, setTodos] = useState<Todo[]>([]);

    //We have to implement all the features of our ContextState, so that includes the above todos,
    //as well as the functions

    const addTodo = (todo:Todo) => {

        console.log("In the todo context addTodo");

        //Add logic in a second
        const newTodo: Todo = {
            id:Math.floor(Math.random() * 1000) + 1,
            title: todo.title,
            description: todo.description,
            finished: false
        }

        setTodos([...todos, newTodo]);
    }

    const updateTodo = (id: number) => {
        console.log("updating a todo");

        todos.filter((todo:Todo) => {
            if(todo.id === id){
                todo.finished = !todo.finished;
                setTodos([...todos])
            }
        })
    }

    const removeTodo = (id:number) => {
        console.log("removing a todo");

        setTodos(todos.filter((todo:Todo) => todo.id !== id));
    }

    //Return the provider so we can provide our context to the components that need it
    return(
        <Context.Provider value={{todos, addTodo, updateTodo, removeTodo}}>
            {children}
        </Context.Provider>
    )
}