const express = require('express');
const api_router = express.Router();

api_router.get('/e_commerce/category_list',(req,res)=>{
    const Category_List = {
        Category_List:[
            {ID:"1001",Title:"Title 1",Description:"Description 1",ImageUrl:"http://192.168.0.53/img_api/img1.jpg"},
            {ID:"1001",Title:"Title 1",Description:"Description 1",ImageUrl:"http://192.168.0.53/img_api/img1.jpg"},
            {ID:"1001",Title:"Title 1",Description:"Description 1",ImageUrl:"http://192.168.0.53/img_api/img1.jpg"},
            {ID:"1001",Title:"Title 1",Description:"Description 1",ImageUrl:"http://192.168.0.53/img_api/img1.jpg"},
            {ID:"1001",Title:"Title 1",Description:"Description 1",ImageUrl:"http://192.168.0.53/img_api/img1.jpg"},
            {ID:"1001",Title:"Title 1",Description:"Description 1",ImageUrl:"http://192.168.0.53/img_api/img1.jpg"}
        ]
    }
    res.send(Category_List);
});

module.exports = api_router;