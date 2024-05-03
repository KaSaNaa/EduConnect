const mongoose = require('mongoose');
const AutoIncrement = require('mongoose-sequence')(mongoose);

const UserSchema = new mongoose.Schema({
    uid: { type: Number },
    username: { type: String, required: true },
    fullName: { type: String, required: true},
    address: { type: String, required: true},
    city: { type: String, required: true},
    nic: { type: String, required: true},
    email: { type: String, required: true },
    phoneNumber: { type: String, required: true },
    gender: { type: Boolean, required: true},
    dob: { type: String, required: true}
});

UserSchema.plugin(AutoIncrement, {inc_field: 'uid'});

const CourseSchema = new mongoose.Schema({
    cid: { type: Number },
    title: { type: String, required: true },
    description: { type: String, required: true },
    commencement: { type: String, required: true },
    duration: { type: String, required: true },
    fee: { type: String, required: true },
    maxParticipants: { type: Number, required: true },
    branches: [{ type: String, required: true }],
});

CourseSchema.plugin(AutoIncrement, {inc_field: 'cid'});

const Course = mongoose.model('Course', CourseSchema);
const User = mongoose.model('User', UserSchema);

module.exports = { User, Course }