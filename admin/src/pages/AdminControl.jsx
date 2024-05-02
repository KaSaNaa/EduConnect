import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './AdminControl.css'; // Import CSS file for styling

export default function AdminControl() {
    const [courses, setCourses] = useState([]);
    const [loading, setLoading] = useState(true);
    const [searchTerm, setSearchTerm] = useState('');

    useEffect(() => {
        fetchCourses();
    }, []);

    const fetchCourses = async () => {
        try {
            // For now, let's keep it empty as you mentioned it's not connected to the database
            // const response = await axios.get('/api/courses');
            // setCourses(response.data);
            setLoading(false); // Set loading to false after data is fetched
        } catch (error) {
            console.error('Error fetching courses:', error);
            setLoading(false); // Set loading to false in case of error
        }
    };

    const handleSearchChange = (event) => {
        setSearchTerm(event.target.value);
    };

    return (
        <div className="admin-control">
            <h1 className='admin-header'>Admin Control</h1>
            <div className="search-bar">
                <input
                    type="text"
                    placeholder="Search..."
                    value={searchTerm}
                    onChange={handleSearchChange}
                />
                {/* You can add a button for search functionality if needed */}
                {/* <button onClick={handleSearch}>Search</button> */}
            </div>
            <table>
                <thead>
                    <tr>
                        <th>CID</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Commencement</th>
                        <th>Duration</th>
                        <th>Fee</th>
                        <th>Max Participants</th>
                        <th>Branches</th>
                    </tr>
                </thead>
                <tbody>
                    {loading ? ( // Display loading message while data is being fetched
                        <tr>
                            <td colSpan="8">Loading...</td>
                        </tr>
                    ) : (
                        courses
                            .filter(course =>
                                course.title.toLowerCase().includes(searchTerm.toLowerCase()) ||
                                course.description.toLowerCase().includes(searchTerm.toLowerCase())
                            )
                            .map(course => (
                                <tr key={course._id}>
                                    <td>{course.cid}</td>
                                    <td>{course.title}</td>
                                    <td>{course.description}</td>
                                    <td>{course.commencement}</td>
                                    <td>{course.duration}</td>
                                    <td>{course.fee}</td>
                                    <td>{course.maxParticipants}</td>
                                    <td>{course.branches}</td>
                                </tr>
                            ))
                    )}
                    {courses.length === 0 && !loading && ( // Display message if no courses available
                        <tr>
                            <td colSpan="8">No courses available</td>
                        </tr>
                    )}
                </tbody>
            </table>
            <div className="button-row">
                <button className='btn1'>Save</button>
                <button className='btn2'>Add</button>
                <button className='btn3'>Update</button>
                <button className='btn4'>Delete</button>
                
            </div>
        </div>
    );
}
