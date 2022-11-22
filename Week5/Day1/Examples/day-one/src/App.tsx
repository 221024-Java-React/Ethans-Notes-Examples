import React from 'react';
import { Welcome } from './Components/Welcome/Welcome';
import { Navbar } from './Components/Navbar/Navbar';

import './App.css';

function App() {
  return (
    <div className="App">
      <Navbar></Navbar>
      <Welcome></Welcome>
    </div>
  );
}

export default App;
