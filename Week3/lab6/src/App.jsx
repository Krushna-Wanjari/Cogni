import React from 'react';
import {Home} from './Components/Home';
import {Login} from './Components/Login'

function App(){
  return(
      <div className='Container'>
        <Home/>
        <Login/>
      </div>
  );
}

export default App;