import { useRef } from "react";

export default function AddCategory() {

    const categoryName = useRef();

    async function addCategory(categoryName) {

        const response=await fetch(`http://localhost:8080/categories`,{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify({
                "name":categoryName
            })
        })

        const newCategoryCreated = await response.json();
        console.log(`New Category: ${newCategoryCreated}`);
    }

    function createCatergory() {
        console.log(categoryName.current.value);
        addCategory(categoryName.current.value);
    }

    return(<>
        <table>
            <thead>
            <tr>
                <td colSpan={2}><h1>Add Category</h1></td>
                </tr>
            </thead>
            <tbody>
            <tr>
                <td>Name</td>
                <input type="text" ref={categoryName} />
            </tr>
            <tr>
                <td colSpan={2}>
                    <button onClick={createCatergory}>Add Category</button>
                </td>
            </tr>
            </tbody>
        </table>

    </>)
}