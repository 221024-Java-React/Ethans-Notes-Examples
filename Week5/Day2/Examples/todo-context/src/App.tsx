import React from 'react';
import { TodoProvider } from './Context/TodoContext';
import { CreateTodo } from './Components/CreateTodo/CreateTodo';

import './App.css';
import { TodoContainer } from './Components/TodoContainer/TodoContainer';

function App() {
  return (
    //Wrap the entire application inside of the TodoProvider, now then entire application has access to the todos
    //and the functions to modify the list of todos
    //To access the context inside of one of these components, we use the useContext hook
    <TodoProvider>
      <div className="App">
        <CreateTodo />
        <TodoContainer />
      </div>
    </TodoProvider>
  );
}

export default App;
