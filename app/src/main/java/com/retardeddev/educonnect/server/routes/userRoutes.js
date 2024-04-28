const express = require('express');
const router = express.Router();
const { User } = require('../models/models');

// Middleware for authentication
const authenticate = require('../auth/authenticate');

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

router.put('/', authenticate, async (req, res) => {
    // Replace the user with the request body
    const replacedUser = await User.findByIdAndUpdate(req.user._id, req.body, { new: true, overwrite: true });
    res.json(replacedUser);
});

module.exports = router;