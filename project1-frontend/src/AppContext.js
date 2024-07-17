import { createContext, useState } from 'react';

export const AppContext = createContext();

export default function AppProvider({ children }) {

    //Here is where you can setup and create 'state' or any data
    //you want your Components to have access to.
    const [quantity, setQuantity] = useState(0);
    const [pItems, setPItems] = useState([]);

    function updateQuantity(newQuantity) {
        setQuantity(newQuantity);
    }

    function addPItem (newPItem) {
        setPItems(newPItem);
    }

    const data = {
        quantity: quantity,
        updateQuantity: updateQuantity,
        pItems : pItems,
        addPItem : addPItem        
    }

    return (
        <AppContext.Provider value={data} >
            {children}
        </AppContext.Provider>
    );

}