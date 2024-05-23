class ShoppingCartException{
    constructor(errorMessage){
        this.errorMessage = errorMessage;
    }
}
class ShoppingCart{
    constructor(){
        this._proxies = [];
        this._products = [];
    }
    set proxies(x){
        throw new ShoppingCartException("No puede modificar la lista de proxies.");
    }
    get proxies(){
        return this._proxies;
    }

    set products(x){
        throw new ShoppingCartException("No puedes modificar la,lista de productos.");
    }

    get products(){
        return this._products;
    }
    addItem(productUuid, amount) {
        let encontrado = false;
        for(let i =0; i < this.proxies.length; i++){
            if(this.proxies[i]._uuid == productUuid){
                this.proxies[i]._cantidad += amount;
                encontrado = true;
                break;
            }
            
        }
        if(!encontrado){
            let nuevoProxy = new ProductProxy(productUuid, amount);
            this.proxies.push(nuevoProxy);
            let p = getProductById(productUuid);
            this.products.push(p);
        }   
    }

    updateItem(productUuid, newAmount){
        let encontrado = false;
        for(let i =0; i < this.proxies.length; i++){
            if(this.proxies[i]._uuid == productUuid){
                let newCantidad = this.proxies[i]._cantidad + newAmount;
                if(newCantidad > 0 ){
                    this.proxies[i]._cantidad = newCantidad;
                }
                else if(newCantidad == 0){
                    this.removeItem(productUuid);
                }
                else{
                    throw new ShoppingCartException("No se puede tener menos de 0");
                }
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            throw new ShoppingCartException("No se ha enontrado el producto a actualizar");
        }
    }

    removeItem(productUuid){
        let encontrado = false;
        for(let i =0; i < this.proxies.length; i++){
            if(this.proxies[i]._uuid == productUuid){
                this.proxies.splice(i, 1);
                this.products.splice(i, 1);
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            throw new ShoppingCartException("No se ha enontrado el producto a eliminar");
        }   
    }

    calculateTotal(){
        let total =0;
        for(let i =0; i < this.proxies.length; i++){
            let pPc = this.proxies[i]._cantidad * this.products[i]._pricePerUnit;
            total += pPc;
        }
        return total;
    }
    agregarProxy(proxy) {
        this._proxies.push(proxy);
    }
}

class ProductProxy{
    constructor(uuid, cantidad){
        this._uuid = uuid;
        this._cantidad = cantidad;
    }
}

module.exports = ShoppingCart;
module.exports = ProductProxy;