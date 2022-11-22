import React from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import { Courses } from './Components/Courses/Courses';
import {Login} from './Components/Login/Login';
import { Student } from './Components/Student/Student';
import './App.css';

function App() {
  return (
    //Wrap our entire application in a router
    <BrowserRouter>
      {/* Create the parent container for the routes */}
      <Routes>
        {/* Specify individual routes */}
        <Route path="/login" element={<Login />}/>
        <Route path="/courses" element={<Courses />}/>
        <Route path="/student" element={<Student />}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
