const express = require('express');
const api_router = express.Router();

api_router.get('/e_commerce/category_list',(req,res)=>{
    const Category_List = {
        Category_List:[
            {ID:"1001",Title:"Title 1",Description:"Description 1",ImageUrl:"http://192.168.0.53/img_api/img1.jpg"},
            {ID:"1002",Title:"Title 2",Description:"Description 2",ImageUrl:"http://192.168.0.53/img_api/img1.jpg"},
            {ID:"1003",Title:"Title 3",Description:"Description 3",ImageUrl:"http://192.168.0.53/img_api/img1.jpg"},
            {ID:"1004",Title:"Title 4",Description:"Description 4",ImageUrl:"http://192.168.0.53/img_api/img1.jpg"},
            {ID:"1005",Title:"Title 5",Description:"Description 5",ImageUrl:"http://192.168.0.53/img_api/img1.jpg"},
            {ID:"1006",Title:"Title 6",Description:"Description 6",ImageUrl:"http://192.168.0.53/img_api/img1.jpg"}
        ]
    }
    res.send(Category_List);
});

module.exports = api_router;