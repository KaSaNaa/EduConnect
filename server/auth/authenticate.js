const jwt = require('jsonwebtoken');
const { User } = require('../models/models');
const { JWT_SECRET } = require('../configs/config');

const authenticate = async (req, res, next) => {
    try {
        // Get the token from the Authorization header
        const token = req.headers.authorization.split(' ')[1];
        // Verify the token
        const decoded = jwt.verify(token, JWT_SECRET);
        console.log(decoded);
        // Find the user associated with the token
        const user = await User.findById(decoded.id);
        console.log(user);

        if (!user) {
            throw new Error();
        }

        // Add the user to the request object
        req.user = user;
        next();
    } catch (error) {
        res.status(401).send({ error: 'Please authenticate.' });
    }
};

module.exports = authenticate;