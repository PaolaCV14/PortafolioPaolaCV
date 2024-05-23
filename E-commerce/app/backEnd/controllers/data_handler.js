const fs = require('fs');
const path = require('path');

const productsFilePath = path.join(__dirname, '../data/products.json');

function getProducts() {
    try {
        const data = fs.readFileSync(productsFilePath, 'utf-8');
        return JSON.parse(data);
    } catch (error) {
        console.error('Error al leer el archivo de productos:', error);
        return [];
    }
}

function saveProducts(products) {
    try {
        fs.writeFileSync(productsFilePath, JSON.stringify(products, null, 2), 'utf-8');
        console.log('Productos guardados');
    } catch (error) {
        console.error('Error al guardar el archivo de productos:', error);
    }
}

function getProductById(uuid) {
    const products = getProducts();
    return products.find(producto => producto.uuid == uuid);
}

function createProduct(product) {
    const products = getProducts();
    products.push(product);
    saveProducts(products);
}

function lenghtProducts(){
    const products = getProducts();
    return products.length;
}


function updateProduct(uuid, updatedProduct) {
    let productFound = false;
    const productos = getProducts();
    productos.forEach(producto => {
        if (producto.uuid == uuid) {
            for (let field in updatedProduct) {
                if (producto.hasOwnProperty(field)) {
                    producto[field] = updatedProduct[field];
                }
            }
            productFound = true;
        }
    });

    if (!productFound) {
        console.log("No existe ese producto");
    }
    saveProducts(productos);
}

function deleteProduct(uuid) {
    const products = getProducts();
    products.forEach((producto, i)=>{
        if(producto.uuid == uuid){
            products.splice(i, 1);
        }
    });
    saveProducts(products);
}


function findProducts(category, title) {
    const products = getProducts();
    if (!category && !title) {
        return [];
    } else if (category && title) {
        return products.filter(product => product.category == category && product.title == title);
    } else if (category) {
        return products.filter(product => product.category == category);
    } else if (title) {
        return products.filter(product => product.title == title);
    }
}


exports.lenghtProducts = lenghtProducts;
exports.getProducts = getProducts;
exports.getProductById = getProductById;
exports.createProduct = createProduct;
exports.updateProduct = updateProduct;
exports.deleteProduct = deleteProduct;
exports.findProducts = findProducts;
