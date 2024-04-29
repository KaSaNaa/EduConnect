const { User } = require('../models/models');
const jwt = require('jsonwebtoken');
const { JWT_SECRET } = require('../configs/config');
const { codes } = require('./emailSender');

exports.signup = async (req, res) => {

    // Create a new user
    const user = new User(req.body);
    await user.save();

    // Generate a token
    const token = jwt.sign({ id: user._id }, JWT_SECRET, { expiresIn: "1h"});

    res.status(201).json({ user, token });
};

// exports.login = async (req, res) => {
//     // Find the user
//     const user = await User.findOne({ email: req.body.email });

//     if (!user) {
//         return res.status(400).json({ message: 'Invalid login credentials' });
//     }

//     // Check the password
//     const isPasswordMatch = await bcrypt.compare(req.body.password, user.password);

//     if (!isPasswordMatch) {
//         return res.status(400).json({ message: 'Invalid login credentials' });
//     }

//     // Generate a token
//     let token = jwt.sign({ id: user._id }, JWT_SECRET, {});

//     res.json({ user, token });
// }

exports.login = (req, res) => {
    const { email, code } = req.body;
  
    // Step 4: Verify the code
    if (codes[email] === code) {
      // Code is correct, log in the user
      const token = jwt.sign({ id: User._id }, JWT_SECRET, { expiresIn: '1h' });
      res.json({ token });
    } else {
      // Code is incorrect, send an error
      res.status(401).send('Invalid code');
    }
};

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