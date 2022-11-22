import React, {useContext, useState} from 'react';
import { Context } from '../../Context/TodoContext';
import {ContextState, Todo} from '../../Types/Todo';

export const CreateTodo : React.FC = () => {

    const [newTodo, setNewTodo] = useState<Todo>({
        id: 0,
        title: "",
        description: "",
        finished: false
    });

    //To gain access to the context, we use the useContext hook
    const {addTodo} = useContext(Context) as ContextState;

    const handleChange = (e:React.ChangeEvent<HTMLInputElement>) => {
        setNewTodo({
            ...newTodo,
            [e.target.name]: e.target.value
        });
    }

    const submitTodo = () => {
        addTodo(newTodo);
    }

    return(
        <div className="new-todo">
            <h1>Todo Name</h1>
            <input name="title" onChange={handleChange}/>
            <h1>Todo Description</h1>
            <input name="description" type="textarea" onChange={handleChange}/>
            <button onClick={submitTodo}>Create Todo</button>
        </div>
    )

}