import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import axios from "axios";

const ViewUser=()=>{

    const[viewEmployee, setViewEmployee] = useState({
        FirstName:"",
        LastName:"",
        Email:""
    })

    const{id} = useParams();

    useEffect(()=>{
        loadEmployee();
    },[])
    
    //To view/display the particular employee details
    const loadEmployee= async()=>{
        const response = await axios.get(`http://localhost:8081/employee/${id}`);
        setViewEmployee(response.data);
    }

    return(
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Employee Details</h2>

                    <div className="card">
                        <div className="card-header">
                            Details of employee id : {viewEmployee.id}
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">
                                    <b>FirstName:</b>
                                    {viewEmployee.FirstName}
                                </li>
                                <li className="list-group-item">
                                    <b>LastName:</b>
                                    {viewEmployee.LastName}
                                </li>
                                <li className="list-group-item">
                                    <b>Email:</b>
                                    {viewEmployee.Email}
                                </li>
                            </ul>
                        </div>
                    </div>

                    <Link className="btn btn-primary my-2" to={"/"}>Back to Home</Link>
                </div>
            </div>
        </div>
    )
}

export default ViewUser;