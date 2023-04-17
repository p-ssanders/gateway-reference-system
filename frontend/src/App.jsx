import { useState } from 'react'
import './App.css'
import axios from 'axios';

function App() {
  const [data, setData] = useState('(no data yet)');
  const [dataId, setDataId] = useState('(no data id yet)');
  const [dataCount, setDataCount] = useState(0);

  const createData = function() {
    axios.post('/api/')
    .then(function (response) {
      const path = '/api' + new URL(response.headers.location).pathname;
      getData(path);
    })
    .catch(function (error) {
      console.log(error);
    });
  };

  const getData = function(location) {
    axios.get(location)
    .then(function (response) {
      setData(response.data.data);
      setDataId(response.data.id);
      updateDataCount();
    })
    .catch(function (error) {
      console.log(error);
    });
  };

  const updateDataCount = function() {
    axios.get('/api')
    .then(function (response) {
      setDataCount(response.data.count);
    })
    .catch(function (error) {
      console.log(error);
    });
  };


  return (
    <div className="App">
      <h1>Gateway Reference Implementation</h1>
      <div className="card">
        <button onClick={() => createData()}>make a data</button>
        <p>the data: {data}</p>
        <p>the data's id: {dataId}</p>
      </div>
      <div>
        <p>total datas: {dataCount}</p>
      </div>
    </div>
  )
}

export default App
