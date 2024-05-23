document.addEventListener('DOMContentLoaded', function() {
    const xhr = new XMLHttpRequest();
    const url = 'http://localhost:3000/products/cart';
    const data = [];
    for (let i = 0; i < sessionStorage.length; i++) {
        let id = sessionStorage.key(i);
        let amount = parseInt(sessionStorage.getItem(id));
        data.push({ uuid: id, quantity: amount });
    }

    xhr.open('POST', url);
    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.onload = function() {
        if (xhr.status >= 200 && xhr.status < 300) {
            console.log('Jalo Request');
            const response = JSON.parse(xhr.responseText);
            console.log('Response:', response);
            let cartCardsHTML = '';

            cartCardsHTML += `
            <div class="row justify-content-center align-items-start">
                <div class="col-lg-8 col-md-12 col-sm-12">
            `;
            if (Array.isArray(response)) {
                console.log('Number of products:', response.length);

                response.forEach(item => {
                    const product = item.product; 
                    const proxy = item.quantity;
                    console.log('Product:', product);
                    console.log('X producto', product.title);
                    console.log('X queantity', proxy);

                    const cardId = `removeCart${product.uuid}`; 
                    const editId = `editCart${product.uuid}`; 
                    const inputId = `quantityInput${product.uuid}`;

                    cartCardsHTML += `
                        <div class="media border p-3">
                            <div class="media-body">
                                <h4>${product.title} <small><button id="${cardId}" class="no-outline"><i class="fa-solid fa-trash"></i></button></small></h4>
                                <div class="input-group mb-3" >
                                    <span class="input-group-text" id="inputGroup-sizing-default">Cantidad:
                                    <input type="number" id="${inputId}" class="form-control custom-input" aria-label="Dollar amount (with dot and two decimal places)" value="${proxy}" readonly>
                                    <small><button id="${editId}" class="no-outline"><i class="fa-solid fa-pen"></i></button></small>
                                    </span>
                                </div>
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Precio:</span>
                                    <input type="text" class="form-control custom-input" aria-label="Precio" value="$${product.price.toLocaleString()}" readonly>
                                    <span class="input-group-text">MXN</span>
                                </div>
                            </div>
                            <img src="${product.imageUrl}" alt="${product.title}" class="ml-3 mt-3 " style="width:100px;">
                        </div>
                    `;
                });
                
            } else {
                console.log('No products found in response');
            }
            let total = 0;

            cartCardsHTML += `
            </div>
            <div class="col-lg-4 col-md-12 col-sm-12">
                <div class="media border p-3">
                    <div class="media-body">
                        <h1>Total</h1>`;
            
            response.forEach(item => {
                const product = item.product; 
                const proxy = item.quantity;
                total = total + (proxy * product.price);
                cartCardsHTML += `
                <h4>${product.title} <small><i>$${product.price.toLocaleString()} x ${proxy}</i></small></h4><br>
                `;
            });
            console.log(total);

            
            
            cartCardsHTML += `
                        <h2>TOTAL: $${total.toLocaleString()}</h2>
                        <div class="text-center">
                            <br>
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                Pagar
                            </button><br><br>
                            <button type="button" class="btn btn-danger">Cancelar</button>
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">!Gracias por su compra!</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">x</button>
                                        </div>
                                        <div class="modal-body">
                                            Su entrega llegará en 10 días hábiles.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Entendido</button>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div> 
                        </div>
                    </div>
            </div>
        </div>
            `;
            const shoppingCartContainer = document.getElementById('containerCart');
            shoppingCartContainer.innerHTML = cartCardsHTML;

            response.forEach(item => {
                const product = item.product;
                const removeButton = document.getElementById(`removeCart${product.uuid}`);
                if (removeButton) {
                    removeButton.addEventListener('click', function() {
                        sessionStorage.removeItem(product.uuid);
                        window.location.reload();
                        console.log(`Eliminar producto ${product.title}`);
                    });
                }
            });

            response.forEach(item => {
                const product = item.product;
                const proxy = item.quantity;
                const editButton = document.getElementById(`editCart${product.uuid}`);
                const input = document.getElementById(`quantityInput${product.uuid}`);
                input.setAttribute('min', '0');
                const cancelButton = document.createElement('button');
                const confirmButton = document.createElement('button');
                
                if (editButton) {
                    editButton.addEventListener('click', function() {
                        console.log(`Editar producto ${product.title}`);

                        input.readOnly = false;
                        cancelButton.innerHTML = '<i class="fa-solid fa-times" style="color: #ee1111;"></i>'; 
                        confirmButton.innerHTML = '<i class="fa-solid fa-check" style="color: #13d110;"></i>'; 

                        cancelButton.addEventListener('click', function() {
                            window.location.reload();
                            console.log(input.value);
                            console.log('Edición cancelada');
                        });
            
                        confirmButton.addEventListener('click', function() {
                            console.log('Edición confirmada');
                            console.log(input.value);
                            if(input.value == 0){
                                sessionStorage.removeItem(product.uuid);
                                console.log('here');
                                alert('Producto eliminado');
                            }
                            else{
                                sessionStorage.setItem(product.uuid, input.value);
                                alert('Cantidad modificada');
                            }
                            
                           window.location.reload();
                           
                        });
            
                        const buttonContainer = editButton.parentElement;
                        buttonContainer.replaceChild(cancelButton, editButton);
                        buttonContainer.appendChild(confirmButton);
                    });
                }
            });
            
            
        } else {
            console.error('No jalo request:', xhr.status);
        }
    };

    xhr.onerror = function() {
        console.error('No jalo request');
    };

    xhr.send(JSON.stringify(data));
});
