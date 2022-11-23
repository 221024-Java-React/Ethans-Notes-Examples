import React, {useEffect} from 'react';
import {Todo} from '../../Types/Todo';
import { useSelector } from 'react-redux';
import { RootState } from '../../Redux/Store';
import { CreateTodo } from '../CreateTodo/CreateTodo';
import { TodoCard } from '../TodoCard/TodoCard';
import { Login } from '../Login/Login';

export const TodoContainer:React.FC = () => {

    //Get the todo state from our store using useSelector
    const state = useSelector((state:RootState) => state);

    useEffect(()=>{
        /*
            if(localstore.get("userid")) dispatch(getUserInfo(id))
            else push to login
        */
        console.log("State changed in the store ", state);
    }, [state]);

    return (
        <div className="todo-container">
            {state.user.user ? <h1>Welcome {state.user.user.firstName}</h1> : <Login />}
            <CreateTodo />
            {
                state.todo.todos.map((todo:Todo) => {
                    return <TodoCard key={todo.id} id={todo.id} title={todo.title} description={todo.description}
                        finished={todo.finished} />
                })
            }
        </div>
    )
}