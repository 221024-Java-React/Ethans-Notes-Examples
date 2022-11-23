import React, {useState} from 'react';
import {useDispatch} from 'react-redux';
import { DispatchType } from '../../Redux/Store';
import { addTodo } from '../../Redux/Slices/TodoSlice';
import {Todo} from '../../Types/Todo';

export const CreateTodo : React.FC = () => {

    const dispatch:DispatchType = useDispatch();

    const [newTodo, setNewTodo] = useState<Todo>({
        id: 0,
        title: "",
        description: "",
        finished: false
    });

    const handleChange = (e:React.ChangeEvent<HTMLInputElement>) => {
        setNewTodo({
            ...newTodo,
            [e.target.name]: e.target.value
        });
    }

    const submitTodo = () => {
        const todo:Todo = {
            id: Math.floor(Math.random() * 1000) +1,
            title: newTodo.title,
            description: newTodo.description,
            finished: false
        };

        //Whenever we submit a new todo by pressing the submit button, we want to dispatch a addTodo action
        dispatch(addTodo(todo));
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