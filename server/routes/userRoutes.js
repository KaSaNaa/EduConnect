const express = require('express');
const router = express.Router();
const { User } = require('../models/models');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const { BCRYPT_SALT_ROUNDS, JWT_SECRET, JWT_EXPIRATION } = require('../configs/config');

// Middleware for authentication
const authenticate = require('../auth/authenticate');
router.post('/signup', async (req, res) => {
    // Hash the password
    const hashedPassword = await bcrypt.hash(req.body.password, BCRYPT_SALT_ROUNDS);

    // Create a new user
    const user = new User({ ...req.body, password: hashedPassword });
    await user.save();

    // Generate a token
    const token = jwt.sign({ id: user._id }, JWT_SECRET);

    res.status(201).json({ user, token });
});

router.post('/login', async (req, res) => {
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
    const token = jwt.sign({ id: user._id }, JWT_SECRET, JWT_EXPIRATION);

    res.json({ user, token });
});

router.get('/', authenticate, async (req, res) => {
    // Return the info of signed in user
    res.json(req.user);
});

router.post('/', authenticate, async (req, res) => {
    // Update the user with the request body
    const updatedUser = await User.findByIdAndUpdate(req.user._id, req.body, { new: true });
    res.json(updatedUser);
});

router.delete('/', authenticate, async (req, res) => {
    // Delete the signed in user
    await User.findByIdAndDelete(req.user._id);
    res.json({ message: 'User deleted' });
});

module.exports = router;