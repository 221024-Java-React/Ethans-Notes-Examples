import React, {useState, useEffect} from 'react';
import { Todo } from '../../Types/Todo';

interface TodoCardProps {
    todo: Todo,
    updateTodo(id:number):void,
    removeTodo(id:number):void
}

export const TodoCard:React.FC<TodoCardProps> = ({todo, updateTodo, removeTodo}) => {

    const finish = () => {
        updateTodo(todo.id);
    }

    const remove = () => {
        removeTodo(todo.id);
    }

    return (
        <div className="todo-card">
            <h1>{todo.title}</h1>
            <p>{todo.description}</p>
            <button onClick={finish}>Check Complete</button>
            <button onClick={remove}>Remove Todo</button>
        </div>
    )

}