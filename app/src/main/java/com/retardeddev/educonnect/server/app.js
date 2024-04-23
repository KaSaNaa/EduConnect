const express = require('express');
const app = express();

app.use(express.json()); // for parsing application/json

// Define routes here
app.get('/user', (req, res) => {
    // Handle GET request
});

app.post('/user', (req, res) => {
    // Handle POST request
});

app.delete('/user', (req, res) => {
    // Handle DELETE request
});

app.put('/user', (req, res) => {
    // Handle PUT request
});

app.get('/course', (req, res) => {
    // Handle GET request
});

app.post('/course', (req, res) => {
    // Handle POST request
});

app.delete('/course', (req, res) => {
    // Handle DELETE request
});

// Start the server
const port = process.env.PORT || 3000;
app.listen(port, () => console.log(`Server is running on port ${port}`));