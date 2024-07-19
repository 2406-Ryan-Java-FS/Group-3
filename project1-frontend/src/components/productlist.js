import { useState, useEffect } from "react";

export default function ProductList() {
    // console.log("Product List");
    const [products, setProducts] = useState([]);
    
    const productContainer = products.map(p =>
        <div key={p.id}>
            {p.name} <br />
            {p.description} <br />
            {p.price} <br />
            <button onClick={addToCart}>Add to Cart</button>
        </div>
    );

    function addToCart() {
        
    }
     
    async function getAllProducts() {
        console.log("Getting Products...")

        const url = "http://localhost:8080/products";
        const httpResponse = await fetch(url);
        console.log(httpResponse)
        const productList = await httpResponse.json();

        setProducts(productList);
    }

    useEffect(() =>{
        getAllProducts();
    },[]); 
        
    return(<>
        <h1>Product List</h1>
        <div className="grid-container">
            <div className="grid-item">
                {productContainer} 
            </div>            
        </div>
    </>);
}