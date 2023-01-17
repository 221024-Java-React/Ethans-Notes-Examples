import React from 'react';
import { Provider } from 'react-redux';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import {store} from './redux/store';
import { LoginPage } from './components/LoginPage/LoginPage';
import './App.css';
import { HomePage } from './components/HomePage/HomePage';

// This is what our modern components, theres still probably nasty class components
// To interact with component lifecylce we use hooks, useEffect, useState, useReducer, you can
// create your own hooks
// Our components typically consist of two files, a .tsx or .js file which holds the structure, and .css file with
// the same name, unless you use something styled components
// Our component itself is a function that returns Jsx/Tsx (Javascript XML), it looks like HTML, however, you have
// to be weary of capitalization, Upper tags are meant to be components, and lowercase tags are meant to be elements
// registering events and classes have slightly different syntax
// Finally we typically will export the component so we can import it in othe places in our code
// Typically something like redux is overkill, but your talking to someone that would but a 1000w PSU for a 3050
function App() {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<LoginPage/>} />
          <Route path="/home" element={<HomePage/>}/>
        </Routes>
      </BrowserRouter>
    </Provider>
  );
}

export default App;
