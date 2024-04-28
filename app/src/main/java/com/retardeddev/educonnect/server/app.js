const express = require('express');
const mongoose = require('mongoose');
const userRoutes = require('./userRoutes');
const courseRoutes = require('./courseRoutes');

const app = express();

mongoose.connect('mongodb://localhost:27017/myapp', { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => console.log('Connected to MongoDB'))
    .catch(err => console.error('Error connecting to MongoDB:', err));

app.use(express.json());

app.use('/user', userRoutes);
app.use('/course', courseRoutes);

app.listen(3000, () => console.log('Server is running on port 3000'));