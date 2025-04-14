import React,{useEffect,useState} from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

const Home=()=>{

    const[employees, setEmployees] = useState([]);

    const{id} = useParams();

    useEffect(()=>{
        getEmployeeList(); //Whenever home page renders, load/show the employees list from DB
    },[])

    //load the employee list 
    const getEmployeeList = async () => {
       const response = await axios.get("http://localhost:8081/employees");
       console.log(response);
       setEmployees(response.data);
    }

    const deleteEmployee= async(id)=>{
        await axios.delete(`http://localhost:8081/employee/${id}`);
        getEmployeeList(); //after deleted, load all the employee details 
    }

    return(
        <div className="container">
            <div className="py-4 my-2">
                <table className="table border shadow">
                <thead>
                    <tr>
                    <th scope="col">Id</th>
                    <th scope="col">FirstName</th>
                    <th scope="col">LastName</th>
                    <th scope="col">Email</th>
                    <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        employees.map((obj,index)=>{
                            return(
                                <tr>
                                <th scope="row" key={index}>{index+1}</th>
                                <td>{obj.firstName}</td>
                                <td>{obj.lastName}</td>
                                <td>{obj.emailId}</td>
                                <td>
                                    <Link to="/" className="btn btn-primary mx-2">View</Link>
                                    <Link to={`/editUser/${obj.id}`} className="btn btn-outline-primary mx-2">Edit</Link>
                                    <button className="btn btn-danger mx-2" onClick={()=>deleteEmployee(obj.id)}>Delete</button>
                                </td>
                                </tr>
                            )
                        })
                    }
                  
                </tbody>
                </table>
            </div>
    </div>
    )
}

export default Home;