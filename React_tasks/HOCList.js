import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";

// Higher-Order Component to wrap any list
const withTable = (WrappedComponent, columns) => {
  return (props) => (
    <div className="container mt-3">
      <h3>{props.title}</h3>
      <table className="table table-bordered">
        <thead>
          <tr>
            {columns.map((col, index) => (
              <th key={index}>{col}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          <WrappedComponent {...props} />
        </tbody>
      </table>
    </div>
  );
};

// Product List Component
const ProductList = ({ data }) => (
  <>
    {data.map((product, index) => (
      <tr key={index}>
        <td>{product.id}</td>
        <td>{product.name}</td>
        <td>{product.price}</td>
      </tr>
    ))}
  </>
);

// Employee List Component
const EmployeeList = ({ data }) => (
  <>
    {data.map((employee, index) => (
      <tr key={index}>
        <td>{employee.id}</td>
        <td>{employee.name}</td>
        <td>{employee.department}</td>
      </tr>
    ))}
  </>
);

const ProductTable = withTable(ProductList, ["ID", "Name", "Price"]);
const EmployeeTable = withTable(EmployeeList, ["ID", "Name", "Department"]);

const HOCList = () => {
  const products = [
    { id: 1, name: "Laptop", price: "$1000" },
    { id: 2, name: "Phone", price: "$500" },
  ];

  const employees = [
    { id: 1, name: "Alice", department: "HR" },
    { id: 2, name: "Bob", department: "IT" },
  ];

  return (
    <div>
      <ProductTable title="Product List" data={products} />
      <EmployeeTable title="Employee List" data={employees} />
    </div>
  );
};

export default HOCList;
