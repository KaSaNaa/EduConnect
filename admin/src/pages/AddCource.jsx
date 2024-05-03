import React, { useState } from 'react';
import axios from 'axios';
import './addcource.css'
export default function AddCourse() {
    const [formData, setFormData] = useState({
        title: '',
        description: '',
        commencement: '',
        duration: '',
        fee: '',
        maxParticipants: '',
        branches: ''
    });
    const [successMessage, setSuccessMessage] = useState('');
    
    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            await axios.post('http://localhost:3000/course', formData);
            setSuccessMessage('Course added successfully!');
            setFormData({
                title: '',
                description: '',
                commencement: '',
                duration: '',
                fee: '',
                maxParticipants: '',
                branches: ''
            });
            // You can add additional logic here, like redirecting to another page after successful submission
        } catch (error) {
            console.error('Error adding course:', error);
            // Show error message to the user
        }
    };

    return (
        <div className="add-course-container">
            <h2>Add Course</h2>
            {successMessage && <div className="success-message">{successMessage}</div>}
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Title:</label>
                    <input type="text" name="title" value={formData.title} onChange={handleInputChange} />
                </div>
                <div>
                    <label>Description:</label>
                    <textarea name="description" value={formData.description} onChange={handleInputChange} />
                </div>
                <div>
                    <label>Commencement:</label>
                    <input type="date" name="commencement" value={formData.commencement} onChange={handleInputChange} />
                </div>
                <div>
                    <label>Duration:</label>
                    <input type="text" name="duration" value={formData.duration} onChange={handleInputChange} />
                </div>
                <div>
                    <label>Fee:</label>
                    <input type="text" name="fee" value={formData.fee} onChange={handleInputChange} />
                </div>
                <div>
                    <label>Max Participants:</label>
                    <input type="text" name="maxParticipants" value={formData.maxParticipants} onChange={handleInputChange} />
                </div>
                <div>
                    <label>Branches:</label>
                    <input type="text" name="branches" value={formData.branches} onChange={handleInputChange} />
                </div>
                <button type="submit">Add Course</button>
            </form>
        </div>
    );
}
