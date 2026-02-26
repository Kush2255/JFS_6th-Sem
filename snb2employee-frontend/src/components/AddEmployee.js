import React, { useState } from "react";
import axios from "axios";

function AddEmployee() {

  const [employee, setEmployee] = useState({
    name: "",
    email: "",
    salary: ""
  });

  const handleChange = (e) => {
    setEmployee({ ...employee, [e.target.name]: e.target.value });
  };

  const saveEmployee = (e) => {
    e.preventDefault();

    axios.post("http://localhost:8080/api/employees", employee)
      .then(() => {
        alert("Employee Added");
        window.location.reload(); // refresh list
      })
      .catch(err => console.error(err));
  };

  return (
    <div>
      <h2>Add Employee</h2>
      <form onSubmit={saveEmployee}>
        <input type="text" name="name" placeholder="Name" onChange={handleChange} required />
        <input type="email" name="email" placeholder="Email" onChange={handleChange} required />
        <input type="number" name="salary" placeholder="Salary" onChange={handleChange} required />
        <button type="submit">Save</button>
      </form>
    </div>
  );
}

export default AddEmployee;