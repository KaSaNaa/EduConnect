import React, { useState } from 'react';
import './UpdateUser.css'
export default function UpdateUsers() {
    const [courseData, setCourseData] = useState({
        courseId: '',
        title: '',
        description: '',
        commencement: '',
        duration: '',
        fee: '',
        maxParticipants: '',
        branches: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setCourseData({
            ...courseData,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // Add your logic to handle form submission here
        console.log(courseData);
    };

  return (
    <div className="container">
    <h2>Update Course</h2>
    <form onSubmit={handleSubmit}>
        <div className="input-group">
            <label htmlFor="courseId">Course ID:</label>
            <input type="text" id="courseId" name="courseId" value={courseData.courseId} onChange={handleChange} />
        </div>
        <div className="input-group">
            <label htmlFor="title">Title:</label>
            <input type="text" id="title" name="title" value={courseData.title} onChange={handleChange} />
        </div>
        <div className="input-group">
            <label htmlFor="description">Description:</label>
            <textarea id="description" name="description" value={courseData.description} onChange={handleChange} rows="4"></textarea>
        </div>
        <div className="input-group">
            <label htmlFor="commencement">Commencement:</label>
            <input type="date" id="commencement" name="commencement" value={courseData.commencement} onChange={handleChange} />
        </div>
        <div className="input-group">
            <label htmlFor="duration">Duration:</label>
            <input type="text" id="duration" name="duration" value={courseData.duration} onChange={handleChange} />
        </div>
        <div className="input-group">
            <label htmlFor="fee">Fee:</label>
            <input type="text" id="fee" name="fee" value={courseData.fee} onChange={handleChange} />
        </div>
        <div className="input-group">
            <label htmlFor="maxParticipants">Max Participants:</label>
            <input type="number" id="maxParticipants" name="maxParticipants" min="0" value={courseData.maxParticipants} onChange={handleChange} />
        </div>
        <div className="input-group">
            <label htmlFor="branches">Branches:</label>
            <input type="text" id="branches" name="branches" value={courseData.branches} onChange={handleChange} />
        </div>
        <button type="submit" className="btn">Update</button>
    </form>
</div>
  )
}
