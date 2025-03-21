import React from "react";

// Child Component
const MobileDetails = ({ id, model, price }) => {
  return (
    <div style={{ border: "1px solid #ccc", padding: "10px", margin: "10px", borderRadius: "5px" }}>
      <h3>Model: {model}</h3>
      <p>ID: {id}</p>
      <p>Price: ${price}</p>
    </div>
  );
};

// Parent Component
const MobileList = () => {
  const mobiles = [
    { id: 1, model: "iPhone 13", price: 999 },
    { id: 2, model: "Samsung Galaxy S22", price: 899 },
    { id: 3, model: "OnePlus 10", price: 749 },
  ];

  return (
    <div style={{ textAlign: "center", marginTop: "20px" }}>
      <h2>Mobile Details</h2>
      {mobiles.map((mobile) => (
        <MobileDetails key={mobile.id} id={mobile.id} model={mobile.model} price={mobile.price} />
      ))}
    </div>
  );
};

export default MobileList;
 
