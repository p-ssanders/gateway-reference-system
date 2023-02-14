import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import axios from 'axios';

function App() {
  const [fromServer, setFromServer] = useState(0);
  const getFromServer = function() {
    axios.get('/api/something')
    .then(function (response) {
      setFromServer(response.data.value);
    })
    .catch(function (error) {
      console.log(error);
    })
    .finally(function () {
    });
  }

  return (
    <div className="App">
      <h1>Demo</h1>
      <div className="card">
        <p>
          Make a request to the server
          <button onClick={() => getFromServer()}>
            fromServer is {fromServer}
          </button>
        </p>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      
      </div>
    </div>
  )
}

export default App
