const express = require('express');
const img_router = express.Router();
const fs = require('fs');

img_router.get("/:imgID",(req,res)=>{
    const imgID = req.params.imgID;
    console.log("To Be Retrieved Image: " + imgID);
    res.writeHead(200, {'Content-Type':'image/jpeg'});
    //Create data, which will be send with response
    //in this case it is image
    var readStream = fs.createReadStream(__dirname + '/img_storage/'+imgID);
    readStream.pipe(res); //Sending response
});

module.exports = img_router;