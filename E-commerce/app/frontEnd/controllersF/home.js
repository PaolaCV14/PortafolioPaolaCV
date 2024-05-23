let l = 0;

function getProductsLength() {
    return new Promise((resolve, reject) => {
        let xhrLength = new XMLHttpRequest(); 
        xhrLength.open('GET', 'http://localhost:3000/products/length');
        xhrLength.send();

        xhrLength.onload = function() {
            if (xhrLength.status == 200) {
                const length = parseInt(xhrLength.responseText);
                console.log('Número total de productos:', length);
                resolve(length);
                l = length;
            } else {
                console.error('Error productos');
                reject(new Error('No se obtuvo el lenght'));
            }
        };
    });
}

getProductsLength()
    .then((length) => {
        console.log('Longitud de los productos:', length);
        console.log('NUM PRODUCTOS: ', l);
    })
    .catch((error) => {
        console.error('Error:', error.message);
    });



let currentPage = 1;

document.addEventListener('DOMContentLoaded', function(){
    console.log('NUM PRODUCTOS: ', l);
    
    const div = document.getElementById('productContainer');
    const div2 = document.getElementById('pagContainer');
    // let url = 'http://localhost:3000/products';
    let xhr = new XMLHttpRequest();
    
    function loadProducts(page) {
        let start = (page-1)*4;
        let end = page*4;
        console.log(start, end);
        let url = `http://localhost:3000/products/pag?start=${start}&end=${end}`;
        // let pEnd = page * 4 -1;
        // let pStart = pEnd - 3;
        xhr.open('GET', url);
        xhr.send();
        
        xhr.onload = function(){
            if(xhr.status == 200){
                let products = JSON.parse(xhr.responseText);
                console.log('product');
                console.table(products);
                let cardsHTML = '';

                for(let i = 0; i < products.length; i++){
                    let product = products[i];
                    console.log('product', product.uuid);
                    if(i % 4 === 0){
                        cardsHTML += '<div class="row">';
                    }
                    cardsHTML += `
                    <div class="col-sm-6 col-md-4 col-lg-3">
                        <div>
                            <div class="card" style="margin:10px; width:100%">
                                <img class="card-img-top" src="${product.imageUrl}" alt="AMREACT">
                                <div class="card-body">
                                    <h4 class="card-title">${product.title}</h4>
                                    <p class="card-text">$${product.price.toLocaleString()}</p>
                                    <button id="addToCartBtn${product.uuid}" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addToCartModal${product.uuid}">
                                        Agregar al carrito
                                    </button>
                                </div>
                            </div>
                            <!-- Modal para seleccionar la cantidad a agregar al carrito -->
                            <div class="modal fade" id="addToCartModal${product.uuid}" tabindex="-1" aria-labelledby="addToCartModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="addToCartModalLabel">Seleccionar cantidad</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                        <label for="quantity">Cantidad:</label>
                                        <input type="number" id="quantity${product.uuid}" name="quantity" min="1" value="1">
                                    </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <button id="addButton${product.uuid}" type="button" class="btn btn-primary" data-custom-attribute=${product.uuid}>Agregar al carrito</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                `;
                

                

                    if ((i + 1) % 4 === 0 || i === products.length - 1) {
                        cardsHTML += '</div>';
                    }                    
                }

                div.innerHTML = cardsHTML;
                let cardsHTML2 = '';
                cardsHTML2 += `<ul id="pagination" class="pagination justify-content-center">`;
                for (let i = 1; i <= Math.ceil(l / 4); i++) {
                    cardsHTML2 += `
                        <li id="page${i}" class="page-item ${i == currentPage ? 'active' : ''}" aria-current="page">
                            <a class="page-link" href="#">${i}</a>
                        </li>
                    `;
                }
                cardsHTML2 += `</ul>`;
                div2.innerHTML = cardsHTML2;
                for (let i = 1; i <= Math.ceil(l / 4); i++) {
                    const pageButton = document.getElementById(`page${i}`);
                    pageButton.addEventListener('click', function(event) {
                        event.preventDefault();
                        loadProducts(i); 
                        console.log('Cargar productos de la página', i);
                        currentPage = i; 
                    });
                }

                for (let i = 0; i < products.length; i++) {
                    const product = products[i];
                    const btnAdd = document.getElementById(`addButton${product.uuid}`);
                    btnAdd.addEventListener('click', function(event){
                        event.preventDefault();
                        console.log('button clicked');
                        let productId = this.dataset.customAttribute;
                        let quantityAdd = document.getElementById(`quantity${productId}`); 
                        let quantity = quantityAdd.value;
                        console.log('ID: ', productId);
                        console.log('CANTIDAD: ', quantity);
                        if(sessionStorage.getItem(productId)){
                            console.log('Si hay producto');
                            let newAmount = sessionStorage.getItem(productId) + quantity;
                            sessionStorage.setItem(productId, newAmount);

                        }
                        else{
                            console.log('no  hay producto');
                            sessionStorage.setItem(productId, quantity);
                        }
                        
                        alert('Producto agregado al carrito de compras.');
                        window.location.href = 'http://localhost:3000/shopping_cart';
                    });}




            }
        }
    }
    
    loadProducts(currentPage);

});
