import React from 'react';
import './App.css';
import { CreateTodo } from './Components/CreateTodo/CreateTodo';
import { TodoContainer } from './Components/TodoContainer/TodoContainer';

function App() {
  return (
    <div className="App">
      <TodoContainer />
    </div>
  );
}

export default App;
