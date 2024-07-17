import { useRef, useContext } from 'react';
import { AppContext } from '../AppContext';

export default function Product() {
    // console.log("Product");
    const pItemInput = useRef();
    const {pItems, addItem} = useContext(AppContext);

    function addProduct() {
        console.log(pItemInput.current.value);

        if (pItems.includes(pItemInput.current.value)) {
            alert ("Item already on Product List!");
        } else {
            addItem(pItemInput.current.value);
        }
        pItemInput.current.value = "";
    }


    return(<>
        <h1>Add Product</h1>
        <input type="text" ref={pItemInput} />
        <button onClick={addProduct}>Add to List</button>
        </>)
}