const express = require('express');
const router = express.Router();
const dataHandler = require('../controllers/data_handler');

router.post('/products', (req, res) => {
    try {
        const { uuid, title, description, imageUrl, unit, stock, price, category } = req.body;
        const np = [];
        if(!uuid) np.push('uuid');
        if (!title) np.push('title');
        if (!description) np.push('description');
        if (!imageUrl) np.push('imageUrl');
        if (!unit) np.push('unit');
        if (!stock) np.push('stock');
        if (!price) np.push('price');
        if (!category) np.push('category');
        if (np.length > 0) {
            res.status(400).json({ error: `Los siguientes atributos son obligatorios: ${np.join(', ')}` });
            return; 
        }
        console.log(np);
        const newProduct = {
            uuid,
            title,
            description,
            imageUrl,
            unit,
            stock,
            price,
            category
        };
        console.log(newProduct);
        dataHandler.createProduct(newProduct);
        res.status(201).json({ message:  title  });
    } catch (error) {
        console.error('Error al procesar la solicitud:', error);
        res.status(500).json({ error: 'Ocurrió un error al procesar la solicitud.' });
    }
});

router.put('/products/:uuid', (req, res) => {
	const uuid = req.params.uuid;
    
	const product = dataHandler.getProductById(uuid);
	if (product) {
		const updatedProduct = req.body;
		dataHandler.updateProduct(uuid, updatedProduct);
		res.json({ message: 'Producto actualizado' });
	}
	else {
		res.status(404).json({ error: 'Producto no encontrado' });
	}
});

router.delete('/products/:uuid', (req, res) => {
	const uuid = req.params.uuid;
	const product = dataHandler.getProductById(uuid);
	if (product) {
		dataHandler.deleteProduct(uuid);
		res.json({ message: 'Producto eliminado' });
	}
	else {
		res.status(404).json({ error: 'Producto no encontrado' });
	}
})



module.exports = router;
