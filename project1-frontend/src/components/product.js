import { useRef, useContext, useEffect, useState } from 'react';
import { AppContext } from '../AppContext';

export default function Product() {
    // console.log("Product");
    const pItemInput = useRef();
    const {pItems, addPItem} = useContext(AppContext);

    const pDescInput = useRef();
    const {pDesc, addPDesc} = useContext(AppContext);

    const pPriceInput = useRef();
    const {pPrice, addPPrice} = useContext(AppContext);

    const [categories, setCategories] = useState([]);

    const categoryContainer = categories.map(c =>
        <option key={c.id} value={c.id}>{c.name}</option>
    );

    const handleChange = (event) => {
        setCategories(event.target.value);
        console.log("Selected value:", event.target.value)
    }
    
    function addProduct() {
        console.log(pItemInput.current.value);

        if (pItems.includes(pItemInput.current.value)) {
            alert ("Item already on Product List!");
        } else {
            addPItem(pItemInput.current.value);
            addPDesc(pDescInput.current.value);
            addPPrice(pPriceInput.current.value);
        }
        pItemInput.current.value = "";
        pDescInput.current.value = "";
        pPriceInput.current.value = "";

           
    }

    async function getAllCategories() {
        console.log("Getting Categories...");
        const url = "http://localhost:8080/categories"
        const httpResponse = await fetch(url);
        console.log(httpResponse);
        const categories = await httpResponse.json();

        setCategories(categories);
    }

    useEffect(() =>{
        getAllCategories();
    },[]);


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
                <td><input type="text" ref={pDescInput} /></td>
            </tr>
            <tr>
                <th>Price:</th>
                <td><input type="number" ref={pPriceInput} /></td>
            </tr>
            {/* <tr>
                <th>Category:</th>
                <td>
                    <select value="categories" onChange={handleChange}>
                        <option>Please Select One Option... </option>
                        {categoryContainer}
                    </select>
                </td>
                
            </tr> */
            <tr>
                <td colSpan={2} align="center">
                    <button onClick={addProduct}>Add to List</button>
                </td>
            </tr>}
            </tbody>
        </table>
        
        </>)
}