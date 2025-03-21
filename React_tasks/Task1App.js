
import React, { Component } from "react";

class Task1App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            count: 0,
        };
    }

    // Function to increment count

    increment=(event)=> {
        this.setState((prevState) => ({ count: prevState.count + 1 }));
    };
    
    // Function to decrement count
    decrement = (event) =>  {
        this.setState((prevState) => ({ count: prevState.count - 1 }));
    };

    render() {
        return (
            <div style={{ textAlign: "center", marginTop: "50px" }}>
                <h2>Counter App</h2>
                <h1>{this.state.count}</h1>
                <button onClick={this.increment} style={{ margin: "5px", padding: "10px" }}>Increment</button>
                <button onClick={this.decrement} style={{ margin: "5px", padding: "10px" }}>Decrement</button>
            </div>
        );
    }
}

export default Task1App;
