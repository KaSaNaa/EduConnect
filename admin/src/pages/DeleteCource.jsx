import React, { useState } from 'react';
import axios from 'axios';
import './deletecource.css'; // Import CSS file for styling

export default function DeleteCourse() {
    const [courseId, setCourseId] = useState('');
    const [isDeleting, setIsDeleting] = useState(false);
    const [deleteError, setDeleteError] = useState(null);
    const [deleteSuccess, setDeleteSuccess] = useState(null);

    const handleInputChange = (event) => {
        setCourseId(event.target.value);
    };

    const handleDelete = async () => {
        setIsDeleting(true);
        try {
            await axios.delete(`http://localhost:3000/course/${courseId}`);
            setDeleteSuccess('Course deleted successfully!');
            setCourseId('');
        } catch (error) {
            setDeleteError('Error deleting course: ' + error.message);
        } finally {
            setIsDeleting(false);
        }
    };

    return (
        <div className="delete-course-container">
            <h2>Delete Course</h2>
            {deleteSuccess && <div className="success-message">{deleteSuccess}</div>}
            {deleteError && <div className="error-message">{deleteError}</div>}
            <input
                type="text"
                placeholder="Enter Course ID"
                value={courseId}
                onChange={handleInputChange}
            />
            <button className="delete-button" onClick={handleDelete} disabled={isDeleting || !courseId}>
                {isDeleting ? 'Deleting...' : 'Delete Course'}
            </button>
        </div>
    );
}
