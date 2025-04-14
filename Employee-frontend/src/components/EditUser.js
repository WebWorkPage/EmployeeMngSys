import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";
import { Link } from "react-router-dom";

const EditUser=()=>{

    let navigate = useNavigate();

    const {id} = useParams(); //returns an obj, destructuring it 

    const[editEmployee, setEditEmployee] = useState({
        FirstName:"",
        LastName:"",
        Email:""
    });

    useEffect(()=>{
        loadEmployee(); //To display the particular employee details on click of edit button
    },[])

    const handleInputChange = (e) => {
        //setAddEmployee({...editEmployee, [e.target.name]:e.target.value})
        setEditEmployee((prevState)=>{
            return {...prevState, [e.target.name]:e.target.value}
        })
    }

    const onSubmit= async(e)=>{
        e.preventDefault();     //to prevent the page from loading on click of submit
        await axios.put(`http://localhost:8081/employee/${id}`,editEmployee);
        navigate("/");        //navigate to Home page on click of submit
    }

    const loadEmployee= async()=>{
        const response = await axios.get(`http://localhost:8081/employee/${id}`);
        console.log(response.data);
        setEditEmployee(response.data);
    }

    return(
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Edit User</h2>

                  <form onSubmit={(e)=>onSubmit(e)}>
                    <div className="mb-3">
                        <label htmlFor="FirstName" className="form-label">FirstName</label>
                        <input type="text" value={editEmployee.FirstName} onChange={(e)=>handleInputChange(e)} className="form-control" name="FirstName" placeholder="enter your first name"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="LastName" className="form-label">LastName</label>
                        <input type="text" value={editEmployee.LastName} onChange={(e)=>handleInputChange(e)} className="form-control" name="LastName" placeholder="enter your last name"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="Email" className="form-label">Email</label>
                        <input type="text" value={editEmployee.Email} onChange={(e)=>handleInputChange(e)} className="form-control" name="Email" placeholder="enter your email Id"/>
                    </div>
                    <button type="submit" className="btn btn-outline-primary ">Submit</button>
                    <Link to="/" className="btn btn-outline-danger mx-2">Cancel</Link>
                  </form>

                </div>
            </div>
        </div>
    )
}

export default EditUser;