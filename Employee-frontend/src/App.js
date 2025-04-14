import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './components/Navbar';
import Home from './components/Home';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Adduser from './components/Adduser';
import EditUser from './components/EditUser';

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar/>
        <Routes>
          <Route exact path="/" element={<Home/>} />
          <Route exact path="/adduser" element={<Adduser/>} />
          <Route exact path="/edituser/:id" element={<EditUser/>} />
        </Routes>
      </Router>
      
    </div>
  );
}

export default App;
