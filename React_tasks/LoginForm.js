import { useState } from "react";


function LoginForm(){

    const [Id, setId]= useState("");
    const [Password, setPassword]= useState("");

    const handleSubmit = (e) => {
        e.preventDefault(); // Prevents page reload
    
        if (Id === "iguser" && Password === "password") {
          alert("Valid User");
        } else {
          alert("Invalid User");
        }
      };
    return(
        <div>
            <form onSubmit={handleSubmit}> 

            <label for="Id">Id: </label>
            <input type="text" placeholder="Enter Id" value={Id} onChange={(e) => setId(e.target.value)}   />
            <label for="Password">Password: </label>
            <input type="password" placeholder="Enter Password" value={Password} onChange={(e) => setPassword(e.target.value)}   />

            <button type="submit">Login</button>
            </form>

        </div>
    )
}

export default LoginForm;