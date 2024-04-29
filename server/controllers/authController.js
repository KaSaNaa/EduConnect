const { User } = require('../models/models');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const { JWT_SECRET } = require('../configs/config');

exports.signup = async (req, res) => {
    // Hash the password
    const hashedPassword = await bcrypt.hash(req.body.password, BCRYPT_SALT_ROUNDS);

    // Create a new user
    const user = new User({ ...req.body, password: hashedPassword });
    await user.save();

    // Generate a token
    const token = jwt.sign({ id: user._id }, JWT_SECRET, { expiresIn: "1h"});

    res.status(201).json({ user, token });
};

exports.login = async (req, res) => {
    // Find the user
    const user = await User.findOne({ email: req.body.email });

    if (!user) {
        return res.status(400).json({ message: 'Invalid login credentials' });
    }

    // Check the password
    const isPasswordMatch = await bcrypt.compare(req.body.password, user.password);

    if (!isPasswordMatch) {
        return res.status(400).json({ message: 'Invalid login credentials' });
    }

    // Generate a token
    const token = jwt.sign({ id: user._id }, JWT_SECRET, '1h');

    res.json({ user, token });
}

exports.getUser = async (req, res) => {
    // Return the info of signed in user
    res.json(req.user);
};

exports.updateUser = async (req, res) => {
    // Update the user with the request body
    const updatedUser = await User.findByIdAndUpdate(req.user._id, req.body, { new: true });
    res.json(updatedUser);
};

exports.deleteUser = async (req, res) => {
    // Delete the signed in user
    await User.findByIdAndDelete(req.user._id);
    res.json({ message: 'User deleted' });
};