const express = require('express');
const router = express.Router();
const authenticate = require('../auth/authenticate');
const { signup, login, getUser, updateUser, deleteUser } = require('../controllers/authController');
const { sendCode } = require('../controllers/emailSender');

router.post('/signup', signup);

router.post('/login', login);
router.post('/sendcode', sendCode)

router.get('/', authenticate, getUser);

router.post('/', authenticate, updateUser);

router.delete('/', authenticate, deleteUser);

module.exports = router;