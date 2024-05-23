class ProductException {
    constructor(errorMessage) {
        this.errorMessage = errorMessage;
    }
}

class Product {
    constructor(title, description, imageUrl, unit, stock, pricePerUnit, category) {
        this.uuid = generateUUID();
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.unit = unit;
        this.stock = stock;
        this.pricePerUnit = pricePerUnit;
        this.category = category;
    }

    set uuid(x) {
        throw new ProductException("Product UUIDs are auto-generated.");
        
    }

    get uuid() {
        return this.uuid;
    }

    set title(x){
        if(x == null || typeof(x) != 'string'){
            throw new ProductException("Debes ingresar un título válido"); 
        }else{
            this.title = x;
        }
    }

    get title(){
        return this.title;
    }

    set description(x){
        if(x == null || typeof(x) != 'string'){
            throw new ProductException("Debes ingresar una descripción válida");
        }else{
            this.description = x;
        }
    }

    get description(){
        return this.description;
    }

    set imageURL(x){
        if(x == null || typeof(x) != 'string'){
            throw new ProductException("Debes ingresar una URL válida");
        }else{
            this.imageURL = x;
        }
    }

    get imageURL(){
        return this.imageURL;
    }

    set unit(x){
        if(x == null || typeof(x) != 'string'){
            throw new ProductException("Debes ingresar una unidad válida");
        }else{
            this.unit = x;
        }
    }

    get unit(){
        return this.unit;
    }

    set stock(x){
        if(x == null || typeof(x) != 'number'){
            throw new ProductException("Debes ingresar un stock válido");
        }else{
            this.stock = x;
        }
    }

    get stock(){
        return this.stock;
    }

    set pricePerUnit(x){
        if(x == null || typeof(x) != 'number'){
            throw new ProductException("Debes ingresar un precio unitario válido");
        }else{
            this.pricePerUnit = x;
        }
    }

    get pricePerUnit(){
        return this.pricePerUnit;
    }

    set category(x){
        if(x == null || typeof(x) != 'string'){
            throw new ProductException("Debes ingresar una categoría válida");
        }else{
            this.category = x;
        }
    }
    
    get category(){
        return this.category;
    }

    static createFromJson(jsonValue){
        let obj = JSON.parse(jsonValue);
        return new Product(
            obj.uuid,
            obj.title,
            obj.description,
            obj.imageURL,
            obj.unit,
            obj.stock,
            obj.pricePerUnit,
            obj.category

        );
    }

    static createFromObject(obj){
        Product.cleanObject(obj);
        return new Product(
            obj.uuid,
            obj.title,
            obj.description,
            obj.imageURL,
            obj.unit,
            obj.stock,
            obj.pricePerUnit,
            obj.category

        );
    }

    static cleanObject(obj) {
        let validKeys = Object.keys(new Product());
        let objKeys = Object.keys(obj);

        for (let k in objKeys) {
            let key = objKeys[k];
            if (!validKeys.includes(key)) {
                let propertyName = objKeys[k];
                delete obj[propertyName]; 
            }
        }
    }
}


module.exports = Product;
