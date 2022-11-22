import React, {useContext, useEffect} from 'react';
import {Todo, ContextState} from '../../Types/Todo';
import { Context } from '../../Context/TodoContext';

import { TodoCard } from '../TodoCard/TodoCard';

export const TodoContainer:React.FC = () => {

    //Get all the todo values to display in our container, from the context
    const {todos} = useContext(Context) as ContextState;

    useEffect(()=>{
        console.log(todos);
    }, [todos, todos.length]);

    return (
        <div className="todo-container">
            {
            todos.map((todo:Todo) => {
                return <TodoCard key={todo.id} id={todo.id} title={todo.title} description={todo.description}
                    finished={todo.finished} />
            })
            }
        </div>
    )
}