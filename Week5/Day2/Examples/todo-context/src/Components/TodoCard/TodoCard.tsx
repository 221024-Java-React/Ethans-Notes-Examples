import React, {useContext, useState, useEffect} from 'react';
import { Context } from '../../Context/TodoContext';
import { Todo, ContextState } from '../../Types/Todo';
import './TodoCard.css';

export const TodoCard:React.FC<Todo> = ({id, title, description, finished}) => {

    const [style, setStyle] = useState<string>("incomplete");
    const {updateTodo, removeTodo} = useContext(Context) as ContextState;

    const finish = () => {
        updateTodo(id);
    }

    const remove = () => {
        removeTodo(id);
    }

    useEffect(()=>{
        finished ? setStyle("complete") : setStyle("incomplete");
    }, [finished])

    return (
        <div className="todo-card">
            <h1 className={style}>{title}</h1>
            <p className={style}>{description}</p>
            <button onClick={finish}>Check Complete</button>
            <button onClick={remove}>Remove Todo</button>
        </div>
    )

}