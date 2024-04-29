const nodemailer = require("nodemailer");
const crypto = require("crypto");
const { GMAIL, APP_PASSWORD_GMAIL } = require("../configs/config");
const { User } = require("../models/models");

// Store codes in memory for simplicity
// In a real application, you would store these in your database
const codes = {};

// Step 1: User submits their email
exports.sendCode = async (req, res) => {
  const { email } = req.body;
  const user = await User.findOne({ email });

  if (!user) {
    return res.status(404).send("User not found");
  }

  // Step 2: Generate a unique code and send it to the user's email
  const code = crypto.randomBytes(3).toString("hex");
  codes[email] = code;

  const transporter = nodemailer.createTransport({
    service: "Gmail",
    host: "smtp.gmail.com",
    port: 465,
    secure: true,
    auth: {
      user: GMAIL,
      pass: APP_PASSWORD_GMAIL,
    },
  });
  await transporter.sendMail({
    from: "EduConnect",
    to: email,
    subject: "Your login code",
    html: `
    <h1 style="color: #444;">Welcome to EduConnect</h1>
    <p style="font-size: 16px; color: #666;">Your login code is:</p>
    <p style="font-size: 24px; font-weight: bold; color: #333;">${code}</p>
`,
  });

  res.send("Code sent");
};
