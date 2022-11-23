import React, {useState, useEffect} from 'react';
import { TodoCard } from './Components/TodoCard/TodoCard';
import { CreateTodo } from './Components/CreateTodo/CreateTodo';
import './App.css';
import { Todo } from './Types/Todo';

function App() {

  const [state, setState] = useState<Todo[]>([]);

  const addTodo = (todo:Todo) => {
    setState([...state, todo]);
  }

  const updateTodo = (id: number) => {
    console.log("updating a todo");

    state.filter((todo:Todo) => {
        if(todo.id === id){
            todo.finished = !todo.finished;
            setState([...state])
        }
    });
  }

  const removeTodo = (id:number) => {
    console.log("removing a todo");

    setState(state.filter((todo:Todo) => todo.id !== id));
  }


  return (
    <div className="App">
      <h1>Todo List</h1>
      <CreateTodo create={addTodo}/>
      {state.map((todo) => {
        return <TodoCard todo={todo} removeTodo={removeTodo} updateTodo={updateTodo} />
      })}
    </div>
  );
}

export default App;
