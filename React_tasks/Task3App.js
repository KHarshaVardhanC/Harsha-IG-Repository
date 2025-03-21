

//3.Create application to send number1,number2 values read from form in  App component  
// and send to  child Calculator component  and perform sum,diff,product calculations and display  results. 





import { useState } from "react";

function Task3App() {
  const [number1, setNumber1] = useState(0);
  const [number2, setNumber2] = useState(0);

  return (
    <div>
      <h2 >Calculator App</h2>
      
      <input
        type="number"
        value={number1}
        onChange={(e) => setNumber1(Number(e.target.value))} 
        placeholder="Enter first number"
        
      />
      
      <input
        type="number"
        value={number2}
        onChange={(e) => setNumber2(Number(e.target.value))} 
        placeholder="Enter second number"
      />
      
      <Calculator number1={number1} number2={number2} />
    </div>
  );
}

function Calculator({ number1, number2 }) {
  const sum = number1 + number2;
  const diff = number1 - number2;
  const product = number1 * number2;

  return (
    <div >
      <h3 >Results:</h3>
      <p>Sum: {sum}</p>
      <p>Difference: {diff}</p>
      <p>Product: {product}</p>
    </div>
  );
}

export default Task3App;
