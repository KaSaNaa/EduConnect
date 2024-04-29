const jwt = require("jsonwebtoken");
const { JWT_SECRET } = require("../configs/config");
const { codes } = require("./emailSender");
const { User } = require("../models/models");

exports.signup = async (req, res) => {
  // Create a new user
  const user = new User(req.body);
  await user.save();

  // Generate a token
  const token = jwt.sign({ id: user._id }, JWT_SECRET, { expiresIn: "1h" });

  res.status(201).json({ user, token });
};

exports.login = async (req, res) => {
  const { email, code } = req.body;
  const user = await User.findOne({ email });

  if (!user) {
    return res.status(404).send('User not found');
  }

  if (codes[email] === code) {
    const token = jwt.sign({ id: user._id }, JWT_SECRET, { expiresIn: "1h" });
    res.json({ token, message: "Logged in" });
  } else {
    res.status(401).send("Invalid code");
  }
};

exports.getUser = async (req, res) => {
  // Return the info of signed in user
  res.json(req.user);
};

exports.updateUser = async (req, res) => {
  // Update the user with the request body
  const updatedUser = await User.findByIdAndUpdate(req.user._id, req.body, {
    new: true,
  });
  res.json(updatedUser);
};

exports.deleteUser = async (req, res) => {
  // Delete the signed in user
  await User.findByIdAndDelete(req.user._id);
  res.json({ message: "User deleted" });
};
