const express = require('express');
const router = express.Router();
const dataHandler = require('../controllers/data_handler');


router.get('/products/pag', (req, res) => {
    const{start, end} = req.query;
    if(!start && !end){
        return res.status(400).json({ error: 'Nel'});
    }

    const productsByPag = [];
    const products = dataHandler.getProducts();

    for(let i = start; i < Math.min(end, products.length); i++){
        productsByPag.push(products[i]);
    }
    console.log(productsByPag);
    res.json(productsByPag);
});


router.get('/products/filter', (req, res) => {
    const { category, title } = req.query;

    if (!category && !title) {
        return res.status(400).json({ error: 'Se requiere al menos un parámetro de filtro.' });
    }

    const products = dataHandler.findProducts(category, title);
    if (products.length > 0) {
        res.json(products);
    } else {
        let p = dataHandler.getProducts();
        res.status(404).json({ error: 'No se encontraron productos que coincidan con los filtros proporcionados.' });
    }
});

router.post('/products/cart', (req, res) => {
    const body = req.body;
    if (!Array.isArray(body)) {
        return res.status(400).json({ error: 'El cuerpo de la solicitud debe ser un arreglo' });
    }
    const cart = [];
    const products = dataHandler.getProducts();

    
    for (const element of body) {
        const productId = element.uuid;
        const quantity = element.quantity;
        const product = dataHandler.getProductById(productId);
        if (!product) {
            return res.status(404).json({ error: `Producto con UUID ${productId} no encontrado.` });
        }
        cart.push({product, quantity });
    }
    res.header('Content-Type', 'application/json');
    res.status(200).json(cart);
});

router.get('/products/length', (req, res)=>{
    const l = dataHandler.lenghtProducts();
    res.json(l);
});

router.get('/products/:id', (req, res) => {
    const productId = req.params.id;
    const product = dataHandler.getProductById(productId);

    if (!product) {
        return res.status(404).json({ error: `Producti con id ${productId} no encontrado.` });
    }

    res.json(product);
});





module.exports = router;