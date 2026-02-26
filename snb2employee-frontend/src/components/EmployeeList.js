import React, { useEffect, useState } from "react";
import axios from "axios";

function EmployeeList() {

  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/employees")
      .then(res => setEmployees(res.data))
      .catch(err => console.error(err));
  }, []);

  const deleteEmployee = (id) => {
    axios.delete(`http://localhost:8080/api/employees/${id}`)
      .then(() => {
        setEmployees(employees.filter(emp => emp.id !== id));
      });
  };

  return (
    <div>
      <h2>Employee List</h2>
      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Salary</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {employees.map(emp => (
            <tr key={emp.id}>
              <td>{emp.id}</td>
              <td>{emp.name}</td>
              <td>{emp.email}</td>
              <td>{emp.salary}</td>
              <td>
                <button onClick={() => deleteEmployee(emp.id)}>
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default EmployeeList;