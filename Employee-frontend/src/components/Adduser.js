import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { Link } from "react-router-dom";

const Adduser=()=>{

    let navigate = useNavigate();

    const[addEmployee, setAddEmployee] = useState({
        FirstName:"",
        LastName:"",
        Email:""
    });

    const handleInputChange = (e) => {
        //setAddEmployee({...addEmployee, [e.target.name]:e.target.value})
        setAddEmployee((prevState)=>{
            return {...prevState, [e.target.name]:e.target.value}
        })
    }

    const onSubmit= async(e)=>{
        e.preventDefault();     //to prevent the page from loading on click of submit
        await axios.post("http://localhost:8081/employee",addEmployee);
        navigate("/");        //navigate to Home page on click of submit
    }

    return(
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Register User</h2>

                  <form onSubmit={(e)=>onSubmit(e)}>
                    <div className="mb-3">
                        <label htmlFor="FirstName" className="form-label">FirstName</label>
                        <input type="text" value={addEmployee.FirstName} onChange={(e)=>handleInputChange(e)} className="form-control" name="FirstName" placeholder="enter your first name"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="LastName" className="form-label">LastName</label>
                        <input type="text" value={addEmployee.LastName} onChange={(e)=>handleInputChange(e)} className="form-control" name="LastName" placeholder="enter your last name"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="Email" className="form-label">Email</label>
                        <input type="email" value={addEmployee.Email} onChange={(e)=>handleInputChange(e)} className="form-control" name="Email" placeholder="enter your email Id"/>
                    </div>
                    <button type="submit" className="btn btn-outline-primary ">Submit</button>
                    <Link to="/" className="btn btn-outline-danger mx-2">Cancel</Link>
                  </form>

                </div>
            </div>
        </div>
    )
}

export default Adduser;