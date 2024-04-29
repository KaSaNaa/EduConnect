const express = require('express');
const router = express.Router();
const { Course } = require('../models/models');

// Middleware for authentication
const authenticate = require('../auth/authenticate');

router.get('/', authenticate, async (req, res) => {
    // Get all courses for the signed in user
    const courses = await Course.find({ userId: req.user._id });
    res.json(courses);
});

router.post('/', authenticate, async (req, res) => {
    // Create a new course for the signed in user
    const course = new Course({ ...req.body, userId: req.user._id });
    await course.save();
    res.status(201).json(course);
});

router.delete('/:id', authenticate, async (req, res) => {
    // Delete a course of the signed in user
    const course = await Course.findOne({ _id: req.params.id, userId: req.user._id });

    if (!course) {
        return res.status(404).json({ message: 'Course not found' });
    }

    await course.remove();
    res.json({ message: 'Course deleted' });
});

module.exports = router;