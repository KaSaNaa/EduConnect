import React, { useState } from 'react';
import axios from 'axios';
import './UpdateCource.css'; // Import CSS file for styling

export default function UpdateCourse({ courseId }) {
    const [courseData, setCourseData] = useState({
        title: '',
        description: '',
        commencement: '',
        duration: '',
        fee: '',
        maxParticipants: '',
        branches: [],
    });
    const [isUpdating, setIsUpdating] = useState(false);
    const [updateError, setUpdateError] = useState(null);
    const [updateSuccess, setUpdateSuccess] = useState(null);

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setCourseData({ ...courseData, [name]: value });
    };

    const handleBranchChange = (index, value) => {
        const updatedBranches = [...courseData.branches];
        updatedBranches[index] = value;
        setCourseData({ ...courseData, branches: updatedBranches });
    };

    const handleUpdate = async () => {
        setIsUpdating(true);
        try {
            await axios.patch(`http://localhost:3000/courses/${courseId}`, courseData);
            setUpdateSuccess('Course updated successfully!');
        } catch (error) {
            setUpdateError('Error updating course: ' + error.message);
        } finally {
            setIsUpdating(false);
        }
    };

    return (
        <div className="update-course-container">
            <h2>Update Course</h2>
            {updateSuccess && <div className="success-message">{updateSuccess}</div>}
            {updateError && <div className="error-message">{updateError}</div>}
            <form onSubmit={handleUpdate}>
                <div>
                    <label>Title:</label>
                    <input type="text" name="title" value={courseData.title} onChange={handleInputChange} />
                </div>
                <div>
                    <label>Description:</label>
                    <textarea name="description" value={courseData.description} onChange={handleInputChange} />
                </div>
                <div>
                    <label>Commencement:</label>
                    <input type="date" name="commencement" value={courseData.commencement} onChange={handleInputChange} />
                </div>
                <div>
                    <label>Duration:</label>
                    <input type="text" name="duration" value={courseData.duration} onChange={handleInputChange} />
                </div>
                <div>
                    <label>Fee:</label>
                    <input type="text" name="fee" value={courseData.fee} onChange={handleInputChange} />
                </div>
                <div>
                    <label>Max Participants:</label>
                    <input type="text" name="maxParticipants" value={courseData.maxParticipants} onChange={handleInputChange} />
                </div>
                <div>
                    <label>Branches:</label>
                    {courseData.branches.map((branch, index) => (
                        <input 
                            key={index} 
                            type="text" 
                            value={branch} 
                            onChange={(e) => handleBranchChange(index, e.target.value)} 
                        />
                    ))}
                </div>
                <button type="submit" disabled={isUpdating}>
                    {isUpdating ? 'Updating...' : 'Update Course'}
                </button>
            </form>
        </div>
    );
}
