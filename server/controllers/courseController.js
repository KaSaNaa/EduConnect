const { Course } = require('../models/models');

exports.createCourse = async (req, res) => {
    const course = new Course(req.body);
    try {
        await course.save();
        res.status(201).send(course);
    } catch (error) {
        res.status(400).send(error);
    }
};

exports.getAllCourses = async (req, res) => {
    try {
        const courses = await Course.find({});
        res.send(courses);
    } catch (error) {
        res.status(500).send();
    }
};

exports.getCourseById = async (req, res) => {
    const _id = req.params.id;
    try {
        const course = await Course.findOne({ _id });
        if (!course) {
            return res.status(404).send();
        }
        res.send(course);
    } catch (error) {
        res.status(500).send();
    }
};

exports.updateCourse = async (req, res) => {
    const updates = Object.keys(req.body);
    const allowedUpdates = ['title', 'description', 'commencement', 'duration', 'fee', 'maxParticipants', 'branches'];
    const isValidOperation = updates.every((update) => allowedUpdates.includes(update));

    if (!isValidOperation) {
        return res.status(400).send({ error: 'Invalid updates!' });
    }

    try {
        const course = await Course.findOne({ _id: req.params.id });
        if (!course) {
            return res.status(404).send();
        }

        updates.forEach((update) => course[update] = req.body[update]);
        await course.save();
        res.send(course);
    } catch (error) {
        res.status(400).send(error);
    }
};

exports.deleteCourse = async (req, res) => {
    try {
        const course = await Course.findOneAndDelete({ _id: req.params.id });
        if (!course) {
            return res.status(404).send();
        }
        res.send(course);
    } catch (error) {
        res.status(500).send();
    }
};