import { useState } from "react";

function SignUp() {
    const [formData, setFormData] = useState({
        customerId: "",
        name: "",
        email: "",
        gender: "",
        city: "Hyderabad",
    });

    const [reviewMode, setReviewMode] = useState(false);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prev) => ({ ...prev, [name]: value }));
    };

    const handleReview = (e) => {
        e.preventDefault();
        setReviewMode(true);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        alert("Customer Registered Successfully!");
        setReviewMode(false);
    };

    return (
        <div >
            <h2 >Customer Signup</h2>

            {!reviewMode ? (
                <form>
                    <label>Customer Id:</label>
                    <input
                        type="number"
                        name="customerId"
                        value={formData.customerId}
                        onChange={handleChange}
                    />

                    <label>Name:</label>
                    <input
                        type="text"
                        name="name"
                        value={formData.name}
                        onChange={handleChange}
                    />

                    <label>Email:</label>
                    <input
                        type="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                    /><br></br>

                    <label>Gender:</label>
                    <div>
                        <input
                            type="radio"
                            id="male"
                            name="gender"
                            value="Male"
                            onChange={handleChange}
                        />
                        <label htmlFor="male">Male</label>

                        <input
                            type="radio"
                            id="female"
                            name="gender"
                            value="Female"
                            onChange={handleChange}
                        />
                        <label htmlFor="female">Female</label>

                        <input
                            type="radio"
                            id="others"
                            name="gender"
                            value="Others"
                            onChange={handleChange}
                        />
                        <label htmlFor="others">Others</label>
                    </div><br></br>

                    <label>City:</label>
                    <select
                        name="city"
                        value={formData.city}
                        onChange={handleChange}
                    >
                        <option value="Hyderabad">Hyderabad</option>
                        <option value="Amaravati">Amaravati</option>
                        <option value="Vijayawada">Vijayawada</option>
                        <option value="Bangalore">Bangalore</option>
                        <option value="Chennai">Chennai</option>
                        <option value="Pune">Pune</option>
                    </select>

                    <button
                        type="button"
                        onClick={handleReview}
                    >
                        Review
                    </button>
                </form>
            ) : (
                <div >
                    <h3 >Review Details</h3>
                    <p><strong>Customer ID:</strong> {formData.customerId}</p>
                    <p><strong>Name:</strong> {formData.name}</p>
                    <p><strong>Email:</strong> {formData.email}</p>
                    <p><strong>Gender:</strong> {formData.gender}</p>
                    <p><strong>City:</strong> {formData.city}</p>

                    <button
                        type="button"
                        onClick={() => setReviewMode(false)}
                    >
                        Edit
                    </button>
                    <button
                        type="submit"
                        onClick={handleSubmit}
                    >
                        Submit
                    </button>
                </div>
            )}
        </div>
    );
}

export default SignUp;
