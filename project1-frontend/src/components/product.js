import { useRef } from 'react';
import ProductList from './productlist';
// import { AppContext } from '../AppContext';

export default function Product() {
    // console.log("Product");
    const pItemInput = useRef();
    const pDescInput = useRef();
    const pPriceInput = useRef()
    const pCategoryIdInput = useRef();

    async function addProduct(pName, pDesc, pPrice, pCategoryId) {
        const response = await fetch(`http://localhost:8080/products`,{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify({
                "name":pName,
                "description":pDesc,
                "price":pPrice,
                "category":pCategoryId
            })   
        })

        const newProductCreated = await response.json();
        console.log(`New Product: ${newProductCreated}`)
    }
    
    function createProduct() {
        console.log(pItemInput.current.value);
        console.log(pDescInput.current.value);
        console.log(pPriceInput.current.value);
        console.log(pCategoryIdInput.current.value);

        // if (ProductList.productList.includes(pItemInput.current.value)) {
        //     alert ("Item already on Product List!");
        // } else {
            addProduct(pItemInput.current.value, 
                pDescInput.current.value, 
                pPriceInput.current.value,
                pCategoryIdInput.current.value);
            
        pItemInput.current.value = "";
        pDescInput.current.value = "";
        pPriceInput.current.value = "";
        pCategoryIdInput.current.value = "";    
    }

    return(<>
        <table>
            <thead>
            <tr>
                <td colSpan={2}>
                    <h1>Add Product</h1>
                </td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>Name:</th>
                <td><input type="text" ref={pItemInput} /></td>
            </tr>
            <tr>
                <th>Description:</th>
                <td><input type="textbox" ref={pDescInput} /></td>
            </tr>
            <tr>
                <th>Price:</th>
                <td><input type="number" ref={pPriceInput} /></td>
            </tr>
            <tr>
                <th>Category Id:</th>
                <td><input type="number" ref={pCategoryIdInput} /></td>
            </tr>
            <tr>
                <td colSpan={2} align="center">
                    <button onClick={createProduct}>Add to List</button>
                </td>
            </tr>
            </tbody>
        </table>
        
    </>)
}