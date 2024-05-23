const express = require('express');
const path = require('path');
const productRouter = require('../routes/products');
const adminProductRouter = require('../routes/admin_products');

const router = express.Router();

//validacion del Admin
const validateAdmin = (req, res, next) => {
    const authHeader = req.headers['x-auth'];

    if (!authHeader || authHeader != 'admin') {
        return res.status(403).send('Acceso no autorizado, no se cuenta con privilegios de administrador.');
    }
    next(); 
};

// Rutas de productos y admin
router.use('/', productRouter);
router.use('/admin', validateAdmin, adminProductRouter);

// Cosas HTML
router.get('/', (req, res) => {
    res.sendFile(path.resolve(__dirname, '../../frontEnd/views/home.html'));
});
router.get('/home', (req, res) => {
    res.sendFile(path.resolve(__dirname, '../../frontEnd/views/home.html'));
});
router.get('/shopping_cart', (req, res) => {
    res.sendFile(path.resolve(__dirname, '../../frontEnd/views/shopping_cart.html'));
});
router.get('/cat_A', (req, res) => {
    res.sendFile(path.resolve(__dirname, '../../frontEnd/views/cat_A.html'));
});

router.get('/cat_B', (req, res) => {
    res.sendFile(path.resolve(__dirname, '../../frontEnd/views/cat_B.html'));
});

router.get('/about_us', (req, res) => {
    res.sendFile(path.resolve(__dirname, '../../frontEnd/views/about_us.html'));
});

module.exports = router;
