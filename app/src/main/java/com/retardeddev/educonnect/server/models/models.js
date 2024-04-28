const mongoose = require('mongoose');

const UserSchema = new mongoose.Schema({
    username: { type: String, required: true },
    email: { type: String, required: true },
    password: { type: String, required: true }
});

const CourseSchema = new mongoose.Schema({
    title: { type: String, required: true },
    description: { type: String, required: true },
    commencement: { type: String, required: true },
    duration: { type: String, required: true },
    fee: { type: String, required: true },
    maxParticipants: { type: Number, required: true },
    branches: { type: String, required: true },
    registrationClosing: { type: String, required: true }
});

const User = mongoose.model('User', UserSchema);
const Course = mongoose.model('Course', CourseSchema);

module.exports = { User, Course };