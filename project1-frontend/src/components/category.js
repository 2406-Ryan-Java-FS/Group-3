import { useState, useEffect } from "react";

export default function Category() {
    
    const [categories, setCategories] = useState([]);

    const categoryContainer = categories.map(c =>
            <tr key={c.id}>
                <td>{c.id}</td>
                <td>{c.name}</td>
            </tr>
    ); 
    
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


    return (<>
        <table id="categoryList"> 
            <thead>
                <tr>
                    <td><h1>Categories List</h1></td>
                </tr>
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                </tr>
            </thead>
            <tbody>
                {categoryContainer}
            </tbody>
        </table>        
    </>)
}