import React, {useState, useEffect} from 'react';
import { Todo} from '../../Types/Todo';
import { useDispatch } from 'react-redux';
import { DispatchType } from '../../Redux/Store';
import { updateTodo, removeTodo } from '../../Redux/Slices/TodoSlice';
import './TodoCard.css';

export const TodoCard:React.FC<Todo> = ({id, title, description, finished}) => {

    const dispatch:DispatchType = useDispatch();

    const [style, setStyle] = useState<string>("incomplete");

    const update = () => {
        dispatch(updateTodo(id));
    }

    const remove = () => {
        dispatch(removeTodo(id));
    }
    
    useEffect(()=>{
        finished ? setStyle("complete") : setStyle("incomplete");
    }, [finished])

    return (
        <div className="todo-card">
            <h1 className={style}>{title}</h1>
            <p className={style}>{description}</p>
            <button onClick={update}>Check Complete</button>
            <button onClick={remove}>Remove Todo</button>
        </div>
    )

}