const express = require('express');
const bodyParser = require('body-parser')
const api_router = require('./routes/api');
const img_router = require('./images/img_api')

const app = express();

//First Middleware
app.use(bodyParser.json());

//Second Middleware
app.use(bodyParser.urlencoded({extended: true}));

//Third Middleware
app.use('/api',api_router);

//Fourth Middleware
app.use('/img_api',img_router);

//Home Page
app.get('/',(req,res)=>{
    res.send(JSON.stringify("Heelo World"));
});

//Set up the default port
app.set('port',(process.env.Port || 80));

//Listen to port 80
app.listen(app.get('port'),()=>{
    console.log("Listening to port 80");
});