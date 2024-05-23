const express = require('express');
const fs = require('fs');
const router = require('./app/backEnd/controllers/router');
const path = require('path');


const app = express();
const port = 3000;



app.use(express.json());

app.use(express.static('app'));
app.use('/views', express.static('views'));

fs.readFile(path.join(__dirname, 'app/backEnd/data/products.json'), 'utf8', (err, data) => {
    if (err) {
        console.log(('Error:', err));
        return;
    }
    console.log(('Consultando...'));
    const products = JSON.parse(data);
    console.table(products);

    app.use(router);

    app.use((req, res, next) => {
        res.sendStatus(404);
    });

    app.listen(port, () => {
        console.log("Corriendo en puerto " + port);
    })
})

