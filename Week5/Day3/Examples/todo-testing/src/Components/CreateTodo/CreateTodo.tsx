import React, {useState} from 'react';
import {Todo} from '../../Types/Todo';

export const CreateTodo : React.FC<{create(todo:Todo):void}> = ({create}) => {

    const [todo, setTodo] = useState<Todo>({
        id: 0,
        title: "",
        description: "",
        finished: false
    });

    const handleChange = (e:React.ChangeEvent<HTMLInputElement>) => {
        setTodo({
            ...todo,
            [e.target.name]: e.target.value
        });
    }

    const submit = () => {
        const newTodo = {
            id: Math.floor(Math.random() * 1000) + 1,
            title: todo.title,
            description: todo.description,
            finished: false
        }

        create(newTodo);
    }

    return (
        <div className="new-todo">
            <h1>Todo Name</h1>
            <input name="title" placeholder={"Todo Title"} onChange={handleChange}/>
            <h1>Todo Description</h1>
            <input name="description" type="textarea" placeholder={"Todo Description"} onChange={handleChange}/>
            <button onClick={submit}>Create Todo</button>
        </div>
    )

}