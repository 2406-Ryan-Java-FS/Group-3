import { useState, useEffect, useContext } from "react";
import { AppContext } from "../AppContext";

export default function ProductList() {
    // console.log("Product List");
    const [products, setProducts] = useState([]);
    const {addToCart} = useContext(AppContext)
    
    const productContainer = products.map(p =>
        <div key={p.id}>
            {p.name} <br />
            {p.description} <br />
            {p.price} <br />
            <button onClick={handleAddToCart}>Add to Cart</button>
        </div>
    );

    function handleAddToCart() {
        addToCart(products);
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